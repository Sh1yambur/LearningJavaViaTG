package lesson_50_stream_1.task_1.optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookCrawlerTest {
    static PhoneBookCrawler crawler;

    @BeforeAll
    public static void init() {
        crawler = new PhoneBookCrawler(new PhoneBook());
    }

    @Test
    void findPhoneNumberByNameAndPunishIfNothingFound() {
        assertEquals("016/161616", crawler.findPhoneNumberByNameAndPunishIfNothingFound("Jos de Vos"));

        assertThrows(IllegalArgumentException.class, () -> crawler.findPhoneNumberByNameAndPunishIfNothingFound("name"));
    }

    @Test
    void findPhoneNumberByNameOrNameByPhoneNumber() {
        assertEquals(
                "016/161617",
                crawler.findPhoneNumberByNameOrNameByPhoneNumber("An de Toekan", null)
        );

        assertEquals(
                "An de Toekan",
                crawler.findPhoneNumberByNameOrNameByPhoneNumber(null, "016/161617")
        );

        assertEquals(
                "016/161616",
                crawler.findPhoneNumberByNameOrNameByPhoneNumber(null, null)
        );
    }
}