package ua.edu.ucu.autocomplete;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.tries.RWayTrie;
import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;
import static org.junit.Assert.*;

public class RWayTrieTest {

    private Trie trie;

    @Before
    public void setup() {
        Tuple tup1 = new Tuple("driver", 6);
        Tuple tup2 = new Tuple("drivers", 7);
        Tuple tup3 = new Tuple("duck", 4);
        Tuple tup4 = new Tuple("map", 3);

        trie = new RWayTrie();

        trie.add(tup1);
        trie.add(tup2);
        trie.add(tup3);
        trie.add(tup4);
    }

    @Test
    public void testFunctionality() {
        assertTrue(trie.contains("driver"));
        assertFalse(trie.contains("abc"));

        assertTrue(trie.delete("driver"));
        assertFalse(trie.delete("driver"));
        assertFalse(trie.contains("driver"));

        assertTrue(trie.contains("drivers"));
        trie.add(new Tuple("driver", 6));
        assertTrue(trie.contains("driver"));
        assertFalse(trie.contains("drive"));

        assertEquals(trie.size(), 4);

        String[] expectedWords = new String[] {"driver", "drivers", "duck", "map"};
        int i = 0;
        for (String word: trie.words()) {
            assertEquals(word, expectedWords[i]);
            i++;
        }

        String[] expectedWordsWithPrefix = new String[] {"driver", "drivers", "duck"};
        i = 0;
        for (String word: trie.wordsWithPrefix("d")) {
            assertEquals(word, expectedWordsWithPrefix[i]);
            i++;
        }

    }
}
