package com.cafe.base.operator;

/**
 * @Project: demo
 * @Package: com.cafe.base.operator
 * @Author: zhouboyi
 * @Date: 2025/1/2 20:47
 * @Description: 逻辑运算符
 */
public class LogicOperatorExample {

    public static final boolean A = true;

    public static final boolean B = false;

    /**
     * 逻辑与
     */
    public static void and(boolean a, boolean b) {
        // 两者均为 true -> 结果为 true, 否则 -> 结果为 false
        boolean and = a && b;
        System.out.println("AND: \t" + and);
    }

    /**
     * 逻辑或
     */
    public static void or(boolean a, boolean b) {
        // 两者均为 false -> 结果为 false, 否则 -> 结果为 true
        boolean or = a || b;
        System.out.println("OR: \t" + or);
    }

    /**
     * 逻辑非
     */
    public static void not(boolean a) {
        // 取反, true -> false, false -> true
        boolean not = !a;
        System.out.println("NOT: \t" + not);
    }

    public static void main(String[] args) {
        // true && false -> false
        and(A, B);

        // true || false -> true
        or(A, B);

        // !true -> false
        not(A);
    }
}
