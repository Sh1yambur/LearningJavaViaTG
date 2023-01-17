package lesson_37_arraylist.task_2;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class CustomStackTest {
    CustomStack<String> stack;
    String one = "One";
    String two = "Two";
    String three = "Three";
    String fortyTwo = "42";

    String[] strings = {one, two, three, fortyTwo};
    String[] revertStrings = {fortyTwo, three, two, one};

    @Before
    public void setUp() throws Exception {
        stack = new CustomStack<>();

        stack.add(one);
        stack.add(two);
        stack.add(three);
        stack.add(fortyTwo);
    }

    @Test
    public void size() {
        assertEquals(4, stack.size());

        stack.remove(one);
        assertEquals(3, stack.size());

        stack.add("five");
        stack.add("six");
        assertEquals(5, stack.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(stack.isEmpty());

        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void add() {
        stack.add("five");
        assertEquals(5, stack.size());
    }

    @Test
    public void remove() {
        stack.remove(two);
        assertEquals(3, stack.size());
    }

    @Test
    public void contains() {
        assertTrue(stack.contains(fortyTwo));
        assertFalse(stack.contains("five"));
    }

    @Test
    public void iterator() {
        Iterator<String> iterator = stack.iterator();

        String[] actual = new String[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            assertTrue(iterator.hasNext());
            actual[i] = iterator.next();
        }
        assertFalse(iterator.hasNext());

        assertArrayEquals(revertStrings, actual);
    }

    @Test
    public void toArray() {
        Object[] actual = revertStrings;
        assertArrayEquals(actual, stack.toArray());
    }

    @Test
    public void toGivenArray() {
        String[] expected = revertStrings;
        assertArrayEquals(expected, stack.toArray(new String[0]));

        Exception ex = null;
        try {
            stack.toArray(new Integer[0]);
        } catch (ArrayStoreException e) {
            ex = e;
        }
        assertEquals("java.lang.ArrayStoreException", ex.getClass().getName());
    }

    @Test
    public void containsAll() {
        assertTrue(stack.containsAll(List.of(strings)));
        assertTrue(stack.containsAll(List.of(two, fortyTwo)));
        assertFalse(stack.containsAll(List.of(two, fortyTwo, "five")));
    }

    @Test
    public void addAll() {
        stack.addAll(List.of("five", "six"));
        assertEquals(6, stack.size());
    }

    @Test
    public void removeAll() {
        stack.remove(two);
        stack.remove(fortyTwo);
        assertEquals(2, stack.size());
    }

    @Test
    public void retainAll() {
        stack.retainAll(List.of(two, fortyTwo));
        assertEquals(2, stack.size());
    }

    @Test
    public void clear() {
        stack.clear();
        assertEquals(0, stack.size());
    }
}