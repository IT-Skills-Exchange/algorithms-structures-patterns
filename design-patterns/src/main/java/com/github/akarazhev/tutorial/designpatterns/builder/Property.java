package com.github.akarazhev.tutorial.designpatterns.builder;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The property model that contains parameters, attributes and properties.
 */
public final class Property extends AbstractConfig {
    private final String name;
    private final String caption;
    private final String description;
    private final Type type;
    private final String value;
    private final Map<String, String> attributes;
    private final Collection<Property> properties;

    public enum Type {
        BOOL,
        DOUBLE,
        LONG,
        STRING
    }

    private Property(final Builder builder) {
        this.name = builder.name;
        this.caption = builder.caption;
        this.description = builder.description;
        this.type = builder.type;
        this.value = builder.value;
        this.attributes = builder.attributes;
        this.properties = builder.properties;
    }

    /**
     * Returns a name of the property.
     *
     * @return a property name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a caption of the property (optional).
     *
     * @return a property caption.
     */
    public Optional<String> getCaption() {
        return Optional.ofNullable(caption);
    }

    /**
     * Returns a description of the property (optional).
     *
     * @return a property description.
     */
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    /**
     * Returns a value of the property.
     *
     * @return a property value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns a boolean value of the property.
     *
     * @return a property value.
     */
    public boolean asBool() {
        if (Type.BOOL.equals(type)) {
            return Boolean.parseBoolean(value);
        }

        throw new ClassCastException("Property has the different type: " + type);
    }

    /**
     * Returns a double value of the property.
     *
     * @return a property value.
     */
    public double asDouble() {
        if (Type.DOUBLE.equals(type)) {
            return Double.parseDouble(value);
        }

        throw new ClassCastException("Property has the different type: " + type);
    }

    /**
     * Returns a long value of the property.
     *
     * @return a property value.
     */
    public long asLong() {
        if (Type.LONG.equals(type)) {
            return Long.parseLong(value);
        }

        throw new ClassCastException("Property has the different type: " + type);
    }

    /**
     * Returns a type of the property.
     *
     * @return a property type.
     */
    public Type getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Map<String, String>> getAttributes() {
        return Optional.of(Collections.unmodifiableMap(attributes));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<String> getAttributeKeys() {
        return attributes.keySet().stream();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<String> getAttribute(final String key) {
        return Optional.ofNullable(attributes.get(Validator.of(key).get()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<Property> getProperties() {
        return properties.stream();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Property> getProperty(final String... paths) {
        return getProperty(0, paths, getProperties());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final var property = (Property) o;
        return Objects.equals(name, property.name) &&
                Objects.equals(caption, property.caption) &&
                Objects.equals(description, property.description) &&
                Objects.equals(type, property.type) &&
                Objects.equals(value, property.value) &&
                Objects.equals(attributes, property.attributes) &&
                Objects.equals(properties, property.properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, caption, description, type, value, attributes, properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", caption='" + caption + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

    Collection<Property> getProps() {
        return properties;
    }

    /**
     * Wraps and builds the instance of the property model.
     */
    public final static class Builder extends ConfigBuilder {
        private final String name;
        private String caption;
        private String description;
        private final Type type;
        private final String value;

        /**
         * Constructs a property model based on the property object.
         *
         * @param property a property model.
         */
        public Builder(final Property property) {
            final var prototype = Validator.of(property).get();
            this.name = prototype.name;
            this.caption = prototype.caption;
            this.description = prototype.description;
            this.type = prototype.type;
            this.value = prototype.value;
            this.attributes.putAll(prototype.attributes);
            this.properties.addAll(prototype.properties);
        }

        /**
         * Constructs a property model with required parameters.
         *
         * @param name  a property name.
         * @param value a string property value.
         */
        public Builder(final String name, final String value) {
            this.name = Validator.of(name).get();
            this.type = Type.STRING;
            this.value = Validator.of(value).get();
        }

        /**
         * Constructs a property model with required parameters.
         *
         * @param name  a property name.
         * @param type  a property type.
         * @param value a property value.
         */
        public Builder(final String name, final String type, final String value) {
            this.name = Validator.of(name).get();
            this.type = Type.valueOf(Validator.of(type).get());
            this.value = Validator.of(value).get();
        }

        /**
         * Constructs a property model with required parameters.
         *
         * @param name  a property name.
         * @param value a boolean property value.
         */
        public Builder(final String name, final boolean value) {
            this.name = Validator.of(name).get();
            this.type = Type.BOOL;
            this.value = String.valueOf(value);
        }

        /**
         * Constructs a property model with required parameters.
         *
         * @param name  a property name.
         * @param value a double property value.
         */
        public Builder(final String name, final double value) {
            this.name = Validator.of(name).get();
            this.type = Type.DOUBLE;
            this.value = String.valueOf(value);
        }

        /**
         * Constructs a property model with required parameters.
         *
         * @param name  a property name.
         * @param value a long property value.
         */
        public Builder(final String name, final long value) {
            this.name = Validator.of(name).get();
            this.type = Type.LONG;
            this.value = String.valueOf(value);
        }

        /**
         * Constructs a property model with the caption parameter.
         *
         * @param caption a property caption.
         * @return a builder of the property model.
         */
        public Builder caption(final String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * Constructs a property model with the description parameter.
         *
         * @param description a property description.
         * @return a builder of the property model.
         */
        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        /**
         * Constructs a property model with an attribute.
         *
         * @param key   a key of the attribute.
         * @param value a value of the attribute.
         * @return a builder of the property model.
         */
        public Builder attribute(final String key, final String value) {
            this.attributes.put(Validator.of(key).get(), Validator.of(value).get());
            return this;
        }

        /**
         * Constructs a property model with attributes.
         *
         * @param attributes property attributes.
         * @return a builder of the property model.
         */
        public Builder attributes(final Map<String, String> attributes) {
            this.attributes.putAll(Validator.of(attributes).get());
            return this;
        }

        /**
         * Constructs a property model with a property.
         *
         * @param paths    paths to a property.
         * @param property a property property.
         * @return a builder of the property model.
         */
        public Builder property(final String[] paths, final Property property) {
            return properties(paths, Collections.singletonList(Validator.of(property).get()));
        }

        /**
         * Constructs a property model with properties.
         *
         * @param paths      paths to a properties.
         * @param properties property properties.
         * @return a builder of the property model.
         */
        public Builder properties(final String[] paths, final Collection<Property> properties) {
            setProperties(paths, properties);
            return this;
        }

        /**
         * Constructs a property model with properties.
         *
         * @param properties property properties.
         * @return a builder of the property model.
         */
        public Builder properties(final Collection<Property> properties) {
            this.properties.addAll(Validator.of(properties).get());
            return this;
        }

        /**
         * Builds a property model with required parameters.
         *
         * @return a builder of the property model.
         */
        public Property build() {
            return new Property(this);
        }
    }
}
