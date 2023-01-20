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

        list.remove(fortyTwo);
    }

    @Test
    public void size() {
        assertEquals(4, list.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void find() {
        assertEquals(two, list.find(two));

        list.find(fortyTwo);
    }

    @Test
    public void testToString() {
        String expected = "[Four -> Three -> Two -> One]";
        assertEquals(expected, list.toString());
    }

    @Test
    public void revert() {
        list.reverse();
        assertEquals("[One -> Two -> Three -> Four]", list.toString());
    }

    @Test
    public void removeElementsWithEvenHash() {
        list.add(new Element("seven")); // 109330445
        list.add(new Element("eight")); // 96505999
        list.add(new Element("ten")); // 114717

        list.removeElementsWithEvenHash();
        assertEquals("[ten -> eight -> seven]", list.toString());
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