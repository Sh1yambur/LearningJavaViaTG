package lesson_39_queue_1.task_1;

// TODO go to JUnit ver.5

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
    public void size() {
        assertEquals(4, list.size());
    }

    @Test
    public void testToString() {
        String expected = "[One -> Two -> Three -> Four]";
        assertEquals(expected, list.toString());
    }

    @Test
    public void add() {
        list.add(fortyTwo);
        assertEquals(5, list.size());

        assertEquals("[One -> Two -> Three -> Four -> FortyTwo]", list.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void addByIndex() {
        list.add(0, new Element("Zero"));
        assertEquals("[Zero -> One -> Two -> Three -> Four]", list.toString());
        assertEquals(5, list.size());

        list.add(4, new Element("ThreeAndHalf"));
        assertEquals("[Zero -> One -> Two -> Three -> ThreeAndHalf -> Four]", list.toString());
        assertEquals(6, list.size());

        list.add(6, new Element("Five")); // expecting exception
    }

    @Test(expected = NoSuchElementException.class)
    public void get() {
        assertEquals(four, list.get(3));

        assertEquals(one, list.get(0));

        list.get(4); // expecting exception
    }

    @Test(expected = NoSuchElementException.class)
    public void set() {
        list.set(0, new Element("Zero"));
        assertEquals("[Zero -> Two -> Three -> Four]", list.toString());
        assertEquals(4, list.size());

        list.set(3, new Element("4"));
        assertEquals("[Zero -> Two -> Three -> 4]", list.toString());

        list.set(4, new Element("five")); // expecting exception
    }

    @Test(expected = NoSuchElementException.class)
    public void remove() {
        list.remove(one);
        assertEquals(3, list.size());
        assertEquals("[Two -> Three -> Four]", list.toString());

        list.remove(four);
        assertEquals(2, list.size());
        assertEquals("[Two -> Three]", list.toString());

        list.remove(fortyTwo); // expecting exception
    }

    @Test(expected = NoSuchElementException.class)
    public void removeByIndex() {
        list.remove(0);
        assertEquals("[Two -> Three -> Four]", list.toString());
        assertEquals(3, list.size());

        list.remove(2);
        assertEquals("[Two -> Three]", list.toString());

        list.remove(3); // expecting exception
    }

    @Test(expected = NoSuchElementException.class)
    public void find() {
        assertEquals(one, list.find(one));

        list.add(fortyTwo);
        assertEquals(fortyTwo, list.find(fortyTwo));

        list.find(new Element("Five")); // expecting exception
    }

    @Test
    public void removeAndAdd(){
        list.remove(3);
        assertEquals(3, list.size());
        list.add(fortyTwo);
        assertEquals("[One -> Two -> Three -> FortyTwo]", list.toString());

        list.remove(fortyTwo);
        assertEquals(3, list.size());
        list.add(new Element("Five"));
        assertEquals("[One -> Two -> Three -> Five]", list.toString());
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