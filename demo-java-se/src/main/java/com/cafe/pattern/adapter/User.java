package com.cafe.pattern.adapter;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:53
 * @Description: 用户实体
 */
@Data
@Accessors(chain = true)
public class User {

    private Long id;

    private String phone;

    private String mail;
}
