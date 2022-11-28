Ja-DFS is small scale distributed file system , The project consists of three components Masters, Slave , Client. The projects is implemented using Grpc library and using Protobuffs

The advantage of using protocol buffers is that they make interoperability between polyglot applications/services much simpler- as can be seen between the python based client and java based server side application. The proto files that were used to created the service side components ,can also be leveraged to create client-side stubs as well ,thus reducing the required effort.

The service consists of two components - 

1) master service - Takes a given file and assigns multiple partition id , and slave server details , across which they would be stored. this indexing information would be stored maintained with the master service for further accessibility by the client on requirement.

2) Slave Service - Multiple slave applicaitons can be deployed across multiple locations, These urls would be part of Master services slave server details. the client would push the every individuval part of the file(a predetermined block of data) to multiple slave servers to create redundancy and replication of data.

3) Client- Two function - GET and PUT file
     PUT - Initially calls master service - to recieve allocation details of each individuval partition of the file. In accordance with these details the client the calls the slave servers and streams the data to the relevant slave service.
