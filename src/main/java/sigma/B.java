package sigma;

import java.util.*;
import java.util.stream.Collectors;

public class B {
    private static Optional<Integer> findFirst;

    public static void main(String[] args) {
        // System.out.println("Hello World");
        // String s1 = "";
        // String s_1 = "";

        // String a = "test";
        // String b = new String("test");
        // String c = "test";
        //
        // System.out.println(a == b);
        // System.out.println(a == c);
        // System.out.println(a.equals(b));
        // System.out.println(a.equals(c));

        /*
         * for(int i=1; i<=10; i++){
         * if(i==4){
         * continue;
         * }
         * if(i==8){
         * break;
         * }
         * System.out.println(i);
         * }
         */

        /*
         * String s = "    I’m learning Java    ";
         * // remove the leading and trailing spaces
         * s=s.replaceAll("    ","");
         * System.out.println(s);
         * // then find the length of the string
         * int length = s.length();
         * System.out.println(length);
         * // convert the string into lowercase
         * s = s.toLowerCase();
         * System.out.println(s);
         */

        List<Integer> listA = Arrays.asList(1, 2, 3, 4);
        // list.add(4);//Exception in thread "main"
        // java.lang.UnsupportedOperationException
        List<Integer> list1 = listA.stream().filter(e -> e % 2 == 0).map(e -> {
            System.out.println(e);
            return e;
        }).collect(Collectors.toList());
        // Optional<Integer> op = list.stream().max((o1,o2)->{return
        // o1.compareTo(o2);}).stream().findAny()..map(e-> {System.out.println(e);
        // return e;});

        List<String> loseWeight = new ArrayList<>();
        loseWeight.add("avocados");
        loseWeight.add("beans");
        loseWeight.add("salad");
        loseWeight.add("oats");
        loseWeight.add("broccoli");
        List<Integer> listOfInts = loseWeight.stream().map(s -> s.length()).collect(Collectors.toList());
        System.out.println("list of ints generate by map(): " + listOfInts);

        List<List<Integer>> listOfListOfNumber = new ArrayList<>();
        listOfListOfNumber.add(Arrays.asList(2, 4));
        listOfListOfNumber.add(Arrays.asList(3, 9));
        listOfListOfNumber.add(Arrays.asList(4, 16));
        List<Integer> listOfIntegers = listOfListOfNumber.stream().flatMap(list -> list.stream())
                // .filter(e -> e % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("list of numbers generated by flatMap : " + listOfIntegers);

        Optional<Integer> op = listOfListOfNumber.stream().flatMap(list -> list.stream())
                // .filter(e -> e % 2 == 0)
                .sorted().findFirst();
        System.out.println(op.get());
        // .collect(Collectors.toList());

        int[] arr = {1, 2, 3, 4, 5};
        // List<int[]> asList = Arrays.asList(arr);
        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);
        int binarySearch = Collections.binarySearch(asList, 5);
        System.out.println(binarySearch);

        if (arr[1] > 0) {
            System.out.println(1);
        } else if (arr[1] < 2) {
            System.out.println(2);
        }

    }
    // ExecutorService es = new ScheduledThreadPoolExecutor(1);
    // es.
}