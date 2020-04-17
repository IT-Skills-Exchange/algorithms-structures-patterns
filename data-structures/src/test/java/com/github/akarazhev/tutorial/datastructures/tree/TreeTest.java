package com.github.akarazhev.tutorial.datastructures.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Provides a test methods for a tree.
 */
@DisplayName("Tree test")
final class TreeTest {

    @Test
    @DisplayName("Tests a tree")
    void testTree() {
        final var tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);
        tree.traverse();

        assertEquals(27, tree.get(27).getData());
        assertEquals(17, tree.get(17).getData());
        assertNull(tree.get(8888));

        assertEquals(15, tree.min());
        assertEquals(32, tree.max());

        tree.delete(8888);
        tree.traverse();
    }
}
