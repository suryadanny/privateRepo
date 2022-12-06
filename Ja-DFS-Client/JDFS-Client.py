import os.path
from typing import Iterable

import grpc

from master_pb2 import FileRequest
from master_pb2 import CreateOrEditFileRequest
from master_pb2_grpc import IndexServiceStub
from slave_pb2_grpc import DataStorageServiceStub
from slave_pb2 import ViewFileRequest
from slave_pb2 import FileStorageRequest
from slave_pb2 import Slave
import sys


def get_stream(file, chunk, blockId, slaves):
    for i in range(0,6):
        data = file.read(chunk)
        print('yield happened')
        print(type(data))
        yield FileStorageRequest(partitionName=blockId, data=bytes(data), slaves=slaves)


class JdfsClient:

    def __init__(self, master_url):
        self.master_url = master_url
        print(self.master_url)

    def getfile(self, file_name, dest):
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
                    block_saved = False
                    slave_channel = grpc.insecure_channel(slave.url)
                    storage_service = DataStorageServiceStub(slave_channel)
                    print('getting block id : ' + str(block.blockId))
                    file_request = ViewFileRequest(partitionName=block.blockId)
                    file_data = storage_service.getFile(file_request)
                    with open(dest, 'ab') as dest_file:
                        for response in file_data.data:
                            print(response.data)
                            dest_file.write(response)
                            print('done')
                        block_saved = True
                    if block_saved:
                        break
                print('Next block')

    def put_file(self, source, dest):
        size = os.path.getsize(source)
        channel = grpc.insecure_channel(self.master_url)
        index_service = IndexServiceStub(channel)
        request = CreateOrEditFileRequest(fileName=dest, fileSize=size)
        partitions = index_service.putFilesDetails(request)
        chunk = 8192
        blocks = len(partitions.blocks)
        print(str(blocks) + ' Blocks to delivered : ' + str(partitions.blocks))
        print("src : " + source)
        with open(source, 'rb') as file:
            for block in partitions.blocks:
                if len(block.slaves) > 0:
                    slave = block.slaves[0]
                    slave_channel = grpc.insecure_channel(slave.url)
                    slave_service = DataStorageServiceStub(slave_channel)
                    slaves = [Slave(slaveId=slave.slaveId, url=slave.url) for slave in block.slaves[1:]]
                    iterator = get_stream(file=file, chunk=chunk, blockId=block.blockId, slaves=slaves)
                    print("iterator  type : "+str(type(iterator)))
                    # tp = next(iterator)
                    # print('here-call : ' + str(tp))
                    # print("request type :" + str(type(tp)))
                    response = slave_service.putFile(iterator.__iter__())
                    if response.saved:
                        print('block saved successfully')
                blocks -= 1
                print('{} blocks left'.format(str(blocks)))


def main(args):
    client = JdfsClient("127.0.0.1:50052")
    print('here')
    print(args[1])
    if args[0] == str("GET"):
        client.getfile(args[1], args[2])
    elif str(args[0]) == str("PUT"):
        client.put_file(args[1], args[2])
    else:
        print("please enter relevant arguments")


if __name__ == "__main__":
    main(sys.argv[1:])
