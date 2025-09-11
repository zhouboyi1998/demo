package com.cafe.base.type;

/**
 * @Project: demo
 * @Package: com.cafe.base.type
 * @Author: zhouboyi
 * @Date: 2024/12/20 0:24
 * @Description: Java 基本数据类型 (8 种基本数据类型, 以及对应的包装类)
 */
public class DataTypeExample {

    public static void main(String[] args) {
        // byte
        byte byteValue = 127;
        Byte byteObject = 127;

        // short (2 byte)
        short shortValue = 32767;
        Short shortObject = 32767;

        // int (4 byte)
        int intValue = 2147483647;
        Integer intObject = 2147483647;

        // long (8 byte)
        long longValue = 9223372036854775807L;
        Long longObject = 9223372036854775807L;

        // float (4 byte)
        float floatValue = 3.4028235E38F;
        Float floatObject = 3.4028235E38F;

        // double (8 byte)
        double doubleValue = 1.7976931348623157E308;
        Double doubleObject = 1.7976931348623157E308;

        // char (2 byte)
        char charValue = 'a';
        Character charObject = 'a';

        // boolean (1 byte)
        boolean booleanValue = true;
        Boolean booleanObject = true;

        // 打印
        System.out.println("byteValue:     " + byteValue);
        System.out.println("byteObject:    " + byteObject);

        System.out.println("shortValue:    " + shortValue);
        System.out.println("shortObject:   " + shortObject);

        System.out.println("intValue:      " + intValue);
        System.out.println("intObject:     " + intObject);

        System.out.println("longValue:     " + longValue);
        System.out.println("longObject:    " + longObject);

        System.out.println("floatValue:    " + floatValue);
        System.out.println("floatObject:   " + floatObject);

        System.out.println("doubleValue:   " + doubleValue);
        System.out.println("doubleObject:  " + doubleObject);

        System.out.println("charValue:     " + charValue);
        System.out.println("charObject:    " + charObject);

        System.out.println("booleanValue:  " + booleanValue);
        System.out.println("booleanObject: " + booleanObject);
    }
}
