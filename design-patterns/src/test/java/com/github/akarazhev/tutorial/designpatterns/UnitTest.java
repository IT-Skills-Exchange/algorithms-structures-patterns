package com.github.akarazhev.tutorial.designpatterns;

import com.github.akarazhev.tutorial.designpatterns.builder.Property;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    protected <T> void assertPrivate(Class<T> clazz) throws NoSuchMethodException {
        final Constructor constructor = clazz.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        assertThrows(InvocationTargetException.class, constructor::newInstance);
        constructor.setAccessible(false);
    }
}
