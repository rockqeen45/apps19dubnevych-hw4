package ua.edu.ucu.tries;

public final class Tuple {
    private final String term;
    private final int weight;

    public Tuple(String term, int weight) {
        this.term = term;
        this.weight = weight;
    }

    public String getTerm() {
        return term;
    }

    public int getWeight() {
        return weight;
    }
}