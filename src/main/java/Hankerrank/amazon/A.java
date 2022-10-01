package Hankerrank.amazon;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.*;


public class A {
    public static void main(String[] args) {
//        String S = "abcca";//1
        String S = "abcbea";//2
//        int K = 2;
//        String S = "abcdea";//0
        int K = 2;
//        System.out.println(splitString(S,K));

        //Input: rating=[-1,7,-2], k=4 Expected: [7,6,5,4]
//        int[] rating={-1,7,-2};
//        int k=4;
//        System.out.println(Arrays.toString(bestCombos(rating,k)));

        int[] prices =
//                {1,1,1,2,2,3,3};//22
                {7,10,5,3};//29
//        System.out.println(sumOfFluctuation(prices));

        int[] prices1={20,22,23,14,16,15};
//                {6,2,10,2,11,1,3,2};//2
//                {10,15,9,10,9,1,3,3};//1
        int paletteSize=3, threshold=4;
//        int paletteSize=4, threshold=2;
        System.out.println(maxPalette(prices1,paletteSize,threshold));

        String searchWord= "abc", resultWord= "cb";
//        Expected: 2 Output: 1
//        System.out.println(makeSubsequence(searchWord,resultWord));
    }
     static int paletteSize=0, threshold= 0;
    public static int maxPalette(int[] nums, int paletteSize1, int threshold1) {
        if(nums.length == 0){
            return 0;
        }
        paletteSize = paletteSize1;
        threshold = threshold1;
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> inSet = new HashSet<>();
        dfs(nums, 0, path, res,set,inSet);
        return res.size();
    }
    private static void dfs(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> res,Set<Integer> set,Set<Integer> inSet){
        if(path.size()==paletteSize){
            if(inSet.size() < 3){
                return;
            }
            int max = 0;
            int min = Integer.MAX_VALUE;
            Iterator<Integer> it = path.iterator();
            while(it.hasNext()){
                int t = it.next();
                max = Math.max(max,t);
                min = Math.min(min,t);
            }
            int diff = max -min;
            if(diff<=threshold && diff>0 && !set.contains(diff)) {
                set.add(diff);
                ArrayList<Integer> list = new ArrayList<>(path);
                System.out.println(Arrays.toString(list.toArray()));
                res.add(list);
            }
            return;
        }/*else{
            if(begin >0 ){
                Iterator<Integer> it = path.iterator();
                while(it.hasNext()){
                    int t = it.next();

                }
            }
        }*/
        for(int i = begin;i < nums.length;i++){
            // 剪枝，重复元素
            if(i>begin && nums[i] == nums[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            inSet.add(i);
            dfs(nums, i+1, path, res, set,inSet);
            path.removeFirst();//remove head
            inSet.remove(i);
        }
    }


    public static int makeSubsequence(String searchWord, String resultWord) {
        int i = 0;
        for(char c : searchWord.toCharArray()){
            if(resultWord.charAt(i)==c){
                System.out.println(c+"");
                i++;
            }
        }
//        System.out.println(i);
        return resultWord.length()-i;
    }
    public static int sumOfFluctuation(int[] nums) {
        int ans =0;
        int n = nums.length;
//        List<Integer> list = Stream.of(nums).map(e-> Integer.valueOf(e+"")).collect(Collectors.toList());
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int max = 0;
                int min = Integer.MAX_VALUE;
                for(int k = j;k<=j+i&& j+i<n;k++){
                    max = Math.max(max, nums[k]);
                    min = Math.min(min, nums[k]);
                }
                System.out.println(max+":"+min);
                if(min==Integer.MAX_VALUE){
                    continue;
                }
                ans += max-min;
            }
        }
        return ans;
    }


    private static void dfs1(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> res, int paletteSize, int threshold,int[] used){
        if(path.size()==paletteSize) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            Iterator<Integer> iter = path.iterator();
            int[] arr = new int[paletteSize];
            int in=0;
            while(iter.hasNext()){
                Integer t= iter.next();
                min = Math.min(min,t);
                max = Math.max(max,t);
                arr[in++]=t;
            }
            if(max-min <=threshold && max-min>0){
                System.out.println(Arrays.toString(arr));
                res.add(new ArrayList<>(path));
                return;
            }
        }
        for(int i = begin;i < nums.length;i++){
            // 剪枝，重复元素
            if(i > begin && nums[i] == nums[i-1]&& used[i-1]==1){
                continue;
            }

            path.addLast(nums[i]);
            used[i]=1;
            dfs1(nums, i + 1, path, res, paletteSize, threshold, used);
            path.removeLast();
        }
    }



    public static int[] bestCombos(int[] rating, int k) {
        List<Integer> res = new ArrayList<>();
//        Arrays.sort(rating);
        for (int i = 0; i < rating.length-1; i++) {
            if(rating[i]<rating[i+1]) {
                int t = rating[i];
                rating[i] = rating[i + 1];
                rating[i + 1] = t;
            }
        }
        extracted(rating);
        ArrayDeque<Integer> path = new ArrayDeque<>();//use as stack
        int sum = 0;
        backtracking1(rating,0,sum, path, res);
        res.sort((s1,s2)->s1-s2);

        int[] ans = new int[k];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;

    }

    private static void extracted(int[] rating) {
        System.out.println(Arrays.toString(rating));
    }

    private static void backtracking1(int[] rating,int s,int sum, ArrayDeque<Integer> path, List<Integer> res) {
//        int sum = 0;
//        Iterator<Integer> iterator = path.iterator();
//        while(iterator.hasNext()){
//            sum+=iterator.next();
//        }
        if(sum>0){
            res.add(sum);
            return;
        }
//        for(int i = rating.length-1;i >-1;i--) {
        for(int i = s; i < rating.length; i++) {

            if ((i > s && rating[i] == rating[i - 1]) || (!path.isEmpty()&&path.peekFirst()==rating[i])) {
                continue;
            }
            sum+=rating[i];

            path.offerLast(rating[i]);
            backtracking1(rating,s,sum, path, res);
            path.pollLast();
        }
    }

    public List<List<Integer>> combination(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();//use as stack
        backtracking(candidates, 0, target, path, res);
        return res;
    }
    public void backtracking(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 小于0的被剪枝，一次递归的终止条件值只判断等于0的情况
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {
            // 前提候选数组有序，然后剪枝
            if(target - candidates[i] < 0){
                break;
            }
            path.offerLast(candidates[i]);
            backtracking(candidates, i, target - candidates[i], path, res);
            path.pollLast();
        }
    }

    //排列：需要保证顺序
    //组合：忽略顺序
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();//use as stack
        dfs(candidates, 0, target, path, res);
        return res;
    }
    public void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 小于0的被剪枝，一次递归的终止条件值只判断等于0的情况
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {
            // 前提候选数组有序，然后剪枝
            if(target - candidates[i] < 0){
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i], path, res);
            path.removeLast();
        }
    }
    //全排列：不含子数组
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>(); // 用栈去构造path,存储已经选了哪些数
        boolean[] used = new boolean[nums.length];  // 用一个used数组判断是否被用过
        dfs(nums, 0, path, used, res); // 递归每一层
        return res;
    }
    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res){
        if(depth == nums.length){  // 当遍历的层数等于数组长度时结束
            res.add(new ArrayList<>(path)); // 将path的拷贝加入到res中，就不会出现多余的空列表，要注意
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;  // 如果使用过，则跳出
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depth+1, path, used, res); // 遍历下一层
            path.removeLast(); //回溯，回到上一层结点
            used[i] = false;
        }
    }

    public static int splitString(String S, int K) {
        if (S.length() <= K) {
            return 0;
        }
        int n = S.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        int count = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                count++;
            }
        }
        if (count < K) {
            return 0;
        }
        return 0;
    }

    private static int imbalancedGroup(int[] nums) {
        List<Integer> minDeque = new ArrayList<>();
        List<Integer> maxDeque = new ArrayList<>();
        int res = 0;
        for (int R = 0; R < nums.length; R++) {
            while (!minDeque.isEmpty() && nums[minDeque.get(minDeque.size() - 1)] > nums[R]) {
                minDeque.remove(minDeque.size() - 1);
            }
            minDeque.add(R);
            while (!maxDeque.isEmpty() && nums[maxDeque.get(maxDeque.size() - 1)] < nums[R]) {
                maxDeque.remove(maxDeque.size() - 1);
            }
            maxDeque.add(R);
            if (!minDeque.isEmpty()) {
                int i = 0, j = 0;
                for (int L = 0; L <= R; L++) {
                    int min = L <= minDeque.get(i) ? nums[minDeque.get(i)] : nums[minDeque.get(++i)];
                    int max = L <= maxDeque.get(j) ? nums[maxDeque.get(j)] : nums[maxDeque.get(++j)];
                    int len = R - L + 1;
                    if (max - min >= len) res++;
                }
            }
        }
        return res;
    }
}
