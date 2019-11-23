package ua.edu.ucu.autocomplete;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.tries.Node;
import static org.junit.Assert.*;

public class NodeTest {

    private Node example;

    @Before
    public void setup() {
        example = new Node('0');
        example.addChild('a');
        example.addChild('b');
        example.addChild('c');
    }

    @Test
    public void testFunctionality() {
        assertEquals(example, new Node('0'));
        assertEquals(example.getNext().get(0), new Node('a'));
        assertTrue(example.hasChild('a'));
        assertFalse(example.hasChild('d'));

        Node node = new Node('d', 3);
        node.addChild('e');
        example.addChild(node);

        assertTrue(example.hasChild('d'));
        assertTrue(example.getNext().get(3).hasChild('e'));

        assertEquals(node.getWeight(), 3);
        assertEquals(example.getWeight(), 0);
    }


}
