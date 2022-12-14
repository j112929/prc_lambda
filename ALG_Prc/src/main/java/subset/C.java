package subset;

import java.lang.reflect.Array;
import java.util.*;

/*

   Given an integer array, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.

            *Example 1:*

            *Input:* nums = [-1,0,1,2,-1,-4]*Output:* [[-1,-1,2],[-1,0,1]]*Explanation:*
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].

    Notice that the order of the output and the order of the triplets does not matter.

            *Example 2:*

            *Input:* nums = [0,1,1]*Output:* []*Explanation:* The only possible triplet does not sum up to 0.

            *Example 3:*

            *Input:* nums = [0,0,0]*Output:* [[0,0,0]]*Explanation:* The only possible triplet sums up to 0.

 */
public class C {
    public static void main(String[] args) {
        C b = new C();
        int[] nums =
//                {0,0,0};//[[0, 0, 0]]
//                {0,1,1};//[[]]
                {-1,0,1,2,-1,-4};//[[-1, 0, 1], [-1, -1, 2]]
        System.out.println(b.sol1(nums));
    }

    public List<List<Integer>> sol1(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n-2; ++i) {
//            while(j + 1 < n && nums[j] - nums[i] < diff) ++j;
//            k = Math.max(k, j + 1);
//            while(k < n && nums[k] - nums[j] < diff) ++k;
//            if(k < n && nums[k] - nums[j] == diff && nums[j] - nums[i] == diff) ++cnt;
            for (int l = i+1; l < n-1; l++) {
                for (int m = i+2; m < n; m++) {
                    if(nums[i]+nums[l]+nums[m] ==0){
//                        ans.add(Arrays.asList(nums[i],nums[l],nums[m]));
//                        int[] subSet = {nums[i],nums[l],nums[m]};
                        List<Integer> subSet = Arrays.asList(nums[i],nums[l],nums[m]);
                        boolean isContains = false;
                        if(ans.size() >0) {
                            isContains = isContainsSubSet(ans, subSet, isContains);
                        }
                        if(!isContains) ans.add(subSet);
                    }
                }
            }
        }
        return ans;
    }

//nums = [-1,0,1,2,-1,-4]
    //time: O(n!)
    public List<List<Integer>> sol(int[] nums){
        List<List<Integer>> ans  = new ArrayList<>();
        Arrays.sort(nums);// nums=[-4,-1,-1,0,1,2]
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dfs(nums,0, dq, ans);
        if(ans.size()==0) ans.add(new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums,int beginIndex, ArrayDeque<Integer> dq, List<List<Integer>> ans){
        //nums =[-4,-1,-1,0,1,2],
        //dq =[], [-4],[-4,-1]
        //ans = [][]
        if(!dq.isEmpty() && dq.size() ==3){
            int sum = 0;
            Iterator<Integer> it = dq.iterator();
            int[] subSet = new int[3];
            int index= 0;
            while(it.hasNext()){//dq=[-4,-1,0], [-1,0,1]
                int ele= it.next();
                sum+=ele;
                subSet[index++] = ele;
            }
            if(sum==0){// sum =[-4,-1,0] => -5, [-1,0,1]=> 0, [0,1,2]=>3; [-1,-1,0]=> -2
//                System.out.println(beginIndex);
//                System.out.println("subSet:");
//                System.out.println(Arrays.toString(subSet));
                boolean isContains = false;
                if(ans.size() >0) {
                    isContains = isContainsSubSet(ans, subSet, isContains);
                }
                if(!isContains) ans.add(new ArrayList<Integer>(dq));
            }
//            dq.pop();
            return;// dq ==3 will return once, and then dfs method will start from beginIndex = 1, 2
        }
//        if(beginIndex>nums.length-3 && !dq.isEmpty()){
//            while (!dq.isEmpty()) dq.pop();
//        }
        for(int i=beginIndex; i< nums.length; i++){
            //for begenIndex = 0,dq=[-4],[-4,-1],[-4,-1,-1];
            //begenIndex = 1, dq=[-1],[-1,-1],[-1,-1,0]; begenIndex = 2, dq=[-1],[-1,0],[-1,0,1]
            //begenIndex = 3, dq=[0],[0,1],[0,1,2]; begenIndex = 4, dq=[1],[1,2]; begenIndex = 5, dq=[5]

            dq.push(nums[i]);//dq.addLast(nums[i]);
            dfs(nums, beginIndex+1, dq, ans);// open a new for loop
            //pollFirst: poll 1st ele from queue
//            dq.pop();//int r=dq.removeFirst();, call methods chain: pop-> removeFirst -> pollFirst
            // for begenIndex = 0, dq=[-4,-1];begenIndex = 1, dq=[-1,-1];
            // begenIndex = 2, dq=[-1,0]; begenIndex = 3, dq=[0,1]; begenIndex = 4, dq=[0];
            // begenIndex = 5, dq=[-1,0];
            //System.out.println("r:"+r);
            while(i== nums.length-1 && !dq.isEmpty()){
                dq.pop();
            }
        }
    }
    private boolean isContainsSubSet(List<List<Integer>> ans, List<Integer> subSet, boolean isContains) {
        subSet.sort(Comparator.comparingInt(a -> a));
        for (List<Integer> subList : ans) {
            subList.sort(Comparator.comparingInt(a -> a));
//            System.out.print("subList:");
//            System.out.println(subList);
            int cntSame = 0;
            for (int j = 0; j < subList.size(); j++) {//subList.size() = 3
                if (Objects.equals(subList.get(j), subSet.get(j))) {
                    cntSame++;
                }
            }
            if (cntSame == 3) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    private boolean isContainsSubSet(List<List<Integer>> ans, int[] subSet, boolean isContains) {
        //??????2?????????????????????????????????????????????
        Arrays.sort(subSet);
        for (List<Integer> subList : ans) {
            subList.sort(Comparator.comparingInt(a -> a));
//            System.out.print("subList:");
//            System.out.println(subList);
            int cntSame = 0;
            for (int j = 0; j < subList.size(); j++) {//subList.size() = 3
                if (subList.get(j) == subSet[j]) {
                    cntSame++;
                }
            }
            if (cntSame == 3) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }
}
