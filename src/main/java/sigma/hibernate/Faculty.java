package sigma.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Faculty {
    @Id
    long id;
    String first_name;
    String last_name;
    String city;
    int age;
    int salary;
    long department_id;

    public Faculty(int id, String first_name, String last_name, String city, int age, int salary, long department_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.age = age;
        this.salary = salary;
        this.department_id = department_id;

    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department_id=" + department_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;

        Faculty faculty = (Faculty) o;

        if (id != faculty.id) return false;
        if (age != faculty.age) return false;
        if (salary != faculty.salary) return false;
        if (department_id != faculty.department_id) return false;
        if (!first_name.equals(faculty.first_name)) return false;
        if (!last_name.equals(faculty.last_name)) return false;
        return city.equals(faculty.city);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + first_name.hashCode();
        result = 31 * result + last_name.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + age;
        result = 31 * result + salary;
        result = 31 * result + (int) (department_id ^ (department_id >>> 32));
        return result;
    }
}
