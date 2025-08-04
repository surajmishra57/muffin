package org.example.lld_interview_problems.lrucache;

public class DoublyLinkList<K, V> {
    final Node<K, V> head;
    final Node<K, V> tail;

    public DoublyLinkList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToFirst(Node<K, V> node) {
        remove(node);
        addFirst(node);

    }

    public Node<K, V> removeLast() {
        if (tail.prev == head) return null;
        Node<K, V> last = tail.prev;
        remove(last);
        return last;
    }
}
