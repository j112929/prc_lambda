package F;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B {
    /*
        int findMinMoves(List<Integer> plates)
         */
    public static void main(String[] args) {
        int[] ans = new int[]{2, 4, 3, 1, 1, 6};//4, 11, 9, 10, 12 ; 2,4,3,1,6； 2,4,3,1,1,6
        List<Integer> plates = Arrays.stream(ans).boxed().collect(Collectors.toList());
        int n = plates.size();
        int min = plates.get(0);
        int min_index = 0;
        for (int i = 1; i < n; i++) {
            if (min > plates.get(i).intValue()) {
                min = plates.get(i);
                min_index = i;
                System.out.println("min:" + min);
                System.out.println("min_index:" + min_index);
            }
        }
        int r = min == plates.get(0).intValue() ? 0 : plates.get(min_index - 1).intValue();
        System.out.println("res:" + r);
    }


}
