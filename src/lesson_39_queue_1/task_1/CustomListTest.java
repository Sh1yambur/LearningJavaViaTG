package lesson_39_queue_1.task_1;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class CustomListTest {
    CustomList<Element> list;

    Element one = new Element("One");
    Element two = new Element("Two");
    Element three = new Element("Three");
    Element four = new Element("Four");

    Element fortyTwo = new Element("FortyTwo");

    @Before
    public void setUp() throws Exception {
        list = new CustomList<>();

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
    }

    @Test
    public void add() {
        list.add(fortyTwo);
        assertEquals(5, list.size());
        assertEquals("[FortyTwo -> Four -> Three -> Two -> One]", list.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void remove() {
        list.remove(one);
        assertEquals(3, list.size());
        assertEquals("[Four -> Three -> Two]", list.toString());

        list.remove(four);
        assertEquals(2, list.size());
        assertEquals("[Three -> Two]", list.toString());

        list.remove(fortyTwo); // expecting exception
    }

    @Test
    public void size() {
        assertEquals(4, list.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void find() {
        assertEquals(two, list.find(two));

        list.find(fortyTwo); // expecting exception
    }

    @Test
    public void testToString() {
        String expected = "[Four -> Three -> Two -> One]";
        assertEquals(expected, list.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void get() {
        assertEquals(four, list.get(3));
        assertEquals(one, list.get(0));
        list.get(4); // expecting exception
    }

    @Test(expected = NoSuchElementException.class)
    public void addByIndex() {
        list.add(0, new Element("Zero"));
        assertEquals("[Four -> Three -> Two -> One -> Zero]", list.toString());
        assertEquals(5, list.size());

        list.add(4, new Element("Three&Half"));
        assertEquals("[Four -> Three&Half -> Three -> Two -> One -> Zero]", list.toString());
        assertEquals(6, list.size());

        list.add(6, new Element("Five")); // expecting exception
    }

    @Test(expected = NoSuchElementException.class)
    public void set() {
        list.set(0, new Element("Zero"));
        assertEquals("[Four -> Three -> Two -> Zero]", list.toString());
        assertEquals(4, list.size());

        list.set(3, new Element("4"));
        assertEquals("[4 -> Three -> Two -> Zero]", list.toString());

        list.set(4, new Element("five")); // expecting exception
    }

    @Test(expected = NoSuchElementException.class)
    public void removeByIndex() {
        list.remove(0);
        assertEquals("[Four -> Three -> Two]", list.toString());
        assertEquals(3, list.size());

        list.remove(3);
        assertEquals("Three -> Two]", list.toString());

        list.remove(3); // expecting exception
    }

    private static class Element {
        String value;

        public Element(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Element element = (Element) obj;

            return this.value.equals(element.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
}