package sigma;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class SS {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("a"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(list.add("f"));
        System.out.println(list.remove("f"));
        Object[] array = list.toArray();
        System.out.println(array);
        String[] array2 = list.toArray(new String[list.size()]);
        System.out.println(array2);
        List<String> sublist = new ArrayList<>();
        sublist.add("a");

        System.out.println(list.containsAll(sublist));

        list.addAll(sublist);
        System.out.println(list.retainAll(sublist));

        list.removeAll(sublist);
        boolean removeIf = list.removeIf(e -> e.equals("a"));
        System.out.println(removeIf);

        System.out.println(list.equals(sublist));
        System.out.println(list.hashCode());
        Spliterator<String> spliterator = list.spliterator();
        System.out.println(spliterator);

        List<String> subList2 = list.stream().filter(e -> e.equals("a")).collect(Collectors.toList());
        System.out.println(subList2);
        long num = list.parallelStream().map(e -> e.length() == 1).count();
        System.out.println(num);

        list.clear();
    }
}
