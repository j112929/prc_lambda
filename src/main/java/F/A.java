package F;

public class A {
    /*
    amazon
    long findPasswordStrength(String password)
     */
    public static void main(String[] args) {
        String in = "teste";

        char[] arr = in.toCharArray();
        long ans = 3;// 全部字符是3分，，n个字符是n分，

        int n = in.length();
        for (int i = 1; i < n; i++) {
            ans += i * (n - (i - 1));
            System.out.println(ans);
        }

    }
}
