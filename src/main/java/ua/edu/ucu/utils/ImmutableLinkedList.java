package ua.edu.ucu.utils;

public class ImmutableLinkedList implements ImmutableList {

    private final Node head;

    public ImmutableLinkedList() {
        head = null;
    }

    public ImmutableLinkedList(Node head) {
        this.head = head;
    }

    private static Node getNodeByIndex(Node head, int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i != index; i++) {
            current = current.next;
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return current;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size() - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size() - 1);
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.head == null) {
            return new ImmutableLinkedList(new Node(e));
        } 
        else {
            Node newHead = this.head.copy();
            if (index == 0) {
                return new ImmutableLinkedList(new Node(e, newHead));
            } 
            else {
                getNodeByIndex(newHead, index - 1).setNext(new Node(e));
                return new ImmutableLinkedList(newHead);
            }
        }
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        ImmutableLinkedList l = this;
        for (int i = 0; i < c.length; i++) {
            l = l.add(c[i]);
        }
        return l;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        ImmutableLinkedList l = this;
        for (int i = 0; i < c.length; i++) {
            l = l.add(index + i, c[i]);
        }
        return l;
    }

    @Override
    public Object get(int index) {
        return getNodeByIndex(this.head, index).data;
    }

    @Override
    public ImmutableLinkedList remove(final int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (size() == 1) {
            return new ImmutableLinkedList();
        } 
        else {
            Node newHead = this.head.copy();
            if (index == 0) {
                return new ImmutableLinkedList(newHead.next);
            } 
            else {
                Node previous = getNodeByIndex(newHead, index - 1);
                previous.next = previous.next.next;
                return new ImmutableLinkedList(newHead);
            }
        }
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node newHead = this.head.copy();
        Node n = getNodeByIndex(newHead, index);
        n.data = e;
        return new ImmutableLinkedList(newHead);
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node current = this.head;
        while (!(current == null || current.data.equals(e))) {
            current = current.next;
            index++;
        }
        if (current == null) {
            return -1;
        }
        else {
            return index;
        }
    }

    @Override
    public int size() {
        int counter = 0;
        Node current = this.head;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        int index = 0;
        Node current = this.head;
        while (current != null) {
            array[index] = current.data;
            current = current.next;
            index++;
        }
        return array;
    }
}
