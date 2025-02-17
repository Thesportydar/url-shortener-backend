package me.inaqui.urlshortener.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String TEST_KEY = "testKey";
    private static final String TEST_VALUE = "testValue";

    @Test
    void testRedisSetAndGet() {
        // Obtenemos la operación de valores simples
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();

        // Guardar un valor en Redis
        valueOps.set(TEST_KEY, TEST_VALUE);

        // Recuperar el valor de Redis
        String retrievedValue = valueOps.get(TEST_KEY);

        // Comprobamos que el valor recuperado es igual al original
        assertThat(retrievedValue).isEqualTo(TEST_VALUE);
    }

    @Test
    void listRedisKeys() {
        Set<String> keys = redisTemplate.keys("*");
        System.out.println("Redis Keys: " + keys);
    }

    @Test
    void testRedisKeyWithDiagnostics() {
        // Guardar un valor en Redis con tiempo de expiración de 1 minuto
        redisTemplate.opsForValue().set(TEST_KEY, TEST_VALUE);

        // Confirmar que el valor está disponible
        assertThat(redisTemplate.opsForValue().get(TEST_KEY)).isEqualTo(TEST_VALUE);

        // Listar claves presentes
        Set<String> redisKeys = redisTemplate.keys("*");
        System.out.println("Redis Keys: " + redisKeys);

        // Comprobar TTL de la clave
        Long ttl = redisTemplate.getExpire(TEST_KEY);
        System.out.println("TTL for '" + TEST_KEY + "': " + ttl + " seconds");

        // Verificar si sigue disponible
        assertThat(redisTemplate.opsForValue().get(TEST_KEY)).isEqualTo(TEST_VALUE);
    }
}