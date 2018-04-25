package cn.biz.student.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JRedisPoolConfig {

    public static Integer MAX_ACTIVE;
    public static Integer MAX_IDLE;
    public static Integer MAX_WAIT;
    public static Boolean TEST_ON_BORROW;
    public static Boolean TEST_ON_RETURN;
    public static String REDIS_IP;
    public static Integer REDIS_PORT;
    public static String REDIS_PASSWORD;

    static {
        InputStream inputStream = JRedisPoolConfig.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
            MAX_ACTIVE = Integer.parseInt(p.getProperty("redis.pool.maxActive"));
            MAX_IDLE = Integer.parseInt(p.getProperty("redis.pool.maxIdle"));
            MAX_WAIT = Integer.parseInt(p.getProperty("redis.pool.maxWait"));
            TEST_ON_BORROW = Boolean.parseBoolean(p.getProperty("redis.pool.testOnBorrow"));
            TEST_ON_RETURN = Boolean.parseBoolean(p.getProperty("redis.pool.testOnReturn"));
            REDIS_IP = p.getProperty("redis.ip");
            REDIS_PORT = Integer.parseInt(p.getProperty("redis.port"));
            REDIS_PASSWORD = p.getProperty("redis.password");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
