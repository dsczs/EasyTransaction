package com.yiqiniu.easytrans.serialization.impl;

import com.yiqiniu.easytrans.serialization.ObjectSerializer;
import org.springframework.util.SerializationUtils;

public class SpringObjectSerialization implements ObjectSerializer {

    @Override
    public byte[] serialization(Object obj) {
        return SerializationUtils.serialize(obj);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T deserialize(byte[] bytes) {
        return (T) SerializationUtils.deserialize(bytes);
    }

}
