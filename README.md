# Ja-DFS - A Small Scale Distributed File System #


Ja-DFS is small scale distributed file system , The project consists of three components Masters, Slave , Client. The projects is implemented using Grpc library and using Protobuffs

The advantage of using protocol buffers is that they make interoperability between polyglot applications/services much simpler- as can be seen between the python based client and java based server side application. The proto files that were used to created the service side components ,can also be leveraged to create client-side stubs as well ,thus reducing the required effort.

The service consists of two components - 

1) master service - Takes a given file and assigns multiple partition id , and slave server details , across which they would be stored. this indexing information would be stored maintained with the master service for further accessibility by the client on requirement.

2) Slave Service - Multiple slave applicaitons can be deployed across multiple locations, These urls would be part of Master services slave server details. the client would push the every individuval part of the file(a predetermined block of data) to multiple slave servers to create redundancy and replication of data.

3) Client- Two function - GET and PUT file
     PUT - Initially calls master service - to recieve allocation details of each individuval partition of the file. In accordance with these details the client the calls the slave servers and streams the data to the relevant slave service.
     
     
## How to use JDFS ## 

**Requirements -**

Maven version >= 3.6
Java version >= 1.8

**Run the below command to build the JDFS application -**

mvn clean install

deploy the FAT jars created in the target folder on the location you want.



**Run below command to deploy JDFS-Master component -**

java -jar JDFS-Master-\<version\>.jar \<port where you want app to be deployed\>



**Run below command to deploy JDFS-Slave component -**

java -jar JDFS-Slave-\<version\>.jar \<port where you want app to be deployed\> \<absolute folder path where the partitioned files would be stored\>




## How to use JDFS-Client ##

**Use the below  command to generate stubs from the proto files**

**NOTE-** modfiy the parameters of the command according to your folder structure

python -m grpc_tools.protoc -I../../protos --python_out=. --pyi_out=. --grpc_python_out=. slave.proto


**Run the client using the following command-**

GET Request-
py JDFS-client.py GET \<destination filepath\> \<filename registered with master application\> 

PUT Request -
py JDFS-client.py PUT \<sorce file absolute filepath\> \<filename registered with the master application\>

