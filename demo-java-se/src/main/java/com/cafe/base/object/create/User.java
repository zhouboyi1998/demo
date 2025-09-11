package com.cafe.base.object.create;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Project: demo
 * @Package: com.cafe.base.object.create
 * @Author: zhouboyi
 * @Date: 2025/4/24 16:42
 * @Description:
 */
@Data
@Accessors(chain = true)
public class User implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String name;

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
