package practice4;

public class Student{
    private String name;
    private int age;
    private Course course;
    private String city;

    public Student(String name, int age, Course course, String city) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.city = city;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
