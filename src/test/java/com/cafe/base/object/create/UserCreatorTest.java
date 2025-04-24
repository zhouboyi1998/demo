package com.cafe.base.object.create;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @Project: demo
 * @Package: com.cafe.base.object.create
 * @Author: zhouboyi
 * @Date: 2025/4/24 17:19
 * @Description: {@link UserCreator}
 */
public class UserCreatorTest {

    @Test
    void create() {
        User create = UserCreator.create();
        System.out.println(create);
    }

    @Test
    void reflect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        User reflect = UserCreator.reflect();
        System.out.println(reflect);
    }

    @Test
    void deserializable() throws IOException, ClassNotFoundException {
        User origin = new User().setName("origin");
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(origin);
        byte[] serialize = bs.toByteArray();
        User deserialize = UserCreator.deserializable(serialize);
        System.out.println(deserialize);
    }

    @Test
    void cloneable() throws CloneNotSupportedException {
        User origin = new User().setName("origin");
        User clone = UserCreator.cloneable(origin);
        System.out.println(clone);
    }

    @Test
    void methodHandle() throws Throwable {
        User methodHandle = UserCreator.methodHandle();
        System.out.println(methodHandle);
    }

    @Test
    void unsafe() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        User unsafe = UserCreator.unsafe();
        System.out.println(unsafe);
    }
}
