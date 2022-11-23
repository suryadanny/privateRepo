from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Block(_message.Message):
    __slots__ = ["blockId", "slaves"]
    BLOCKID_FIELD_NUMBER: _ClassVar[int]
    SLAVES_FIELD_NUMBER: _ClassVar[int]
    blockId: str
    slaves: _containers.RepeatedCompositeFieldContainer[Slave]
    def __init__(self, blockId: _Optional[str] = ..., slaves: _Optional[_Iterable[_Union[Slave, _Mapping]]] = ...) -> None: ...

class CreateOrEditFileRequest(_message.Message):
    __slots__ = ["fileName", "fileSize"]
    FILENAME_FIELD_NUMBER: _ClassVar[int]
    FILESIZE_FIELD_NUMBER: _ClassVar[int]
    fileName: str
    fileSize: int
    def __init__(self, fileName: _Optional[str] = ..., fileSize: _Optional[int] = ...) -> None: ...

class FileIndexResponse(_message.Message):
    __slots__ = ["blocks", "filename"]
    BLOCKS_FIELD_NUMBER: _ClassVar[int]
    FILENAME_FIELD_NUMBER: _ClassVar[int]
    blocks: _containers.RepeatedCompositeFieldContainer[Block]
    filename: str
    def __init__(self, filename: _Optional[str] = ..., blocks: _Optional[_Iterable[_Union[Block, _Mapping]]] = ...) -> None: ...

class FileRequest(_message.Message):
    __slots__ = ["fileName"]
    FILENAME_FIELD_NUMBER: _ClassVar[int]
    fileName: str
    def __init__(self, fileName: _Optional[str] = ...) -> None: ...

class Slave(_message.Message):
    __slots__ = ["slaveId", "url"]
    SLAVEID_FIELD_NUMBER: _ClassVar[int]
    URL_FIELD_NUMBER: _ClassVar[int]
    slaveId: str
    url: str
    def __init__(self, slaveId: _Optional[str] = ..., url: _Optional[str] = ...) -> None: ...
