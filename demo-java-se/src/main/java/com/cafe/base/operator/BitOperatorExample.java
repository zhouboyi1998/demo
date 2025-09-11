package com.cafe.base.operator;

/**
 * @Project: demo
 * @Package: com.cafe.base.operator
 * @Author: zhouboyi
 * @Date: 2025/1/2 17:31
 * @Description: 位运算符
 */
public class BitOperatorExample {

    public static final byte A = 0b01101010;

    public static final byte B = 0b01010010;

    /**
     * 按位与运算
     */
    public static void and(byte a, byte b) {
        // 相同位上的数全为 1 -> 结果为 1, 否则 -> 结果为 0
        int and = a & b;
        System.out.println("AND:\t\t\t " + Integer.toBinaryString(and));
    }

    /**
     * 按位或运算
     */
    public static void or(byte a, byte b) {
        // 相同位上的数全为 0 -> 结果为 0, 否则 -> 结果为 1
        int or = a | b;
        System.out.println("OR: \t\t\t " + Integer.toBinaryString(or));
    }

    /**
     * 按位非运算
     */
    public static void not(byte a) {
        // 翻转所有位, 0 -> 1, 1 -> 0
        int not = ~a;
        // 数据会先转换成 int 类型, 再进行位运算, 运算结果也是 int 类型
        // 转换后的数据会有多余的前缀 0, 运算结果会有多余的前缀 1, 所以需要截取运算结果中最低的 8 位
        System.out.println("NOT:\t\t\t" + Integer.toBinaryString(not & 0xFF));
    }

    /**
     * 按位异或运算
     */
    public static void xor(byte a, byte b) {
        // 相同位上的数不同 -> 结果为 1, 相同 -> 结果为 0
        int xor = a ^ b;
        System.out.println("XOR:\t\t\t  " + Integer.toBinaryString(xor));
    }

    /**
     * 按位左移运算
     */
    public static void leftShift(byte a) {
        // 按位左移 1 位
        int leftShift = a << 1;
        System.out.println("LEFT SHIFT: \t" + Integer.toBinaryString(leftShift));
    }

    /**
     * 按位右移运算
     */
    public static void rightShift(byte a) {
        // 按位右移 1 位
        int rightShift = a >> 1;
        System.out.println("RIGHT SHIFT:\t  " + Integer.toBinaryString(rightShift));
    }

    public static void main(String[] args) {
        // A:   01101010
        // B:   01010010
        // AND: 01000010
        and(A, B);

        // A:   01101010
        // B:   01010110
        // OR:  01111010
        or(A, B);

        // A:   01101010
        // NOT: 10010101
        not(A);

        // A:   01101010
        // B:   01010010
        // XOR: 00111000
        xor(A, B);

        // A:           01101010
        // LEFT SHIFT:  11010100
        leftShift(A);

        // A:           01101010
        // RIGHT SHIFT: 00101010
        rightShift(A);
    }
}
