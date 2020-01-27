package com.github.akarazhev.tutorial.designpatterns.composite;

import com.github.akarazhev.tutorial.designpatterns.builder.Validator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Stream;

public abstract class Config {

    private final Collection<Config> configs = new LinkedList<>();

    public void add(final Config config) {
        configs.add(Validator.of(config).get());
    }

    public Stream<Config> getConfigs() {
        return configs.stream();
    }

    public int size() {
        return configs.size();
    }
}
