# The Adapter Pattern

The pattern belongs to the structural category of the design patterns.

## Idea 

Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects 
and compositions of objects uniformly.

## Explanation

Wikipedia says:

> In software engineering, the composite pattern is a partitioning design pattern. The composite pattern describes that 
a group of objects is to be treated in the same way as a single instance of an object. The intent of a composite is 
to "compose" objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets 
clients treat individual objects and compositions uniformly.

In plain words:

> Composite pattern lets clients treat the individual objects in a uniform manner.

## Class Diagram

The class diagram will be:

![alt text](../etc/composite.png "Composite class diagram")

## Example

The task:

> Let's consider we have a general config object that contains user configs and they should have a uniform way of the processing.

Let's create a config interface:

```java
public interface Config {

    int getValue();

    String getName();
}
```

And the general config object will be:

```java
final class Configs implements Config {
    private final Collection<Config> configs = new LinkedList<>();

    public void add(final Config config) {
        configs.add(config);
    }

    public void remove(final Config config) {
        configs.remove(config);
    }

    @Override
    public int getValue() {
        int value = 0;
        for (final var config : configs) {
            value += config.getValue();
        }

        return value;
    }

    @Override
    public String getName() {
        final var name = new StringBuilder();
        for (final var config : configs) {
            name.append(config.getName()).append(";");
        }

        name.deleteCharAt(name.indexOf(";"));
        return name.toString();
    }
}
```

The user config may look like:

```java
final class UserConfig implements Config {
    private final String name;
    private final int value;

    public UserConfig(final String name, final int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }
}
```

And finally it can be used as:

```java
final var configs = new Configs();
configs.add(new UserConfig("Name", 100));
// Additional code
final var name = configs.getName();
final var value = configs.getValue();
// Additional code
```

## More Examples

* [java.awt.Container](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Container.html)
* [java.awt.Component](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Component.html)

## Links

* [Composite Pattern](https://en.wikipedia.org/wiki/Composite_pattern)