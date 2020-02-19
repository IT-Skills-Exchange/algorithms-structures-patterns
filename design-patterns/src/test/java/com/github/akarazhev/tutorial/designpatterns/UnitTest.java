package com.github.akarazhev.tutorial.designpatterns;

import com.github.akarazhev.tutorial.designpatterns.builder.Property;
import org.h2.jdbcx.JdbcConnectionPool;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides basic tests
 */
public class UnitTest {

    protected Property getProperty() {
        return new Property.Builder("Property-1", "Value-1").
                caption("Caption").
                description("Description").
                attribute("key_1", "value_1").
                attributes(Collections.singletonMap("key_2", "value_2")).
                property(new String[0], new Property.Builder("Sub-property-1", "Sub-value-1").build()).
                build();
    }

    protected void assertGetSchema() throws Exception {
        final var pool =
                JdbcConnectionPool.create("jdbc:h2:tcp://localhost:8043/./db/tutorial", "sa", "sa");
        final var connection = pool.getConnection();
        assertEquals("PUBLIC", connection.getSchema());
        connection.close();
        pool.dispose();
    }
}
