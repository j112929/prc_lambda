package AB;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A {
    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");

        /*
		List<String> sortedList = list.stream()
			.sorted(Comparator.naturalOrder())
			.collect(Collectors.toList());

        List<String> sortedList = list.stream()
			.sorted((o1,o2)-> o1.compareTo(o2))
			.collect(Collectors.toList());
		*/

        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());

//        sortedList.forEach(System.out::println);
        List<Integer> l = Arrays.asList(2, 3, 5, 8, 8, 9);
        Stream<Integer> limit = l.stream().sorted().limit(1);
        int i = limit.reduce(1, Integer::compareTo).intValue();
        System.out.println(i);

        System.out.println(10 % 15);
    }
}
