package sigma.AA;

public class Student {
    public String name;
    int enrollmentId;
    String address;
    String city;

    public Student(String name, int enrollmentId, String address, String city) {
        this.name = name;
        this.enrollmentId = enrollmentId;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", enrollmentId=" + enrollmentId +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}' + '\n';
    }

}
