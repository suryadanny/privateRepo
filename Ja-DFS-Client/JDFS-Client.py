import grpc

from master_pb2 import FileRequest
from master_pb2_grpc import IndexServiceStub
from slave_pb2_grpc import DataStorageServiceStub
from slave_pb2 import ViewFileRequest
from slave_pb2 import ViewFileResponse
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
                    data = ''
                    for resp in file_data:
                        data = resp.data
                    if data:
                        print(data)
                        print('done')
                        break
                print('Next block')


def main(args):
    client = JdfsClient("127.0.0.1:50052")
    print('here')
    client.getfile("test1")


if __name__ == "__main__":
    main(sys.argv[1:])
