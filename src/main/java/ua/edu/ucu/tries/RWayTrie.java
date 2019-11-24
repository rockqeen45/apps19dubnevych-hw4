package ua.edu.ucu.tries;


import ua.edu.ucu.utils.Queue;

import java.util.LinkedList;
import java.util.List;

public class RWayTrie implements Trie {

    private Node root;
    private int size;

    public RWayTrie() {
        this.root = new Node('0'); // 0 as root
        this.size = 0;
    }

    @Override
    public void add(Tuple t) {
        String term = t.getTerm();
        int weight = t.getWeight();
        Node current = root;
        for (char c: term.toCharArray()) {
            if (!current.hasChild(c)) {
                current.addChild(c);
            }
            current = current.getChild(c);
        }
        current.setWeight(weight);
        size += 1;
    }

    @Override
    public boolean contains(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (!current.hasChild(c)) {
                return false;
            }
            current = current.getChild(c);
        }
        return current.getWeight() == word.length();
    }

    //it doesn't delete nodes from tree. We leave them for new possible words.
    @Override
    public boolean delete(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            if (!current.hasChild(c)) {
                return false;
            }
            current = current.getChild(c);
        }

        if (current.getWeight() > 0) {
            current.setWeight(0);
            size -= 1;
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public Iterable<String> words() {
        List<String> result = new LinkedList<>();
        for (Node child: root.getChildren()) {
            Queue pref = new Queue();
            getSuffixes(child, result, pref);
        }
        return result;
    }

    private void getSuffixes(Node node, List<String> result, Queue pref) {
        pref.enqueue(node.getLetter());
        Object[] cache = pref.toArray();
        if (node.getWeight() > 0) {
            String word = queueToString(pref);
            result.add(word);
        }

        for (Node child: node.getChildren()) {
            getSuffixes(child, result, pref);
            pref = new Queue(cache);
        }
    }

    private String queueToString(Queue queue) {
        Object[] buffer = queue.toArray();
        char[] word = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            word[i] = (char) buffer[i];
        }
        return new String(word);
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        List<String> result = new LinkedList<>();
        Queue pref = new Queue();
        Node current = root;
        for (char c: s.toCharArray()) {
            if (!current.hasChild(c)) {
                return null;
            }
            current = current.getChild(c);
            pref.enqueue(c);
        }

        if (current.getWeight() > 0) {
            result.add(queueToString(pref));
        }

        Object[] cache = pref.toArray();
        for (Node child: current.getChildren()) {
            getSuffixes(child, result, pref);
            pref = new Queue(cache);
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}
