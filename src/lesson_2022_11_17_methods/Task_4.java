package lesson_2022_11_17_methods;

public class Task_4 {
    public static void execute(){
        System.out.println(getRecursionRoot(5));
        System.out.println(Math.sqrt(1 + Math.sqrt(2 + Math.sqrt(3 + Math.sqrt(4 + Math.sqrt(5))))));
    }

    // todo: code me
    private static double getRecursionRoot(int num){
//        double res = 0.0;
//        for (int i = num; i >= 1; i--) {
//            res = Math.sqrt(res + i);
//        }
//        return res;
        if(num == 0) return 0;
        return Math.sqrt(0 + getRecursionRoot(num - 1));
    }
}