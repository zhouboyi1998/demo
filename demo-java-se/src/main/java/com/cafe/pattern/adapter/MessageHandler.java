package com.cafe.pattern.adapter;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:48
 * @Description: 消息处理器接口
 */
public interface MessageHandler {

    /**
     * 发送消息
     *
     * @param content 消息内容
     * @param user    接收消息的用户
     */
    void send(String content, User user);
}
