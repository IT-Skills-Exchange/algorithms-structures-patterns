# The Singleton Pattern

The pattern belongs to the creational category of the design patterns.

## Idea

Ensure a class only has one instance, and provide a global point of access to it.

## Explanation

Wikipedia says:

> In software engineering, the singleton pattern is a software design pattern that restricts the instantiation of a 
class to one object. This is useful when exactly one object is needed to coordinate actions across the system.

In plain words:

> Ensures that only one object of a particular class is ever created.

## Class Diagram

The class diagram will be:

![alt text](../etc/singleton.png "Singleton class diagram")

## Example

The task:

> Let's consider to create a logger and runtime objects which must be instantiated only once.

Let's create a logger:

```java
public enum Logger {
    INSTANCE;

    private final AtomicInteger level = new AtomicInteger(0);

    public int getLevel() {
        return level.get();
    }

    public void setLevel(int level) {
        this.level.set(level);
    }

    @Override
    public String toString() {
        return "Logger{" +
                "level=" + level +
                '}';
    }
}
```

And then it can be used as:

```java
final var logger = Logger.INSTANCE;
```
Let's create a Runtime:

```java
final class Runtime {

    private Runtime() {
    }

    public static Runtime getInstance() {
        return RuntimeHolder.INSTANCE;
    }

    private static class RuntimeHolder {
        private static final Runtime INSTANCE = new Runtime();
    }
}
```

And then it can be used as:

```java
final var logger = Logger.INSTANCE;
// Check test results
assertNotNull(logger);
assertEquals(0, logger.getLevel());
logger.setLevel(1);
assertEquals(logger, Logger.INSTANCE);
assertEquals(1, Logger.INSTANCE.getLevel());
// Additional code
final var runtime = Runtime.getInstance();
// Check test results
assertNotNull(runtime);
assertEquals(runtime, Runtime.getInstance());
```

## More Examples

* [java.lang.Runtime#getRuntime()](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Runtime.html#getRuntime())
* [java.awt.Desktop#getDesktop()](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Desktop.html#getDesktop())
* [java.lang.System#getSecurityManager()](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/System.html#getSecurityManager())

## Links

* [Singleton Pattern](https://en.wikipedia.org/wiki/Singleton_pattern)