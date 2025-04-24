package com.cafe.base.object.create;

import sun.misc.Unsafe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Project: demo
 * @Package: com.cafe.base.object.create
 * @Author: zhouboyi
 * @Date: 2025/4/24 16:40
 * @Description:
 */
public class UserCreator {

    public static User create() {
        return new User().setName("new");
    }

    public static User reflect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return User.class.getDeclaredConstructor().newInstance().setName("reflect");
    }

    public static User deserializable(byte[] serialize) throws IOException, ClassNotFoundException {
        return ((User) new ObjectInputStream(new ByteArrayInputStream(serialize)).readObject()).setName("deserialize");
    }

    public static User cloneable(User origin) throws CloneNotSupportedException {
        return origin.clone().setName("clone");
    }

    public static User methodHandle() throws Throwable {
        return ((User) MethodHandles.lookup().findConstructor(User.class, MethodType.methodType(void.class)).invoke()).setName("methodHandle");
    }

    public static User unsafe() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        return ((User) unsafe.allocateInstance(User.class)).setName("unsafe");
    }
}
