package ua.edu.ucu.utils;

class Node {
    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
        next = null;
    }

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node copy() {
        if (next == null) {
            return new Node(data);
        } else {
            return new Node(data, next.copy());
        }
    }

    void setNext(Node newNext) {
        newNext.next = this.next;
        this.next = newNext;
    }
}