package ua.edu.ucu.utils;


public class ImmutableLinkedList implements ImmutableList {
    private Node head;

    @Override
    public ImmutableLinkedList add(Object e) {
        Node newElem = new Node(e);
        ImmutableLinkedList newList = new ImmutableLinkedList();
        if (isEmpty()) {
            newList.setHead(newElem);
        }
        else {
            Node current = this.getHead();
            newList.setHead(current.getVal());
            Node newCurrent = newList.getHead();
            while (current.getNext() != null) {
                current = current.getNext();
                newCurrent.setNext(current.getVal());
                newCurrent = newCurrent.getNext();
            }
            newCurrent.setNext(newElem);
        }
        return newList;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node newElem = new Node(e);
        ImmutableLinkedList newList = new ImmutableLinkedList();
        if (isEmpty()) {
            newList.setHead(newElem);
        }
        else {
            Node current;
            Node newCurrent;
            if (index == 0) {
                current = this.getHead();
                newElem.setNext(current.getVal());
                newList.setHead(newElem);
                newCurrent = newList.getHead().getNext();
            } else {
                current = this.getHead();
                newList.setHead(current.getVal());
                newCurrent = newList.getHead();
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                    newCurrent.setNext(current.getVal());
                    newCurrent = newCurrent.getNext();
                }
                newCurrent.setNext(newElem);
                newCurrent = newCurrent.getNext();
            }
            while (current.getNext() != null) {
                current = current.getNext();
                newCurrent.setNext(current.getVal());
                newCurrent = newCurrent.getNext();
            }
        }
        return newList;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        ImmutableLinkedList newList = this.add(c[0]);
        for (int i = 1; i < c.length; i++) {
            newList = newList.add(c[i]);
        }
        return newList;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int j = index;
        ImmutableLinkedList newList = this.add(j, c[0]);
        j++;
        for (int i = 1; i < c.length; i++) {
            newList = newList.add(j, c[i]);
            j++;
        }
        return newList;
    }

    @Override
    public Object get(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else {
            int pos = 0;
            Node current = this.getHead();
            while (pos != index) {
                current = current.getNext();
                pos++;
            }
            return current.getVal();
        }
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        ImmutableLinkedList newList = new ImmutableLinkedList();
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node current;
            Node newCurrent;
            if (index == 0) {
                current = this.getHead().getNext();
                newList.setHead(current.getVal());
                newCurrent = newList.getHead();
            } else {
                current = this.getHead();
                newList.setHead(current.getVal());
                newCurrent = newList.getHead();
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                    newCurrent.setNext(current.getVal());
                    newCurrent = newCurrent.getNext();
                }
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current = current.getNext();
                newCurrent.setNext(current.getVal());
                newCurrent = newCurrent.getNext();
            }
        }
        return newList;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        ImmutableLinkedList newList = new ImmutableLinkedList();
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node current;
            Node newCurrent;
            if (index == 0) {
                current = this.getHead().getNext();
                newList.setHead(e);
                newCurrent = newList.getHead();
            } else {
                current = this.getHead();
                newList.setHead(current.getVal());
                newCurrent = newList.getHead();
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                    newCurrent.setNext(current.getVal());
                    newCurrent = newCurrent.getNext();
                }
                current = current.getNext();
                newCurrent.setNext(e);
                newCurrent = newCurrent.getNext();
            }
            while (current.getNext() != null) {
                current = current.getNext();
                newCurrent.setNext(current.getVal());
                newCurrent = newCurrent.getNext();
            }
        }
        return newList;
    }

    @Override
    public int indexOf(Object e) {
        int pos = 0;
        Node current = this.getHead();
        try {
            while (!current.getVal().equals(e)) {
                current = current.getNext();
                pos++;
            }
        } catch (NullPointerException ex) {
            return -1;
        }
        return pos;
    }

    @Override
    public int size() {
        int size = 0;
        if (isEmpty()) {
            return size;
        } else {
            size++;
            Node current = this.getHead();
            while (current.getNext() != null) {
                current = current.getNext();
                size++;
            }
            return size;
        }
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Node current = this.getHead();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = current.getVal();
            current = current.getNext();
        }
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return this.add(e);
    }

    public Object getFirst() {
        return this.get(0);
    }

    public Object getLast() {
        return this.get(this.size() - 1);
    }

    public ImmutableLinkedList removeFirst() { //видаляє перший елемент
        return this.remove(0);
    }

    public ImmutableLinkedList removeLast() { // видаляє останній елемент
        return this.remove(this.size() - 1);
    }

    private Node getHead() {
        return head;
    }

    private void setHead(Node node) {
        this.head = node;
    }

    private void setHead(Object obj) {
        this.head = new Node(obj);
    }
}
