package com.cafe.design.pattern;

import com.cafe.design.pattern.adapter.AdviceSender;
import com.cafe.design.pattern.adapter.Client;
import com.cafe.design.pattern.adapter.MailSender;
import com.cafe.design.pattern.adapter.SMSSender;
import com.cafe.design.pattern.adapter.User;
import com.cafe.design.pattern.adapter.clazz.AdviceClassAdapter;
import com.cafe.design.pattern.adapter.clazz.MailClassAdapter;
import com.cafe.design.pattern.adapter.clazz.SMSClassAdapter;
import com.cafe.design.pattern.adapter.object.AdviceObjectAdapter;
import com.cafe.design.pattern.adapter.object.MailObjectAdapter;
import com.cafe.design.pattern.adapter.object.SMSObjectAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.design.pattern.adapter.clazz
 * @Author: zhouboyi
 * @Date: 2024/11/1 17:22
 * @Description: {@link Client}
 */
class AdapterPatternTest {

    private Client client;

    private User user;

    @BeforeEach
    void setUp() {
        client = new Client();
        user = new User()
            .setId(1L)
            .setPhone("12345678910")
            .setMail("12345678910@qq.com");
    }

    // ----- Class Adapter Test -----

    @Test
    void sendAdviceByClassAdapter() {
        client.send(new AdviceClassAdapter(), user);
    }

    @Test
    void sendSMSByClassAdapter() {
        client.send(new SMSClassAdapter(), user);
    }

    @Test
    void sendMailByClassAdapter() {
        client.send(new MailClassAdapter(), user);
    }

    // ----- Object Adapter Test -----

    @Test
    void sendAdviceByObjectAdapter() {
        client.send(new AdviceObjectAdapter(new AdviceSender()), user);
    }

    @Test
    void sendSMSByObjectAdapter() {
        client.send(new SMSObjectAdapter(new SMSSender()), user);
    }

    @Test
    void sendMailByObjectAdapter() {
        client.send(new MailObjectAdapter(new MailSender()), user);
    }
}
