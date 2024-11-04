package com.cafe.pattern.adapter;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:44
 * @Description: 客户端
 */
public class Client {

    public void send(MessageHandler handler, User user) {
        handler.send("Hello, Adapter Pattern.", user);
    }
}
