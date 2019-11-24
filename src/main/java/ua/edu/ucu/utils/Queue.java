package ua.edu.ucu.utils;

public class Queue {
    private ImmutableLinkedList linkQ;

    public Queue() {
        this.linkQ = new ImmutableLinkedList();
    }

    public Queue(Object[] arr) {
        this.linkQ = new ImmutableLinkedList();
        for (int i = 0; i < arr.length; i++) {
            enqueue(arr[i]);
        }
    }

    public Object peek() {
        return linkQ.getFirst();
    }

    public Object dequeue() {
        Object first = linkQ.getFirst();
        linkQ = linkQ.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        linkQ = linkQ.addLast(e);
    }

    public Object[] toArray() {
        return linkQ.toArray();
    }

}
