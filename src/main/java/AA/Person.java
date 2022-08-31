package AA;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
    private final String surname;
    private final String name;

    public Person(String surname, String name) {
        this.surname = surname;
        this.name = name;

    }

    public static void main(String[] args) {
        Map<Person, String> m = new HashMap<>();
        Person p1 = new Person("j", "z");
        Person p2 = new Person("j", "z");
        m.put(p1, "p1");
        System.out.println(m.get(p2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(surname, person.surname) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }

}
