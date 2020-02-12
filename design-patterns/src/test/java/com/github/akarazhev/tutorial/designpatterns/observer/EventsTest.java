package com.github.akarazhev.tutorial.designpatterns.observer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the events test for the dispatcher.
 */
@DisplayName("Events test")
public class EventsTest {

    @Test
    @DisplayName("Start")
    void start() {
        final var dispatcher = new Dispatcher();
        final var events = new Events();
        events.registerObserver(dispatcher);
        events.generate();
        events.removeObserver(dispatcher);

        assertEquals("Event_0:Event_1:Event_2:Event_3:Event_4", dispatcher.getBuffer());
    }
}
