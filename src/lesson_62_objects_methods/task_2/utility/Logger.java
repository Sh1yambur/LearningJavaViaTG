package lesson_62_objects_methods.task_2.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String FILE = "./resource/l62_t2/log.txt";
    private static final BufferedWriter WRITER;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static final String ADD_MSG = "delivered [%3d]   rejected [%3d]   in stock [%3d]";
    public static final String GET_MSG = "   bought [%3d]   rejected [%3d]   in stock [%3d]";

    static {
        try {
            WRITER = new BufferedWriter(new FileWriter(FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void log(String name, String msg) {
        String time = FORMATTER.format(LocalTime.now());
        String out = "%s [%-10s]\t%s\n".formatted(time, name, msg);

        try {
            WRITER.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() {
        try {
            WRITER.flush();
            WRITER.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
