package com.example.springboot.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * 实现对象的序列化接口
 * @author Administrator
 *
 */
public class RedisObjectSerializer implements RedisSerializer<Object>{

	private Converter<Object,byte[]> serializer = new SerializingConverter();
	private Converter<byte[],Object> deserializer = new DeserializingConverter();
	
	static final byte[] EMPTY_ARRAY = new byte[0];
	
	@Override
	public byte[] serialize(Object paramT) throws SerializationException {
		if(paramT == null){
			return EMPTY_ARRAY;
		}
		return serializer.convert(paramT);
	}

	@Override
	public Object deserialize(byte[] paramArrayOfByte) throws SerializationException {
		if(isEmpty(paramArrayOfByte)){
			return null;
		}
		return deserializer.convert(paramArrayOfByte);
	}

	private boolean isEmpty(byte[] data){
		return (data == null || data.length == 0);
	}
}
