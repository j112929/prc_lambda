package AA;

import java.util.*;

public class I {
    public static void main(String[] args) {
//        String input = "99#7";
//        int number;
//        try {
//            number = Integer.parseInt(input);
//        } catch (NumberFormatException ex) {
//            number = 0;
//        } catch (RuntimeException ex) {
//            number = 1;
//        } catch (Exception ex) {
//            number = -1;
//        }
//
//        System.out.println(number);

//        Scanner inputFile = new Scanner(System.in);
//        double totalIncome = 0.0;
//        while (inputFile.hasNext()) {
//            try {
//                totalIncome += inputFile.nextDouble();
//            } catch (InputMismatchException e) {
//                System.out.println("Non-numeric data encountered " +
//                         "in the file.");
//                inputFile.nextLine();
//            } finally {
//                totalIncome = 35.5;
//            }
//            System.out.println(totalIncome);
//        }

//        int array_variable[] = new int[10];
//        for (int i = 0; i < 10; i += 3) {
//            array_variable[i] = i;
//            System.out.print(array_variable[i] + " ");
//        }

//        int array_variable[] = new int[100];

//        System.out.print(/2);
//        Integer myNumber = new Integer(5);
//        int var = myNumber;

//        List<Integer> a = new ArrayList<>();
//        a.add(3);
//        a.add(1);
//        a.add(2);
//        a.add(5);
////        System.out.println(myList((ArrayList<Integer>) a));
////        List a =
//
////        PriorityQueue
//        String[] y = {"1","2","15","-7","300"};
//        Arrays.sort(y);
//        for (String i : y) {
//            System.out.println(i);
//        }
        /*int[] a = {1,2,0,0,1};
//                {0,2,4};
//                {0};
//                {5,0,0,0};
//                {1,2,3};

        boolean b = can_reach_end(a);
        System.out.println(b);*/
        /*String a = "a"
//                "abcdefgh"
                ;
//                "aaabbb";
//                "abcdcaa";
//                "racecar";
//                "abba";
        int i = almost_palindrome(a);
        System.out.println(i);*/

        /*int[] a = {10,2,3,4,5,6,7,8,9,10};
//                {6,3,2,4,3,1};
//                {4,3,3,1};
//                {2,2};
//                {1, 1, 3, 4};
        int mistake = find_mistake(a);*/
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        System.out.println('R' - 'A');
    }

    public static int myList(ArrayList<Integer> arr) {
        return Collections.max(arr);
    }

    public static int find_mistake(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            list.add(i);
        }
        int repeat = 0;
        Set<Integer> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                repeat = nums[i];
            } else {
                list1.add(nums[i]);
            }
            set.add(nums[i]);
        }
        list.removeAll(list1);
        return list.get(0) + repeat;
    }

    public static int almost_palindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return 0;
        }
        char[] c = str.toCharArray();
        int l = c.length;
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != c[l - 1]) {
                sum++;
            }
            l--;
        }
        return sum;
    }

    public static boolean can_reach_end(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
        }
        if (nums.length > 4) {
            return false;
        } else {
            return sum >= nums[nums.length - 1];
        }
    }


}
