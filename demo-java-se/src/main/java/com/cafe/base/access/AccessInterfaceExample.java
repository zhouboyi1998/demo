package com.cafe.base.access;

/**
 * @Project: demo
 * @Package: com.cafe.base.access
 * @Author: zhouboyi
 * @Date: 2024/12/20 18:12
 * @Description: 访问权限级别修饰符 (接口中所有属性、方法的访问权限级别都是公共级别)
 */
public interface AccessInterfaceExample {

    /**
     * 接口属性 (public static final 修饰符可以省略)
     */
    public static final String PUBLIC = "interface public field";

    /**
     * 抽象方法 (public abstract 修饰符可以省略)
     */
    public abstract String publicMethod();

    /**
     * 默认方法 (public 修饰符可以省略)
     * 在接口中定义默认方法时, 只有 public 修饰符表示的是访问权限级别
     * default 修饰符表示的是默认方法, 而不是访问权限级别
     */
    public default String defaultMethod() {
        return "interface public default method";
    }
}
