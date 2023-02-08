package lesson_39_queue_1.task_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {
    CustomQueue<Element> queue;

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
        queue = new CustomQueue<>();

        queue.offer(one);
        queue.offer(two);
        queue.offer(three);
    }

    @Test
    void offer() {
        queue.offer(four);
        assertEquals("[One <- Two <- Three <- Four]", queue.toString());

        queue.offer(fortyTwo);
        assertEquals("[One <- Two <- Three <- Four <- FortyTwo]", queue.toString());
    }

    @Test
    void peek() {
        assertEquals(one, queue.peek());
        assertEquals(one, queue.peek());
    }

    @Test
    void poll() {
        assertEquals(one, queue.poll());
        assertEquals(two, queue.poll());
        assertEquals("[Three]", queue.toString());

        queue.poll();
        assertThrows(NoSuchElementException.class, () -> queue.poll());
    }

    @Test
    void testToString() {
        assertEquals("[One <- Two <- Three]", queue.toString());
    }
}