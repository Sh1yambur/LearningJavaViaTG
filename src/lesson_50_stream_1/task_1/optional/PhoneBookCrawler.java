package lesson_50_stream_1.task_1.optional;

import java.util.Map;

public class PhoneBookCrawler {

    private PhoneBook phoneBook;

    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    // Exercise 2
    // Exercise 5
    public String findPhoneNumberByNameAndPunishIfNothingFound(String name) {
        /*return phoneBook.findPhoneNumberByName(name)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("No phone number found");
                });*/

        /*// this is valid solution for validator
        String phone = phoneBook.findPhoneNumberByName(name).orElse(null);

        if (phone == null) {
            throw new IllegalArgumentException("No phone number found");
        }

        return phone;*/

        /*return phoneBook.getPhoneBookEntries()
                .entrySet()
                .stream()
                .filter(e -> e.getKey().equals(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("No phone number found");
                });*/

        // this is valid solution for validator
        String phone = phoneBook.getPhoneBookEntries()
                .entrySet()
                .stream()
                .filter(e -> e.getKey().equals(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);

        if (phone == null) {
            throw new IllegalArgumentException("No phone number found");
        }

        return phone;
    }

    // Exercise 3
    // Exercise 4
    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name) {
        return phoneBook.findPhoneNumberByName(name)
                .orElseGet(() -> phoneBook.toString());
    }

    // Exercise 6
    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber) {
        return phoneBook
                .findPhoneNumberByName(name)
                .orElse(phoneBook
                        .findNameByPhoneNumber(phoneNumber)
                        .orElse("016/161616"));
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }
}
