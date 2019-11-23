package ua.edu.ucu.utils;

public class Node {
    private Object val;
    private Node next;

    public Node(Object val) {
        this.val = val;
        this.next = null;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object value) {
        this.val = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextN) {
        this.next = nextN;
    }

    public void setNext(Object nextN) {
        this.next = new Node(nextN);
    }
}
