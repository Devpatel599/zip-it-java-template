package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static <T> List<T> zip(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int minSize = Math.min(size1, size2);

        for (int i = 0; i < minSize; i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }

        if (size1 > size2) {
            result.addAll(list1.subList(minSize, size1));
        } else if (size2 > size1) {
            result.addAll(list2.subList(minSize, size2));
        }

        return result;
    }

    public static <V> HashMap<String, V> hashmapify(List<String> keys, List<V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Lists must have the same size");
        }

        HashMap<String, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }

        return map;
    }

    public static void main(String[] args) {
        List<Integer> nums1 = List.of(1, 3, 5, 7);
        List<Integer> nums2 = List.of(2, 4, 6, 8);
        System.out.println(zip(nums1, nums2)); 

        List<String> colors1 = List.of("Red", "Green", "Blue");
        List<String> colors2 = List.of("White", "Black", "Orange", "Pink", "Fuschia");
        System.out.println(zip(colors1, colors2)); 

        List<String> colorKeys = List.of("White", "Black", "Orange", "Pink");
        List<Integer> colorValues = List.of(1, 3, 5, 7);
        System.out.println(hashmapify(colorKeys, colorValues)); 
    }
}
