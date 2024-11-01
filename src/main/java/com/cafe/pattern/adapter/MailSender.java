package com.cafe.pattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:19
 * @Description: 邮件发送器
 */
@Slf4j
public class MailSender {

    /**
     * 发送邮件消息
     *
     * @param content 消息内容
     * @param mail    目标邮箱
     */
    public void sendMail(String content, String mail) {
        log.info("send message [{}] to mail address [{}]", content, mail);
    }
}
