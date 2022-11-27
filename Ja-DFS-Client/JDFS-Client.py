import os.path

import grpc

from master_pb2 import FileRequest
from master_pb2 import CreateOrEditFileRequest
from master_pb2_grpc import IndexServiceStub
from slave_pb2_grpc import DataStorageServiceStub
from slave_pb2 import ViewFileRequest
from slave_pb2 import FileStorageRequest
import sys


class JdfsClient:

    def __init__(self, master_url):
        self.master_url = master_url
        print(self.master_url)

    def getfile(self, file_name):
        channel = grpc.insecure_channel(self.master_url)
        index_service = IndexServiceStub(channel)
        request = FileRequest(fileName=file_name)

        print('here2')
        indexed_file_details = index_service.getFileDetails(request)
        print(str(indexed_file_details))
        print("blocks available : " + str(len(indexed_file_details.blocks)))
        if len(indexed_file_details.blocks) > 0:
            for block in indexed_file_details.blocks:
                for slave in block.slaves:
                    slave_channel = grpc.insecure_channel(slave.url)
                    storage_service = DataStorageServiceStub(slave_channel)
                    print('getting block id : ' + str(block.blockId))
                    file_request = ViewFileRequest(partitionName=block.blockId)
                    file_data = storage_service.getFile(file_request)
                    if file_data.data:
                        print(file_data.data)
                        print('done')
                        break
                print('Next block')

    def put_file(self, source, dest):
        size = os.path.getsize(source)
        channel = grpc.insecure_channel(self.master_url)
        index_service = IndexServiceStub(channel)
        request = CreateOrEditFileRequest(fileName=dest, fileSize=size)
        partitions = index_service.putFilesDetails(request)
        chunk = 100
        blocks = len(partitions.blocks)
        with open(source) as file:
            for block in partitions.blocks:
                data = file.read(chunk)
                if len(block.slaves) > 0:
                    slave = block.slaves[0]
                    slave_channel = grpc.insecure_channel(slave.url)
                    slave_service = DataStorageServiceStub(slave_channel)
                    storage_request = FileStorageRequest(partitionName=block.blockId, data=data,
                                                         slaves=block.slaves[1:])
                    response = slave_service.putFile(storage_request)
                    if response.saved:
                        print('block saved successfully')
                blocks -= 1
                print(' %s blocks left', str(blocks))


def main(args):
    client = JdfsClient("127.0.0.1:50052")
    print('here')
    if args[1] == str("GET"):
        client.getfile(args[2])
    elif args[1] == str("PUT"):
        client.put_file(args[2], args[3])
    else:
        print("please enter relevant arguments")


if __name__ == "__main__":
    main(sys.argv[1:])
