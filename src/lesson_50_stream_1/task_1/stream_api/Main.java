package lesson_50_stream_1.task_1.stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    // STREAM API

    // https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---intro
    public static Collection<String> mapToUppercase(String... names) {
        return Arrays.stream(names)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---practice
    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Arrays.stream(names)
                .filter(n -> n.length() > 5)
                .mapToInt(String::length)
                .sum();
    }

    // https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas

    // Flatten this multidimensional collection
    public static List<String> transform(List<List<String>> collection) {
        /*List<String> newCollection = new ArrayList<>();
        for (List<String> subCollection : collection) {
            for (String value : subCollection) {
                newCollection.add(value);
            }
        }
        return newCollection;*/

        return collection.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // Get the oldest person from the collection
    public static Person getOldestPerson(List<Person> people) {
        /*Person oldestPerson = new Person("", 0);
        for (Person person : people) {
            if (person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }
        }
        return oldestPerson;*/

        return people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(new Person("", 0));
    }

    // Sum all elements of a collection, try to use the reduce operator with identity parameter instead of an IntStream
    public static int calculate(List<Integer> numbers) {
        /*int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;*/

        return numbers.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    //Get the names of all kids under the age of 18
    public static Set<String> getKidNames(List<Person> people) {
        /*Set<String> kids = new HashSet<>();
        for (Person person : people) {
            if (person.getAge() < 18) {
                kids.add(person.getName());
            }
        }
        return kids;*/

        return people.stream()
                .filter(p -> p.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toSet());
    }

    // Partition these people into adults and kids, you'll need a special collector for this one
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        /*Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;*/

        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18));
    }

    // Group these people by nationality, same kind as the previous exercise
    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        /*Map<String, List<Person>> map = new HashMap<>();
        for (Person person : people) {
            if (!map.containsKey(person.getNationality())) {
                map.put(person.getNationality(), new ArrayList<>());
            }
            map.get(person.getNationality()).add(person);
        }
        return map;*/

        return people.stream()
                .collect(Collectors.groupingBy(Person::getNationality));
    }

    // Return a comma-separated string of all these people's names
    public static String namesToString(List<Person> people) {
        /*String label = Challenge;
        StringBuilder sb = new StringBuilder(label);
        for (Person person : people) {
            if (sb.length() > label.length()) {
                sb.append(", ");
            }
            sb.append(person.getName());
        }
        sb.append(".");
        return sb.toString();*/

        return people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Names: ", "."));
    }

    // Challenge: returns a comma separated string based on a given list of integers...
    // (wrong test method name at site)
    public static String getString(List<Integer> list) {
        return list.stream()
                .map(x -> x % 2 == 0 ? "e" + x : "o" + x)
                .collect(Collectors.joining(","));
    }
}