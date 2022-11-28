Ja-DFS is small scale distributed file system , The project consists of three components Masters, Slave , Client. The projects is implemented using Grpc library and using Protobuffs

The advantage of using protocol buffers is that they make interoperability between polyglot applications/services much simpler. The same proto files that were used to created the server side components ,can also be leveraged to create client-side stubs as well ,thus reducing the required effort
