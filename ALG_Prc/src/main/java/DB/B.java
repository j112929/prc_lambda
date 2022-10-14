package DB;

import java.util.Arrays;

public class B {
    public static void main(String[] args) {
        int[] A = {6,1,4,6,3,2,7,4};//13+11=24
        int K =3,  L=2;
        B b = new B();
        System.out.println(b.solution(A,K,L));
    }

    public int solution(int[] A, int K, int L) {
        // write your code in Java SE 8
        int n = A.length;
        if(K+L > n){
            return -1;
        }

        int[] arrK = new int[K];
        int[] arrL = new int[L];
        int maxK = 0;
        int maxL = 0;

        for (int i = n - 1; i >= 0; i--) {
            if(i <= n-L-1){
                int sum = 0;
                for(int ele: arrL){
                    sum+= ele;
                }
//                int preMaxL = maxL;
                maxL = Math.max(maxL, sum);
//                if(preMaxL != maxL){
//
//                }
            }
            arrL[i%L]= A[i];

        }
        System.out.println(maxL);

        for (int i = 0; i < n; i++) {
            if(i> K-1){
                int sum = 0;
                for(int ele: arrK){
                    sum+= ele;
                }
                maxK = Math.max(maxK, sum);
            }
            arrK[i%K]= A[i];
//            System.out.println("leftIndex:"+i%K);
        }
        System.out.println(maxK);

        return maxK + maxL;

    }
}
