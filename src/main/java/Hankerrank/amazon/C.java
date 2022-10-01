package Hankerrank.amazon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class C {
    public static void main(String[] args) {
//        int[] times = {0,0,1,5};
//        int[] directions = {0,1,1,0}; //2 0 1 5
//        int[] times = {0,0,5,5};
//        int[] directions = {0,1,1,0};//1 0 5 6
//        int[] times = {0,1,1,3,3};
//        int[] directions = {0,1,0,0,1};//0 2 1 4 3
//        int[] times = {1,2,4};
//        int[] directions = {0,1,1};//1 2 4
        int[] times = {1, 1, 3, 3, 4, 5, 6, 7, 7};
        int[] directions = {1, 1, 0, 0, 0, 1, 1, 1, 1};// [2, 1, 5, 3, 4, 9, 6, 8, 7]
        System.out.println(Arrays.toString(turnstile(times,directions)));
    }
    public  static  int[] turnstile(int[] times, int[] directions){
        int[] ans = new int[times.length];
        int preState=1,lastUsed = -1, cur = 0, n= times.length;

        Deque<Integer> enter = new ArrayDeque<>();
        Deque<Integer> leave = new ArrayDeque<>();
        for (int i = 0; i < times.length; i++) {
            if(times[i]>lastUsed+1){
                preState = 1;
                cur =times[i];
            }
            if(directions[i]==0){
                enter.push(i);
            }else{
                leave.push(i);
            }
            if(i==n-1 || times[i]!=times[i+1]){
                if(preState==1){
                    while (!leave.isEmpty()){
                        ans[leave.pop()]=cur;
                        cur+=1;
                    }
                    while(!enter.isEmpty() && (i==n-1 || cur!=times[i+1])){
                        ans[enter.pop()]=cur;
                        cur+=1;
                        preState=0;
                    }
                }else if(preState==0){
                    while(!enter.isEmpty()){
                        ans[enter.pop()]=cur;
                        cur+=1;
                    }
                    while(!leave.isEmpty() && (i==n-1 || cur<times[i+1])) {
                        ans[leave.pop()]=cur;
                        cur+=1;
                        preState=1;
                    }
                }
                lastUsed = cur-1;
            }
        }
        return ans;
    }
}
