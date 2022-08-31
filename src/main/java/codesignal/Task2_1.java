package codesignal;

public class Task2_1 {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 3};//4
//                {3,3,5,2,3};//6
        System.out.println(sol(numbers));
    }

    public static int sol(int[] numbers) {
        int fistNonZero = 0;
        int res = 0;
        int n = numbers.length;
        while (numbers[n--] != 0) {

            for (int i = 0; i < n; i++) {
                if (numbers[i] != 0) {
                    if (fistNonZero == 0) {
                        fistNonZero = numbers[i];
                        res += fistNonZero;
                        numbers[i] -= fistNonZero;

                    } else {
                        if (numbers[i] < fistNonZero) {
                            fistNonZero = numbers[i];
                            res += fistNonZero;
                            break;
                        } else {
                            numbers[i] -= fistNonZero;
                        }
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

}
