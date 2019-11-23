package ua.edu.ucu.tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private char letter;
    private List<Node> children;
    private int weight;

    public Node(char letter) {
        this.letter = letter;
        this.children = new ArrayList<>();
        this.weight = 0;
    }

    public Node(char letter, int weight) {
        this.letter = letter;
        this.children = new ArrayList<>();
        this.weight = weight;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(char ch) {
        children.add(new Node(ch));
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public boolean hasChild(char ch) {
        return children.contains(new Node(ch));
    }
    
    public Node getChild(char ch) {
        for (Node child: children) {
            if (child.getLetter() == ch) {
                return child;
            }
        }
        return null;
    }

    // Make sense only in RWayTrie
    public int size() {
        if (children.isEmpty() && weight != 0) {
            return 1;
        }
        int sum = 0;
        for (Node child: children) {
            sum += child.size();
        }
        if (this.getWeight() > 0) {
            return sum + 1;
        }
        else {
            return sum;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return letter == node.letter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter);
    }
}