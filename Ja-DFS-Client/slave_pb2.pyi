from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class ErrorRespone(_message.Message):
    __slots__ = ["reason"]
    REASON_FIELD_NUMBER: _ClassVar[int]
    reason: str
    def __init__(self, reason: _Optional[str] = ...) -> None: ...

class FileStorageRequest(_message.Message):
    __slots__ = ["data", "partitionName", "slaves"]
    DATA_FIELD_NUMBER: _ClassVar[int]
    PARTITIONNAME_FIELD_NUMBER: _ClassVar[int]
    SLAVES_FIELD_NUMBER: _ClassVar[int]
    data: bytes
    partitionName: str
    slaves: _containers.RepeatedCompositeFieldContainer[Slave]
    def __init__(self, partitionName: _Optional[str] = ..., data: _Optional[bytes] = ..., slaves: _Optional[_Iterable[_Union[Slave, _Mapping]]] = ...) -> None: ...

class FileStorageResponse(_message.Message):
    __slots__ = ["saved"]
    SAVED_FIELD_NUMBER: _ClassVar[int]
    saved: bool
    def __init__(self, saved: bool = ...) -> None: ...

class Slave(_message.Message):
    __slots__ = ["slaveId", "url"]
    SLAVEID_FIELD_NUMBER: _ClassVar[int]
    URL_FIELD_NUMBER: _ClassVar[int]
    slaveId: str
    url: str
    def __init__(self, slaveId: _Optional[str] = ..., url: _Optional[str] = ...) -> None: ...

class ViewFileRequest(_message.Message):
    __slots__ = ["partitionName"]
    PARTITIONNAME_FIELD_NUMBER: _ClassVar[int]
    partitionName: str
    def __init__(self, partitionName: _Optional[str] = ...) -> None: ...

class ViewFileResponse(_message.Message):
    __slots__ = ["data"]
    DATA_FIELD_NUMBER: _ClassVar[int]
    data: bytes
    def __init__(self, data: _Optional[bytes] = ...) -> None: ...
