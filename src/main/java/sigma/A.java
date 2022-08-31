package sigma;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Math_Score = sc.nextInt();
        int Physics_Score = sc.nextInt();
        int Chemistry_Score = sc.nextInt();
        float average = (Math_Score + Physics_Score + Chemistry_Score) / 3;
        System.out.println(average);


//        System.out.println("Hello Zhuolin Ji");
    }
}
