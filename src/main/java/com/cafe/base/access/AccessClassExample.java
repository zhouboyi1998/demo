package com.cafe.base.access;

/**
 * @Project: demo
 * @Package: com.cafe.base.access
 * @Author: zhouboyi
 * @Date: 2024/12/20 18:12
 * @Description: 访问权限级别修饰符
 */
public class AccessClassExample {

    // -------------------- Field --------------------

    /**
     * 私有级别属性
     */
    private static final String PRIVATE = "class private field";

    /**
     * 默认级别属性 (不加任何访问权限级别修饰符, 就是默认级别)
     */
    static final String DEFAULT = "class default field";

    /**
     * 保护级别属性
     */
    protected static final String PROTECTED = "class protected field";

    /**
     * 公共级别属性
     */
    public static final String PUBLIC = "class public field";

    // -------------------- Method --------------------

    /**
     * 私有级别方法
     */
    private static String privateMethod() {
        return "class private method";
    }

    /**
     * 默认级别方法 (不加任何访问权限级别修饰符, 就是默认级别)
     */
    static String defaultMethod() {
        return "class default method";
    }

    /**
     * 保护级别方法
     */
    protected static String protectedMethod() {
        return "class protected method";
    }

    /**
     * 公共级别方法
     */
    public static String publicMethod() {
        return "class public method";
    }
}
