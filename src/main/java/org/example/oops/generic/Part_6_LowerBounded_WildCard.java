package org.example.oops.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Lower-Bounded Wildcard (? super Type)
 * • Restricts the type to Type or its superclasses.
 * • Useful for write operations.
 */
public class Part_6_LowerBounded_WildCard {
    // Parent Class Of Integer : Object , Number so that's why we can use this here
    public static void addElement(List<? super Integer> list) {
        list.add(43);
    }

    public static void main(String[] args) {
        List<Number> arr = new ArrayList<>();
        addElement(arr);
        System.out.println(arr);
    }
}
