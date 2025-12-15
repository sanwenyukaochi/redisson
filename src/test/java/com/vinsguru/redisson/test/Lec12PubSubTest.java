package com.vinsguru.redisson.test;

import org.junit.jupiter.api.Test;
import org.redisson.api.RTopic;
import org.redisson.client.codec.StringCodec;

public class Lec12PubSubTest extends BaseTest {

    @Test
    public void subscriber1(){
        RTopic topic = this.client.getTopic("slack-room1", StringCodec.INSTANCE);
        topic.addListener(String.class, (channel, msg) -> {
            IO.println(msg);
        });
        sleep(600_000);
    }

}