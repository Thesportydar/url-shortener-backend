package me.inaqui.urlshortener.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@SpringBootTest
class RedisConnectionDetailsTest {

    @Autowired
    private LettuceConnectionFactory connectionFactory;

    @Test
    void testRedisConnection() {
        // Verificar si podemos hacer "ping" al servidor Redis
        String pingResponse = connectionFactory.getConnection().ping();

        System.out.println("Redis Ping Response: " + pingResponse);
    }

    @Test
    void testRedisConnectionDetails() {
        System.out.println(connectionFactory.getHostName());
        System.out.println(connectionFactory.getPort());
        System.out.println(connectionFactory.getDatabase());
        System.out.println(connectionFactory.getTimeout());
    }
}