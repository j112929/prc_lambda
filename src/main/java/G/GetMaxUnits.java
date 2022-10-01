package G;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetMaxUnits {
    /*
    Efficient Shipping
    求最大容量
    int getMaxUnits(int[] boxes,int[] unitPerBox, int truckSize)
     */
    public static void main(String[] args) {
        int[] boxes = new int[]{1, 1};//数量 //3,1,6;
        int[] unitPerBox = new int[]{9, 6};//数量对应的容量 //2,7,4;
        int truckSize = 1;//6;
        int n = boxes.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(unitPerBox[i], boxes[i]);
        }
        Arrays.sort(unitPerBox);
//        for (int i = 0; i < n; i++) {
//            System.out.println(unitPerBox[i]);
//        }
        int res = 0;
        int res_num = 0;
        int tmp = 0;
        for (int i = n - 1; i > 0; i--) {
            if (res_num >= truckSize) {
                continue;
            }
            tmp = map.get(unitPerBox[i]).intValue();
            if (res_num + tmp > truckSize) {
                tmp = truckSize - res_num;//总数-已有数=剩余需要数
            }
            res += unitPerBox[i] * tmp;
            res_num += tmp;
            System.out.println("res:" + res);
            System.out.println("res_num:" + res_num);
        }
        System.out.println(res);
    }
}
