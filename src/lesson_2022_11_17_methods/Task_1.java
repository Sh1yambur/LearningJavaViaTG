package lesson_2022_11_17_methods;

/*
* Написать программу, которая объединяет любое количество строк, объединяя их через пробел.
* Реализацию конкатенации строк вынести в отдельный метод.
*/
public class Task_1 {
    public static void execute(){
        System.out.println(concatenateLines("Hello", "fucking", "World!"));
    }

    private static String concatenateLines(String... lines){
        String result = "";
        for (String str : lines){
            result += str + " ";
        }
        return result;
    }
}
