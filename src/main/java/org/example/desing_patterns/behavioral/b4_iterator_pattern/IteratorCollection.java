package org.example.desing_patterns.behavioral.b4_iterator_pattern;

public interface IteratorCollection<T> {
    Iterator<T> createIterator();
}
