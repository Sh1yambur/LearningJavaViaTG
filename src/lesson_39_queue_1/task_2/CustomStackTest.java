package lesson_39_queue_1.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {
    CustomStack<Element> stack;

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
        stack = new CustomStack<>();

        stack.push(one);
        stack.push(two);
        stack.push(three);
        stack.push(four);
    }

    @Test
    void push() {
        stack.push(fortyTwo);
        assertEquals("[FortyTwo -> Four -> Three -> Two -> One]", stack.toString());
    }

    @Test
    void peek() {
        assertEquals(four, stack.peek());

        stack.push(fortyTwo);
        assertEquals(fortyTwo, stack.peek());
    }

    @Test
    void pop() {
        assertEquals(four, stack.pop());
        assertEquals(three, stack.pop());
        assertEquals(two, stack.pop());
        assertEquals(one, stack.pop());
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    void empty() {
        assertFalse(stack.empty());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void search() {
        assertEquals(1, stack.search(four));
        assertEquals(4, stack.search(one));
        assertEquals(-1, stack.search(fortyTwo));
    }

    @Test
    void testToString() {
        assertEquals("[Four -> Three -> Two -> One]", stack.toString());

        stack.pop();
        assertEquals("[Three -> Two -> One]", stack.toString());
    }
}