package org.example.oops.generic;

/**
 * A generic class is implemented exactly like a non-generic class.
 * The only difference is that it contains a type parameter section.
 * There can be more than one type of parameter, separated by a comma.
 * The classes, which accept one or more parameters, are known as parameterized classes or parameterized types.
 * <p>
 * <p>
 * <p>
 * <p>
 * NOTE : Generics Work Only with Reference Types:
 * <p>
 * When we declare an instance of a generic type, the type argument passed to the type parameter must be a reference type.
 * We cannot use primitive data types like int, char, boolean etc.
 * <p>
 * Test<int> obj = new Test<int>(20);
 * The above line results in a compile-time error that can be resolved using type wrappers to encapsulate a primitive type.
 * For example, we can use the Integer wrapper class instead of int:
 * <p>
 * Test<Integer> obj = new Test<Integer>(20);
 * But primitive type arrays can be passed to the type parameter because arrays are reference types.
 * ArrayList<int[]> a = new ArrayList<>();
 */


public class Part_2_Generic_Class {
    public static void main(String[] args) {
        Test<String> stringTest = new Test<>("hello,world");
        System.out.println(stringTest.getObject());

        Test<Integer> integerTest = new Test<>(1243);
        System.out.println(integerTest.getObject());

        Test val = new Test('c');
        System.out.println(val.getObject());
    }
}

class Test<T> {
    private T t;

    Test(T t) {
        this.t = t;
    }

    public T getObject() {
        return t;
    }
}

