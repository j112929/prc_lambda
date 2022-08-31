package demo;

public class Demo {

    public static String sol(int num) {
        boolean flag1 = false;
        boolean flag2 = false;
        if (num % 3 == 0) {
            flag1 = true;
        }
        if (num % 5 == 0) {
            flag2 = true;
        }

        if (flag1 && flag2) {
            return "FizzBuzz";
        } else {
            if (flag1) {
                return "Fizz";
            }
            if (flag2) {
                return "Buzz";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        //3:Fizz ,5:Buzz, 15:FizzBuzz
        System.out.println(sol(15));
    }
}
