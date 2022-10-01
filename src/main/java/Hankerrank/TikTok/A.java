package Hankerrank.TikTok;

import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        String s = "OOO";//[XXO, OXX]
//                "OXOO";//[OXXX]
//                "OOOO";[XXOO, OXXO, OOXX]
//        System.out.println(replace(s));

        //11122233，返回result是313223，不能转成string，必须in place
        System.out.println(transfer(11122233));
    }
    public static List<String> replace(String s){
        List<String> ans = new ArrayList<>();
        char[] arr= s.toCharArray();
        for (int i = 0; i < s.length()-1; i++) {
            if(arr[i] =='O' && arr[i+1]=='O'){
                if(i==0) {
                    ans.add("XX"+s.substring(i+2));
                }else if(i>0 && i+2<arr.length){
                    ans.add(s.substring(0,i)+"XX"+s.substring(i+2));
                }else if(i>0 && i+2==arr.length){
                    ans.add(s.substring(0,i)+"XX");
                }
            }
        }
        return ans;
    }

    public static int transfer(int num){
        int i = num%100;
        int i1 = (num-i)/100;
        System.out.println(i+":"+i1);
        return i1+202001;
    }
}
