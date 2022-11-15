// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: master.proto

package com.demo.jdfs.master.stubs;

/**
 * Protobuf type {@code com.demo.jdfs.master.Block}
 */
public final class Block extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.demo.jdfs.master.Block)
    BlockOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Block.newBuilder() to construct.
  private Block(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Block() {
    blockId_ = "";
    slaves_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Block();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.demo.jdfs.master.stubs.Master.internal_static_com_demo_jdfs_master_Block_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.demo.jdfs.master.stubs.Master.internal_static_com_demo_jdfs_master_Block_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.demo.jdfs.master.stubs.Block.class, com.demo.jdfs.master.stubs.Block.Builder.class);
  }

  public static final int BLOCKID_FIELD_NUMBER = 1;
  private volatile java.lang.Object blockId_;
  /**
   * <code>string blockId = 1;</code>
   * @return The blockId.
   */
  @java.lang.Override
  public java.lang.String getBlockId() {
    java.lang.Object ref = blockId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      blockId_ = s;
      return s;
    }
  }
  /**
   * <code>string blockId = 1;</code>
   * @return The bytes for blockId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getBlockIdBytes() {
    java.lang.Object ref = blockId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      blockId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SLAVES_FIELD_NUMBER = 2;
  private java.util.List<com.demo.jdfs.master.stubs.Slave> slaves_;
  /**
   * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
   */
  @java.lang.Override
  public java.util.List<com.demo.jdfs.master.stubs.Slave> getSlavesList() {
    return slaves_;
  }
  /**
   * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.demo.jdfs.master.stubs.SlaveOrBuilder> 
      getSlavesOrBuilderList() {
    return slaves_;
  }
  /**
   * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
   */
  @java.lang.Override
  public int getSlavesCount() {
    return slaves_.size();
  }
  /**
   * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
   */
  @java.lang.Override
  public com.demo.jdfs.master.stubs.Slave getSlaves(int index) {
    return slaves_.get(index);
  }
  /**
   * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
   */
  @java.lang.Override
  public com.demo.jdfs.master.stubs.SlaveOrBuilder getSlavesOrBuilder(
      int index) {
    return slaves_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(blockId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, blockId_);
    }
    for (int i = 0; i < slaves_.size(); i++) {
      output.writeMessage(2, slaves_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(blockId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, blockId_);
    }
    for (int i = 0; i < slaves_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, slaves_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.demo.jdfs.master.stubs.Block)) {
      return super.equals(obj);
    }
    com.demo.jdfs.master.stubs.Block other = (com.demo.jdfs.master.stubs.Block) obj;

    if (!getBlockId()
        .equals(other.getBlockId())) return false;
    if (!getSlavesList()
        .equals(other.getSlavesList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + BLOCKID_FIELD_NUMBER;
    hash = (53 * hash) + getBlockId().hashCode();
    if (getSlavesCount() > 0) {
      hash = (37 * hash) + SLAVES_FIELD_NUMBER;
      hash = (53 * hash) + getSlavesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.demo.jdfs.master.stubs.Block parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.demo.jdfs.master.stubs.Block parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.demo.jdfs.master.stubs.Block parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.demo.jdfs.master.stubs.Block parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.demo.jdfs.master.stubs.Block prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.demo.jdfs.master.Block}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.demo.jdfs.master.Block)
      com.demo.jdfs.master.stubs.BlockOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.demo.jdfs.master.stubs.Master.internal_static_com_demo_jdfs_master_Block_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.demo.jdfs.master.stubs.Master.internal_static_com_demo_jdfs_master_Block_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.demo.jdfs.master.stubs.Block.class, com.demo.jdfs.master.stubs.Block.Builder.class);
    }

    // Construct using com.demo.jdfs.master.stubs.Block.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      blockId_ = "";

      if (slavesBuilder_ == null) {
        slaves_ = java.util.Collections.emptyList();
      } else {
        slaves_ = null;
        slavesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.demo.jdfs.master.stubs.Master.internal_static_com_demo_jdfs_master_Block_descriptor;
    }

    @java.lang.Override
    public com.demo.jdfs.master.stubs.Block getDefaultInstanceForType() {
      return com.demo.jdfs.master.stubs.Block.getDefaultInstance();
    }

    @java.lang.Override
    public com.demo.jdfs.master.stubs.Block build() {
      com.demo.jdfs.master.stubs.Block result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.demo.jdfs.master.stubs.Block buildPartial() {
      com.demo.jdfs.master.stubs.Block result = new com.demo.jdfs.master.stubs.Block(this);
      int from_bitField0_ = bitField0_;
      result.blockId_ = blockId_;
      if (slavesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          slaves_ = java.util.Collections.unmodifiableList(slaves_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.slaves_ = slaves_;
      } else {
        result.slaves_ = slavesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.demo.jdfs.master.stubs.Block) {
        return mergeFrom((com.demo.jdfs.master.stubs.Block)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.demo.jdfs.master.stubs.Block other) {
      if (other == com.demo.jdfs.master.stubs.Block.getDefaultInstance()) return this;
      if (!other.getBlockId().isEmpty()) {
        blockId_ = other.blockId_;
        onChanged();
      }
      if (slavesBuilder_ == null) {
        if (!other.slaves_.isEmpty()) {
          if (slaves_.isEmpty()) {
            slaves_ = other.slaves_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureSlavesIsMutable();
            slaves_.addAll(other.slaves_);
          }
          onChanged();
        }
      } else {
        if (!other.slaves_.isEmpty()) {
          if (slavesBuilder_.isEmpty()) {
            slavesBuilder_.dispose();
            slavesBuilder_ = null;
            slaves_ = other.slaves_;
            bitField0_ = (bitField0_ & ~0x00000001);
            slavesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getSlavesFieldBuilder() : null;
          } else {
            slavesBuilder_.addAllMessages(other.slaves_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              blockId_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 18: {
              com.demo.jdfs.master.stubs.Slave m =
                  input.readMessage(
                      com.demo.jdfs.master.stubs.Slave.parser(),
                      extensionRegistry);
              if (slavesBuilder_ == null) {
                ensureSlavesIsMutable();
                slaves_.add(m);
              } else {
                slavesBuilder_.addMessage(m);
              }
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object blockId_ = "";
    /**
     * <code>string blockId = 1;</code>
     * @return The blockId.
     */
    public java.lang.String getBlockId() {
      java.lang.Object ref = blockId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        blockId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string blockId = 1;</code>
     * @return The bytes for blockId.
     */
    public com.google.protobuf.ByteString
        getBlockIdBytes() {
      java.lang.Object ref = blockId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        blockId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string blockId = 1;</code>
     * @param value The blockId to set.
     * @return This builder for chaining.
     */
    public Builder setBlockId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      blockId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string blockId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBlockId() {
      
      blockId_ = getDefaultInstance().getBlockId();
      onChanged();
      return this;
    }
    /**
     * <code>string blockId = 1;</code>
     * @param value The bytes for blockId to set.
     * @return This builder for chaining.
     */
    public Builder setBlockIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      blockId_ = value;
      onChanged();
      return this;
    }

    private java.util.List<com.demo.jdfs.master.stubs.Slave> slaves_ =
      java.util.Collections.emptyList();
    private void ensureSlavesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        slaves_ = new java.util.ArrayList<com.demo.jdfs.master.stubs.Slave>(slaves_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.demo.jdfs.master.stubs.Slave, com.demo.jdfs.master.stubs.Slave.Builder, com.demo.jdfs.master.stubs.SlaveOrBuilder> slavesBuilder_;

    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public java.util.List<com.demo.jdfs.master.stubs.Slave> getSlavesList() {
      if (slavesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(slaves_);
      } else {
        return slavesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public int getSlavesCount() {
      if (slavesBuilder_ == null) {
        return slaves_.size();
      } else {
        return slavesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public com.demo.jdfs.master.stubs.Slave getSlaves(int index) {
      if (slavesBuilder_ == null) {
        return slaves_.get(index);
      } else {
        return slavesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder setSlaves(
        int index, com.demo.jdfs.master.stubs.Slave value) {
      if (slavesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSlavesIsMutable();
        slaves_.set(index, value);
        onChanged();
      } else {
        slavesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder setSlaves(
        int index, com.demo.jdfs.master.stubs.Slave.Builder builderForValue) {
      if (slavesBuilder_ == null) {
        ensureSlavesIsMutable();
        slaves_.set(index, builderForValue.build());
        onChanged();
      } else {
        slavesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder addSlaves(com.demo.jdfs.master.stubs.Slave value) {
      if (slavesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSlavesIsMutable();
        slaves_.add(value);
        onChanged();
      } else {
        slavesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder addSlaves(
        int index, com.demo.jdfs.master.stubs.Slave value) {
      if (slavesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSlavesIsMutable();
        slaves_.add(index, value);
        onChanged();
      } else {
        slavesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder addSlaves(
        com.demo.jdfs.master.stubs.Slave.Builder builderForValue) {
      if (slavesBuilder_ == null) {
        ensureSlavesIsMutable();
        slaves_.add(builderForValue.build());
        onChanged();
      } else {
        slavesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder addSlaves(
        int index, com.demo.jdfs.master.stubs.Slave.Builder builderForValue) {
      if (slavesBuilder_ == null) {
        ensureSlavesIsMutable();
        slaves_.add(index, builderForValue.build());
        onChanged();
      } else {
        slavesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder addAllSlaves(
        java.lang.Iterable<? extends com.demo.jdfs.master.stubs.Slave> values) {
      if (slavesBuilder_ == null) {
        ensureSlavesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, slaves_);
        onChanged();
      } else {
        slavesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder clearSlaves() {
      if (slavesBuilder_ == null) {
        slaves_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        slavesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public Builder removeSlaves(int index) {
      if (slavesBuilder_ == null) {
        ensureSlavesIsMutable();
        slaves_.remove(index);
        onChanged();
      } else {
        slavesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public com.demo.jdfs.master.stubs.Slave.Builder getSlavesBuilder(
        int index) {
      return getSlavesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public com.demo.jdfs.master.stubs.SlaveOrBuilder getSlavesOrBuilder(
        int index) {
      if (slavesBuilder_ == null) {
        return slaves_.get(index);  } else {
        return slavesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public java.util.List<? extends com.demo.jdfs.master.stubs.SlaveOrBuilder> 
         getSlavesOrBuilderList() {
      if (slavesBuilder_ != null) {
        return slavesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(slaves_);
      }
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public com.demo.jdfs.master.stubs.Slave.Builder addSlavesBuilder() {
      return getSlavesFieldBuilder().addBuilder(
          com.demo.jdfs.master.stubs.Slave.getDefaultInstance());
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public com.demo.jdfs.master.stubs.Slave.Builder addSlavesBuilder(
        int index) {
      return getSlavesFieldBuilder().addBuilder(
          index, com.demo.jdfs.master.stubs.Slave.getDefaultInstance());
    }
    /**
     * <code>repeated .com.demo.jdfs.master.Slave slaves = 2;</code>
     */
    public java.util.List<com.demo.jdfs.master.stubs.Slave.Builder> 
         getSlavesBuilderList() {
      return getSlavesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.demo.jdfs.master.stubs.Slave, com.demo.jdfs.master.stubs.Slave.Builder, com.demo.jdfs.master.stubs.SlaveOrBuilder> 
        getSlavesFieldBuilder() {
      if (slavesBuilder_ == null) {
        slavesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.demo.jdfs.master.stubs.Slave, com.demo.jdfs.master.stubs.Slave.Builder, com.demo.jdfs.master.stubs.SlaveOrBuilder>(
                slaves_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        slaves_ = null;
      }
      return slavesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.demo.jdfs.master.Block)
  }

  // @@protoc_insertion_point(class_scope:com.demo.jdfs.master.Block)
  private static final com.demo.jdfs.master.stubs.Block DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.demo.jdfs.master.stubs.Block();
  }

  public static com.demo.jdfs.master.stubs.Block getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Block>
      PARSER = new com.google.protobuf.AbstractParser<Block>() {
    @java.lang.Override
    public Block parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Block> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Block> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.demo.jdfs.master.stubs.Block getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

