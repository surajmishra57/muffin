package org.example.oops.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wildcards are special symbols used in generics to represent an unknown type.
 * They provide flexibility when working with generic types and allow developers to define relationships
 * between different types.
 * <p>
 * 1. Unbounded Wildcard (?) :
 * • Represents an unknown type.
 * • Useful when the type is not relevant to the logic.
 */
public class Part_4_Unbounded_WildCard {
    public static void printElement(List<?> list) {
        for (var x : list) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        printElement(arr);

        List<String> str = Arrays.asList("hello", "this", "is", "my", "code");
        printElement(str);

        List<Double> dub = Arrays.asList(22.3, 33.4, 55.3);
        printElement(dub);



    }
}
