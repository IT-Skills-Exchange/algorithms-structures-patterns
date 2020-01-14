package com.github.akarazhev.tutorial.designpatterns.builder;

import com.github.akarazhev.tutorial.designpatterns.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The property model that contains parameters, attributes and properties test.
 */
@DisplayName("Property test")
final class PropertyTest extends UnitTest {

    @Test
    @DisplayName("Create a property")
    void createProperty() {
        final var property = new Property.Builder("Property", "Value").build();
        // Check test results
        assertEquals("Property", property.getName());
        assertEquals(Property.Type.STRING, property.getType());
        assertEquals("Value", property.getValue());
        assertThrows(ClassCastException.class, property::asBool);
        assertThrows(ClassCastException.class, property::asDouble);
        assertThrows(ClassCastException.class, property::asLong);
        assertFalse(property.getCaption().isPresent());
        assertFalse(property.getDescription().isPresent());
        assertTrue(property.getAttributes().isPresent());
        assertTrue(property.getAttributes().get().isEmpty());
        assertFalse(property.getAttribute("key").isPresent());
        assertEquals(0, property.getAttributeKeys().count());
    }

    @Test
    @DisplayName("Create a property with parameters")
    void createPropertyWithParameters() {
        final var firstSubProperty = new Property.Builder("Sub-Property-1", "Sub-Value-1").build();
        final var secondSubProperty = new Property.Builder("Sub-Property-2", "Sub-Value-2").build();
        final var thirdSubProperty = new Property.Builder("Sub-Property-3", "Sub-Value-3").build();
        final var property = new Property.Builder("Property", "Value").
                caption("Caption").
                description("Description").
                attributes(Collections.singletonMap("key", "value")).
                property(new String[0], firstSubProperty).
                properties(new String[0], Collections.singletonList(secondSubProperty)).
                properties(Collections.singletonList(thirdSubProperty)).
                build();
        // Check test results
        assertEquals("Property", property.getName());
        assertEquals(Property.Type.STRING, property.getType());
        assertEquals("Value", property.getValue());
        assertTrue(property.getCaption().isPresent());
        assertEquals("Caption", property.getCaption().get());
        assertTrue(property.getDescription().isPresent());
        assertEquals("Description", property.getDescription().get());
        assertTrue(property.getAttributes().isPresent());
        assertEquals(1, property.getAttributes().get().size());
        assertEquals(1, property.getAttributeKeys().count());
        assertTrue(property.getAttribute("key").isPresent());
        assertEquals(3, property.getProperties().count());
        assertTrue(property.getProperty("Sub-Property-1").isPresent());
        assertTrue(property.getProperty("Sub-Property-2").isPresent());
        assertTrue(property.getProperty("Sub-Property-3").isPresent());
    }

    @Test
    @DisplayName("Create a property with property by the empty path")
    void createPropertyWithPropertyByEmptyPath() {
        final var property = new Property.Builder("Property", "Value").
                property(new String[0], new Property.Builder("Sub-property", "Sub-value").build()).build();
        // Check test results
        assertEquals("Property", property.getName());
        assertEquals(Property.Type.STRING, property.getType());
        assertEquals("Value", property.getValue());
        final var subProperty = property.getProperty("Sub-property");
        assertTrue(subProperty.isPresent());
        assertEquals("Sub-property", subProperty.get().getName());
    }

    @Test
    @DisplayName("Create a property with property by the single path")
    void createPropertyWithPropertyBySinglePath() {
        final var property = new Property.Builder("Property", "Value").
                property(new String[]{"Sub-property-1"},
                        new Property.Builder("Sub-property-2", "Sub-value-2").build()).build();
        // Check test results
        assertEquals("Property", property.getName());
        assertEquals(Property.Type.STRING, property.getType());
        assertEquals("Value", property.getValue());
        // Check Sub-property-1
        final var firstSubProperty = property.getProperty("Sub-property-1");
        assertTrue(firstSubProperty.isPresent());
        assertEquals("Sub-property-1", firstSubProperty.get().getName());
        // Check Sub-property-2
        final var secondSubProperty = firstSubProperty.get().getProperty("Sub-property-2");
        assertTrue(secondSubProperty.isPresent());
        assertEquals("Sub-property-2", secondSubProperty.get().getName());
        final var lastSubProperty = property.getProperty("Sub-property-1", "Sub-property-2");
        assertTrue(lastSubProperty.isPresent());
        assertEquals("Sub-property-2", lastSubProperty.get().getName());
    }

    @Test
    @DisplayName("Create a property with property by the multiple path")
    void createPropertyWithPropertyByMultiplePath() {
        final var property = new Property.Builder("Property", "Value").
                property(new String[]{"Sub-property-1", "Sub-property-2"},
                        new Property.Builder("Sub-property-3", "Sub-value-3").build()).build();
        // Check test results
        assertEquals("Property", property.getName());
        assertEquals(Property.Type.STRING, property.getType());
        assertEquals("Value", property.getValue());
        // Check Sub-property-1
        final var firstSubProperty = property.getProperty("Sub-property-1");
        assertTrue(firstSubProperty.isPresent());
        assertEquals("Sub-property-1", firstSubProperty.get().getName());
        // Check Sub-property-2
        final var secondSubProperty = firstSubProperty.get().getProperty("Sub-property-2");
        assertTrue(secondSubProperty.isPresent());
        assertEquals("Sub-property-2", secondSubProperty.get().getName());
        // Check Sub-property-3
        final var thirdSubProperty = secondSubProperty.get().getProperty("Sub-property-3");
        assertTrue(thirdSubProperty.isPresent());
        assertEquals("Sub-property-3", thirdSubProperty.get().getName());
    }

    @Test
    @DisplayName("Create a custom property")
    void createCustomProperty() {
        final var property = new Property.Builder("Property", Property.Type.STRING.name(), "Value").build();
        // Check test results
        assertEquals(Property.Type.STRING, property.getType());
        assertEquals("Value", property.getValue());
    }

    @Test
    @DisplayName("Create a bool property")
    void createBoolProperty() {
        final var property = new Property.Builder("Property", true).build();
        // Check test results
        assertEquals(Property.Type.BOOL, property.getType());
        assertTrue(property.asBool());
    }

    @Test
    @DisplayName("Create a double property")
    void createDoubleProperty() {
        final var property = new Property.Builder("Property", 0.0).build();
        // Check test results
        assertEquals(Property.Type.DOUBLE, property.getType());
        assertEquals(0.0, property.asDouble());
    }

    @Test
    @DisplayName("Create a long property")
    void createLongProperty() {
        final var property = new Property.Builder("Property", 0L).build();
        // Check test results
        assertEquals(Property.Type.LONG, property.getType());
        assertEquals(0L, property.asLong());
    }

    @Test
    @DisplayName("Compare a null property")
    void compareNullProperty() {
        // Check test results
        assertNotEquals(getProperty(), null);
    }

    @Test
    @DisplayName("Compare a property")
    void compareProperty() {
        final var firstProperty = getProperty();
        // Check test results
        assertEquals(firstProperty, firstProperty);
    }

    @Test
    @DisplayName("Compare two simple properties")
    void compareTwoSimpleProperties() {
        final var firstProperty = getProperty();
        final var secondProperty = getProperty();
        // Check test results
        assertEquals(firstProperty, secondProperty);
    }

    @Test
    @DisplayName("Compare two properties")
    void compareTwoProperties() {
        final var firstProperty = new Property.Builder("Property-1", "Value-1").
                caption("Caption").
                description("Description").
                attribute("key_1", "value_1").
                attributes(Collections.singletonMap("key_2", "value_2")).
                property(new String[0], new Property.Builder("Sub-property-1", "Sub-value-1").build()).
                build();
        final var secondProperty =  new Property.Builder("Property-1", "Value-1").
                caption("Caption").
                description("Description").
                attribute("key_1", "value_1").
                attributes(Collections.singletonMap("key_2", "value_2")).
                property(new String[0], new Property.Builder("Sub-property-1", "Sub-value-1").build()).
                build();
        // Check test results
        assertEquals(firstProperty, secondProperty);
    }

    @Test
    @DisplayName("Create a property via the builder")
    void createPropertyViaBuilder() {
        final var firstProperty = getProperty();
        final var secondProperty = new Property.Builder(firstProperty).build();
        // Check test results
        assertEquals(firstProperty, secondProperty);
    }
}
