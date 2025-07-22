package org.example.oops.generic;

/**
 * Generic Java method takes a parameter and returns some value after performing a task.
 * It is exactly like a normal function, however, a generic method has type parameters that are cited by actual type.
 * This allows the generic method to be used in a more general way.
 * The compiler takes care of the type of safety which enables programmers to code easily since they do not have to
 * perform long, individual type castings.
 */

public class Part_1_Generic_Method {
    public static <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " : " + element);
    }

    public static void main(String[] args) {
        genericDisplay("Hello World");
        genericDisplay(123);
        genericDisplay(12.5);
        genericDisplay('c');
    }
}
