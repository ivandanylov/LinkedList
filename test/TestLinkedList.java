import com.trubin.datastructures.list.LinkedList;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class TestLinkedList {
    @Test
    public void testAddWithoutIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("");

        assertEquals(4, linkedList.size());
    }

    @Test
    public void testGet() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("");

        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));
        assertEquals("", linkedList.get(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetByNonexistentIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");

        Object value = linkedList.get(1);
    }

    @Test
    public void testAddWithIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        linkedList.add("E", 1);

        assertEquals(5, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("E", linkedList.get(1));
        assertEquals("B", linkedList.get(2));
        assertEquals("C", linkedList.get(3));
        assertEquals("D", linkedList.get(4));
    }
}
