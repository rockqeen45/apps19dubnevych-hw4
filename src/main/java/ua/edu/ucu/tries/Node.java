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

    public void deleteChild(char ch) {
        if (hasChild(ch)) {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getLetter() == ch) {
                    children.remove(i);
                    return;
                }
            }
        }
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