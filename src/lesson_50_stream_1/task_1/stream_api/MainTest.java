package lesson_50_stream_1.task_1.stream_api;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getString() {
        System.out.println(Main.getString(Arrays.asList(3, 44)));
        assertEquals("o3,e44", Main.getString(Arrays.asList(3, 44)));

        System.out.println(Main.getString(Collections.singletonList(3)));
        assertEquals("o3", Main.getString(Collections.singletonList(3)));
    }
}