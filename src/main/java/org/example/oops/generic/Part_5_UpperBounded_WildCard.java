package org.example.oops.generic;

import java.util.List;

/**
 * Upper-Bounded Wildcard (? extends Type) :
 * Restricts the type to Type or its subclasses.
 * • Useful for read-only operations where the specific type is not required.
 */
public class Part_5_UpperBounded_WildCard {
    public static void displayElement(List<? extends Number> list) {
        for (var x : list) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7);
        displayElement(integerList);
        System.out.println("");
        List<Double> doubleList = List.of(22.3, 33.2, 44.4);
        displayElement(doubleList);
    }
}
