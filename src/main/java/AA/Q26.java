package AA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Q26 {
    static void Test() {
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10, "Jim"));
        list.add(new Student(20, "Tom"));
        list.add(new Student(30, "Kim"));
        list.add(new Student(40, "Jerry"));
        list.add(new Student(50, "Henry"));
        Collections.sort(list);
        Student student = list.get(0);
        System.out.println("student name:" + student.name + ", grade:" + student.grade);


    }

    public static class Student implements Comparable {
        private final int grade;
        private final String name;

        public Student(int grade, String name) {
            this.grade = grade;
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            Student student = (Student) o;
            return ((Student) o).grade;
        }
    }
}
