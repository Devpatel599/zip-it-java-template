package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test void testZipSameSize() {
        List<Integer> list1 = List.of(1, 3, 5);
        List<Integer> list2 = List.of(2, 4, 6);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test void testZipDifferentSize() {
        List<String> list1 = List.of("A", "B");
        List<String> list2 = List.of("1", "2", "3");
        List<String> expected = List.of("A", "1", "B", "2", "3");
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test void testHashmapifyValid() {
        List<String> keys = List.of("a", "b", "c");
        List<Integer> values = List.of(10, 20, 30);
        Map<String, Integer> result = App.hashmapify(keys, values);
        assertEquals(3, result.size());
        assertEquals(10, result.get("a"));
        assertEquals(20, result.get("b"));
        assertEquals(30, result.get("c"));
    }

    @Test void testHashmapifyInvalid() {
        List<String> keys = List.of("x", "y");
        List<Double> values = List.of(1.0);
        assertThrows(IllegalArgumentException.class, () -> {
            App.hashmapify(keys, values);
        });
    }
}
