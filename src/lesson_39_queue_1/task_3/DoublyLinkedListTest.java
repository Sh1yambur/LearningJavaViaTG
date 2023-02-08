package lesson_39_queue_1.task_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList<Element> list;

    Element one = new Element("One");
    Element two = new Element("Two");
    Element three = new Element("Three");
    Element four = new Element("Four");

    Element fortyTwo = new Element("FortyTwo");

    @Nested
    public class Element {

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

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();

        list.addLast(one);
        list.addLast(two);
        list.addLast(three);
        list.addLast(four);
    }

    @Test
    void addFirst() {
        list.addFirst(fortyTwo);
        assertEquals("[FortyTwo <=> One <=> Two <=> Three <=> Four]", list.toString());
    }

    @Test
    void addLast() {
        list.addLast(fortyTwo);
        assertEquals("[One <=> Two <=> Three <=> Four <=> FortyTwo]", list.toString());
    }

    @Test
    void size() {
        assertEquals(4, list.size());
    }

    @Test
    void getFirst() {
        assertEquals(one, list.getFirst());

        for (int i = 0; i < 4; i++) {
            Element el = list.getFirst();
            list.remove(el);
        }

        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    @Test
    void getLast() {
        list.addLast(fortyTwo);
        assertEquals(fortyTwo, list.getLast());
    }

    @Test
    void get() {
        assertEquals(one, list.get(0));
        assertEquals(two, list.get(1));
        assertEquals(four, list.get(3));
        assertThrows(NoSuchElementException.class, () -> list.get(4));
    }

    @Test
    void remove() {
        list.remove(four);
        assertEquals("[One <=> Two <=> Three]", list.toString());
        assertEquals(3, list.size());

        list.remove(one);
        assertEquals("[Two <=> Three]", list.toString());
        assertEquals(2, list.size());

        list.remove(two);
        list.remove(three);
        assertEquals("[]", list.toString());
        assertEquals(0, list.size());
    }

    @Test
    void testToString() {
        assertEquals("[One <=> Two <=> Three <=> Four]", list.toString());
    }
}