package Hankerrank.AA;

import java.util.*;
import java.util.stream.Collectors;

public class SS {
    public static void main(String[] args) {
        // int[] paths = { 3, -4, -3, -5, 0 };
        // // { 100, -70, -90, -80, 100 };
        // // { 10, -20, -5 };
        // int maxLength = 2;
        // // 3;
        // // 2;
        // System.out.println(maxSumLeftToRight(paths, maxLength));

        // int[] numCars = { 5, 4, 5, 3, 2 };
        // int[] hourStartQ = { 1, 2, 4, 5 };
        // int[] ans = freqOfValue(numCars, hourStartQ);
        // System.out.println(Arrays.toString(ans));

        // int amount = 4;// 1
        // // 7;//-1
        // // 6; //2
        // // 5;//1
        // int[] coins = { 2, 4 };
        // // { 3, 5 };
        // System.out.println(change1(amount, coins));

        // String[] grid = { "..", ".." };// 2
        // // { "..$$", "$.$$", "$..." };//5
        // int maxTime = 3;
        // // 6;
        // System.out.println(maze2d(grid, maxTime));

        // String s = "abab";//2
        // System.out.println(getMinDeletions(s));
        // int[] arr = {3,4,6,6,3};

        // List<Integer> numbers = Arrays.asList(3, 4, 6, 6, 3);
        // System.out.println(countMoves(numbers));

        // int[] people = { 1, 3, 3, 4, 4, 4 };
        // System.out.println(countRepeats(people));

        // String[] words = { "the", "bats", "tabs", "in", "cat", "act" };// [4,2,4]
        // // { "west", "has", "stew", "good", "it" };//[4,2]
        // String[] phrases = { "cat the bats", "in the act", "act tabs in" };
        // // { "west has good stew", "good stew" };
        // System.out.println(Arrays.toString(countAnagramPhrase(words, phrases)));

        // System.out.println(di());
//        di();
        /*int[][] board = {{3,1,2,1},
                {1,1,1,4},
                {3,1,2,2},
                {3,3,3,4}
        };
        int[][] crush = candyCrush(board);
        for (int i = 0; i < crush.length; i++) {
            System.out.println(Arrays.toString(crush[i]));
        }*/

        /*int[] wins={3,1,2,2};//3
//                {2,1,0};//1
        int[] draws ={1,5,4,4};
//                {1,5,6};
        int[] scored={30,10,20,40};
//                {20,15,10};
        int[] conceded={32,13,18,37};
//                {20,10,15};
        System.out.println(sol(wins,draws,scored,conceded));*/

        /*int[] nums = {7,23,3,1,3,5,2};//3
//                {1,3,2};//0
//                {11,4,23,9,10};//9
        int[] range = {2,7};
//                {1,1};
//                {5,12};
        System.out.println(sol1(nums,range));*/

        /*List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1,2));
        nums.add(Arrays.asList(1,5));
        nums.add(Arrays.asList(2,5,2));
        nums.add(Arrays.asList(2,6,3));
        nums.add(Arrays.asList(2,2,1));
        nums.add(Arrays.asList(2,3,2));

        System.out.println(rang1(nums));*/

        /*int[] nums ={10,10,10,10,10};//[0,0,0]
//                {1,2,1,-4,5,10};//[0,1,0,1]
        System.out.println(Arrays.toString(plusOrMinus(nums)));*/

        /*int[] nums = {-2,4,5,6,7};//5
//                {-5,3,4,9};//-1
        int r = 1;
//                5;
        System.out.println(placeLamp(nums,r));*/

        /*String[] arr = {"00:00", "14:00","19:55"};//-1
//                {"12:30", "14:00","19:55"};//90,30
        String time = "00:00";//-1
//                "14:00";//90
//                "14:30";//30
        System.out.println(time(arr, time));*/

        /*char[][] m = {
                {'F','F','F'},
                {'.','F','.'},
                {'.','F','F'},
                {'#','F','.'},
                {'F','F','.'},
                {'.','.','.'},
                {'.','.','#'},
                {'.','.','.'}
        };
        char[][] ans = down(m);
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }*/

        int[] nums = {-2, -1, 0, 1, 2};//5
//                {2};//1
//                {1, -1, 2, 3};//5
        System.out.println(solution(nums));
    }

    public static int solution(int[] numbers) {
        int n = numbers.length;
        int ans = 0;
        Set<String> combination = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = numbers[i] + numbers[j];
                String k = Math.min(numbers[i], numbers[j]) + ":" + Math.max(numbers[i], numbers[j]);
                if (tmp > 0 && (tmp & (tmp - 1)) == 0 && !combination.contains(k)) {
                    combination.add(k);
                    System.out.println(numbers[i] + ":" + numbers[j]);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static char[][] down(char[][] m) {
        int row = m.length;
        int col = m[0].length;
        //障碍的位置
        int[] obstacle = new int[col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (m[j][i] == '#') {
                    obstacle[i] = j;
                }
                if (j == row - 1 && obstacle[i] == 0) {
                    obstacle[i] = -1;
                }
            }
        }
        //每列的最小移动距离
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (obstacle[i] == -1) continue;
                if (m[j][i] == 'F') {
                    if (j < obstacle[i]) {
                        min = Math.min(min, obstacle[i] - j - 1);
                    } else {
                        min = Math.min(min, row - 1 - j);
                    }
                }
            }
        }
        if (min == 0) {
            return m;
        }
        int[][] dp = new int[row][col];
        for (int i = row - 1; i >= min; i--) {
            for (int j = 0; j < col; j++) {
                if (m[i - min][j] == 'F') {
                    m[i][j] = 'F';
                    m[i - min][j] = '.';
                }

            }
//            System.out.println("tmp:"+Arrays.toString(m[i]));
        }
        return m;
    }

    public static int time(String[] arr, String time) {
        if (arr[0].equals(time)) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int hour = time.startsWith("00") ? 0 : Integer.parseInt(time.substring(0, 2));
        int minute = time.substring(3).equals("00") ? 0 : Integer.parseInt(time.substring(3));
        for (int i = 0; i < arr.length; i++) {
            int hour1 = arr[i].startsWith("00") ? 0 : Integer.parseInt(arr[i].substring(0, 2));
            int minute1 = arr[i].substring(3).equals("00") ? 0 : Integer.parseInt(arr[i].substring(3));
            int sum = 0;
            if (hour1 > hour) {
                if (minute1 >= minute) {
                    sum += minute1 - minute + (hour1 - hour) * 60;
                } else {
                    sum += minute1 + 60 - minute + (hour1 - 1 - hour) * 60;
                }
            } else if (hour1 < hour) {
                if (minute >= minute1) {
                    sum += minute - minute1 + (hour - hour1) * 60;
                } else {
                    sum += minute + 60 - minute1 + (hour - 1 - hour1) * 60;
                }
            } else {
                if (minute1 >= minute) {
                    sum += minute1 - minute;
                } else {
                    sum += minute - minute1;
                }
            }
            //System.out.println(hour+":"+minute+ "? "+ sum);
            if (sum == 0) continue;
            ans = Math.min(sum, ans);
        }
        return ans;
    }

    public static int placeLamp(int[] nums, int r) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff % 2 == 0) {
                if (diff / 2 <= r) {
                    return (nums[i - 1] + nums[i]) / 2;
                }
            } else {
                if (diff / 2 + 1 <= r) {
                    return (nums[i - 1] + nums[i]) / 2 + 1;
                }
            }
        }
        return ans;
    }

    public static int[] plusOrMinus(int[] nums) {
        int[] ans = new int[nums.length - 2];
        if (nums.length < 3) return ans;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i] > nums[i + 1] && nums[i - 1] > nums[i]) ||
                    (nums[i] < nums[i + 1] && nums[i - 1] < nums[i])) {
                ans[i - 1] = 1;
            } else {
                ans[i - 1] = 0;
            }
        }
        return ans;
    }

    public static String rang1(List<List<Integer>> nums) {
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> tmp = nums.get(i);
            if (tmp.get(0).intValue() == 1) {
                if (i == 0) {
                    start = tmp.get(1).intValue();
                } else {
                    end = tmp.get(1).intValue();
                    if (start > end) {
                        int t = start;
                        start = end;
                        end = t;
                    }
                }
            } else {
                int x = tmp.get(1).intValue();
                int size = tmp.get(2).intValue();
                int flag = 1;
                for (int j = x - size; j < x; j++) {
                    if (j == start || j == end) {
                        flag = 0;
                        break;
                    }
                }
                ans.add(flag);
            }
        }
        String result = ans.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("", "", ""));
        return result;
//        StringBuilder sb = new StringBuilder();
//        for (Integer i : ans){
//            sb.append(i);
//        }
//        return sb.toString();

    }

    public static int[][] candyCrush(int[][] board) {
        int R = board.length, C = board[0].length;
        boolean todo = false;
        //1）把row中可以消除的元素set to -v
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c + 2 < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -v;
                    todo = true;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            System.out.println("tmp:" + Arrays.toString(board[i]));
        }
        //2） 把column中可以消除的元素set to -v
        for (int r = 0; r + 2 < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -v;
                    todo = true;
                }

            }
        }
        for (int r = R - 1; r >= R - 2; r--) {
            for (int c = 0; c < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && (c + 1 < C && v == Math.abs(board[r][c + 1]))
                        && (r - 1 > -1 && v == Math.abs(board[r - 1][c]))) {
                    board[r][c] = board[r][c + 1] = board[r - 1][c] = -v;
                    todo = true;
                }
            }
        }

        for (int c = 0; c < C; ++c) {
            int wr = R - 1;
            for (int r = R - 1; r >= 0; --r)
                if (board[r][c] > 0)
                    board[wr--][c] = board[r][c];
            while (wr >= 0)
                board[wr--][c] = 0;
        }

        return todo ? candyCrush(board) : board;
    }

    public static int sol1(int[] nums, int[] range) {
        if (range[0] == range[1]) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > range[0] && nums[i] < range[1]
                    && nums[i + 1] > range[0] && nums[i + 1] < range[1]
                    && nums[i] < nums[i + 1]) {
                ans = nums[i];
            }
        }
        return ans;
    }

    public static int sol(int[] wins, int[] draws, int[] scored, int[] conceded) {
        int[] dp = new int[wins.length];
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < wins.length; i++) {
            dp[i] = wins[i] * 3 + draws[i];
            if (dp[i] > max) {
                count = 1;
                max = dp[i];
            } else if (dp[i] == max) {
                count++;
            }
        }
        if (count == 1) {
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == max) return i;
            }
        }
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) indexs.add(i);
        }
        System.out.println(indexs);
        int maxScore = Integer.MIN_VALUE;
        int ans = 0;
        for (Integer index : indexs) {
            if (scored[index] - conceded[index] > maxScore) {
                maxScore = scored[index] - conceded[index];
                ans = index;
            }
        }
        return ans;
    }


    public static int[] countAnagramPhrase(String[] words, String[] phrases) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int[] ans = new int[phrases.length];
        for (int i = 0; i < phrases.length; i++) {
            String[] phrase = phrases[i].split(" ");
            int times = 1;
            for (String str : phrase) {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String key = String.valueOf(arr);
                if (map.containsKey(key)) {
                    times *= map.get(key).intValue();
                }
            }
            ans[i] = times;
        }
        return ans;
    }

    public static int countRepeats(int[] people) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < people.length; i++) {
            map.put(people[i], map.getOrDefault(people[i], 0) + 1);
        }
        int ans = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i).intValue() > 1)
                ans++;
        }
        return ans;
    }

    public static long countMoves(List<Integer> numbers) {
        long arrsum = 0,
                smallest = (long) numbers.get(0),
                arr_size = numbers.size();
        for (int i = 0; i < arr_size; i++) {
            long temp = (long) numbers.get(i);
            if (temp < smallest)
                smallest = temp;
            arrsum += temp;
        }
        long minOperation = arrsum - arr_size * smallest;
        return minOperation;
    }

    public static int[] freqOfValue(int[] numCars, int[] hourStartQ) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[hourStartQ.length];
        for (int i = 0; i < hourStartQ.length; i++) {
            int max = 0;
            for (int j = hourStartQ[i] - 1; j < numCars.length; j++) {
                map.put(numCars[j], map.getOrDefault(numCars[j], 0).intValue() + 1);
                max = Math.max(max, numCars[j]);
            }
            ans[i] = map.get(max).intValue();
            map.clear();
        }
        return ans;
    }

    public static int maxSumLeftToRight(int[] paths, int maxLength) {
        int max = Integer.MIN_VALUE;
        int n = paths.length;
        int[] dp = new int[n];
        for (int i = 0; i <= n - maxLength; i++) {
            int sum = paths[i];
            if (dp[i] != 0) {
                sum = dp[i];
            }
            for (int j = i + 1; j <= maxLength + i && j < n; j++) {
                max = Math.max(sum + paths[j], max);
                dp[j] = max;
            }
        }
        return max;
    }

    public static int change(int amount, int[] coins) {
        // index 是金额, 下标对应的值是它们的频次, 核心是利用下标进行计算
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i < coin)
                    continue;
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static int change1(int amount, int[] coins) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == amount) {
                return 1;
            }
            if (amount % coins[i] == 0) {
                min = Math.min(min, amount / coins[i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static String maze2d(String[] grid, int maxTime) {
        int[] dp = new int[1];
        dfsMaze(0, 1, grid, dp);
        System.out.println(dp[0]);
        return dp[0] <= maxTime ? "YES" : "NO";
    }

    public static void dfsMaze(int x, int y, String[] grid, int[] dp) {
        int row = grid.length;
        int col = grid[0].length();
        if (x > row - 1 || y > col - 1)
            return;
        if (grid[x].charAt(y) == '$')
            return;

        dp[0]++;
        // System.out.println(x + ":" + y + "?" + grid[x].charAt(y));
        if (x == row - 1 && y == col - 1) {
            return;
        }
        // to right
        dfsMaze(x, y + 1, grid, dp);
        // to bottom
        dfsMaze(x + 1, y, grid, dp);
    }

    public static int getMinDeletions(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            set.add(c);
        }
        return s.length() - set.size();
    }

    public static void di() {
        int ans = 0;
        int both = 0;
        for (int i = 100; i <= 999; i++) {
            if (i % 3 == 0)
                ans++;
            if (i % 4 == 0)
                ans++;
            if (i % 3 == 0 && i % 4 == 0)
                both++;
        }
        System.out.println(ans - both);
    }

    /**
     * @param arr
     * @return
     */
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        TreeSet<String> t = new TreeSet<String>();
        Arrays.sort(arr);
        int l;
        int r;
        for (int i = 0; i < arr.length - 2; i++) {
            l = i + 1;
            r = arr.length - 1;
            while (l < r) {
                if (arr[i] + arr[l] + arr[r] == 0) {
                    String str = arr[i] + ":" + arr[l] + ":" + arr[r];
                    if (!t.contains(str)) {
                        row.add(arr[i]);
                        row.add(arr[l]);
                        row.add(arr[r]);
                        ans.add(row);
                        row = new ArrayList<>();
                        t.add(str);
                    }
                    l++;
                    r--;
                } else if (arr[i] + arr[l] + arr[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }


}
