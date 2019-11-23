package ua.edu.ucu.tries;


public class RWayTrie implements Trie {

    private Node root;

    public RWayTrie() {
        this.root = new Node('0'); // 0 as root
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

    @Override
    public boolean delete(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<String> words() {
        return null;
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        return root.size();
    }

}
