package org.example.lld_interview_problems.lrucache;

public class DoublyLinkList<K, V> {
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public DoublyLinkList() {
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }
}
