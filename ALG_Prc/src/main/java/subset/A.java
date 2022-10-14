package subset;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class A {
    public static void main(String[] args) {
//        List<Integer> skills,
//        int minPlayers, int minLevel, int maxLevel
        List<Integer>  skills = Arrays.asList(12,4,6,13,5,10);// 5
        int minPlayers = 3
        ,minLevel = 4
        ,maxLevel = 10;
        A a = new A();
        System.out.println(a.numberOfFormation(skills,minPlayers,minLevel,maxLevel));
        System.out.println(a.factorial(0));
    }
    public int minimumOperations(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     if (num > 0) {
        //         set.add(num);
        //     }
        // }
        return Arrays.stream(nums).filter(r->r>0).boxed().collect(Collectors.toSet()).size();
        // return set.size();
    }

    public int numberOfFormation(List<Integer> skills, int minPlayers, int minLevel, int maxLevel){
        int cnt=0;
        for(Integer skill:skills){
            if(minLevel <= skill && maxLevel >= skill) cnt++;
        }
        if(cnt<minPlayers) return 0;
        int ans=0;
        while(minPlayers <= cnt){
            ans+= factorial(cnt) / (factorial(cnt - minPlayers) * factorial(minPlayers));
            minPlayers++;
        }
        return ans;
    }
    private long factorial(int n){
        return LongStream.rangeClosed(1,n).reduce(1,(long x, long y)->x*y);
    }
}
