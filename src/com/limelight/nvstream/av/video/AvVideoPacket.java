package com.limelight.nvstream.av.video;

import com.limelight.nvstream.av.AvByteBufferDescriptor;

public class AvVideoPacket {
	private AvByteBufferDescriptor buffer;
	private int refCount;
	
	public AvVideoPacket(AvByteBufferDescriptor rtpPayload)
	{
		buffer = new AvByteBufferDescriptor(rtpPayload);
	}
	
	public AvByteBufferDescriptor getNewPayloadDescriptor()
	{
		return new AvByteBufferDescriptor(buffer.data, buffer.offset+56, buffer.length-56);
	}
	
	public int addRef()
	{
		return ++refCount;
	}
	
	public int release()
	{
		return --refCount;
	}
}
