package com.vinsguru.redisson.test;

import com.vinsguru.redisson.test.dto.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.redisson.api.RMap;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.TypedJsonJacksonCodec;

import java.util.List;
import java.util.Map;

public class Lec06MapTest extends BaseTest {

    @Test
    public void mapTest1(){
        RMap<String, String> map = client.getMap("user:1", StringCodec.INSTANCE);
        map.put("name", "sam");
        map.put("age", "10");
        map.put("city", "atlanta");
        Assertions.assertEquals("sam", map.get("name"));
        Assertions.assertEquals("10", map.get("age"));
        Assertions.assertEquals("atlanta", map.get("city"));
    }


    @Test
    public void mapTest2(){
        RMap<String, String> map = client.getMap("user:2", StringCodec.INSTANCE);
        Map<String, String> javaMap = Map.of("name", "jake", "age", "30", "city", "miami");
        map.putAll(javaMap);
        Assertions.assertEquals("jake", map.get("name"));
        Assertions.assertEquals("30", map.get("age"));
        Assertions.assertEquals("miami", map.get("city"));
    }

}