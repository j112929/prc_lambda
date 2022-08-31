package sigma.AA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Student s1 = new Student("s1", 1, "address1", "city1");
        Student s2 = new Student("s2", 2, "address2", "city2");
        Student s3 = new Student("s3", 3, "address3", "city3");
        list.add(s1.toString());
        list.add(s2.toString());
        list.add(s3.toString());

        List<Student> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);

        list1.stream().map(s -> {
            s.name = "name";
            return s;
        }).collect(Collectors.toList());

        // Optional

        // File file = new File("students.txt");
        // try {
        // file.createNewFile();
        // FileWriter myWriter = new FileWriter(file.getName());
        // myWriter.write(String.valueOf(list));
        // myWriter.close();

        // PrintWriter printWriter = new PrintWriter("students1.txt");
        // printWriter.println(list1);
        // printWriter.flush();
        // printWriter.close();

        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }

}
