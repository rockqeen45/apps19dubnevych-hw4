package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;
    private static final int MIN_PREFIX_LEN = 2;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
        int addedWords = 0;
        for (String string: strings) {
            for (String word: string.split(" ")) {
                if (word.length() >= MIN_PREFIX_LEN) {
                    trie.add(new Tuple(word, word.length()));
                    addedWords++;
                }
            }
        }
        return addedWords;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        return trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        return trie.wordsWithPrefix(pref);
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public int size() {
        return trie.size();
    }
}
