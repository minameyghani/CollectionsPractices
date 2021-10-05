package practice4;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many students would you like to enter?");
        int num = scanner.nextInt();
        List<Student> s = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("enter student name: ");
            String name = scanner.next();
            System.out.println("enter age of student: ");
            int age = scanner.nextInt();
            System.out.println("enter course number of student: ");
            System.out.println("Mathematics(1),Physics(2),Chemistry(3),Computer(4),Biology(5)");
            int c = scanner.nextInt();
            Course course = findCourse(c);
            System.out.println("enter city of student: ");
            String city = scanner.next();
            s.add(new Student(name, age, course, city));
        }
        System.out.println("--------------------------------------");
        System.out.println("دانش آموزان ------------  نام شهر");
        printMap(calCityStudents(s));
        System.out.println("**********************************");
        System.out.println("نام شهرها ------------  گروه درسی");
        printMap(calCourseCities(s));
        System.out.println("**********************************");
        System.out.println("میانگین سن ------------  نام شهر");
        Map<String, List<Integer>> citiesAge = calCitiesAge(s);
        Map<String, Float> avgAges = calAvgAges(citiesAge);
        printMap(avgAges);
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + "  ------------  " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public static Course findCourse(int a) {
        switch (a) {
            case 1:
                return Course.Mathematics;
            case 2:
                return Course.Physics;
            case 3:
                return Course.Chemistry;
            case 4:
                return Course.Computer;
            case 5:
                return Course.Biology;
        }
        return null;
    }

    public static Map<String, List<String>> calCityStudents(List<Student> students) {
        Map<String, List<String>> citiesStudent = new HashMap<>();
        for (Student s : students) {
            String city = s.getCity();
            List<String> student = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                String c = students.get(i).getCity();
                String name = students.get(i).getName();
                if (city.equals(c)) {
                    student.add(name);
                }
            }
            citiesStudent.put(city, student);

        }


        return citiesStudent;
    }

    public static Map<Course, List<String>> calCourseCities(List<Student> students) {
        Map<Course, List<String>> courseStudent = new HashMap<>();
        for (Student s : students) {
            Course course = s.getCourse();
            int course_value = course.getLabel();
            List<String> cities = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                int c_value = students.get(i).getCourse().getLabel();
                String city = students.get(i).getCity();
                if (course_value == c_value) {
                    cities.add(city);
                }
            }
            courseStudent.put(course, cities);

        }


        return courseStudent;
    }

    public static Map<String, List<Integer>> calCitiesAge(List<Student> students) {
        Map<String, List<Integer>> cityAges = new HashMap<>();
        for (Student s : students) {
            String city = s.getCity();
            List<Integer> ages = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                String c = students.get(i).getCity();
                int age = students.get(i).getAge();
                if (city.equals(c)) {
                    ages.add(age);
                }
            }
            cityAges.put(city, ages);

        }
        return cityAges;
    }

    public static Map<String, Float> calAvgAges(Map<String, List<Integer>> a) {
        Map<String, Float> b = new HashMap<>();
        for (String c : a.keySet()) {
            int sum = 0;
            String city = c;
            List<Integer> ages = new ArrayList<>();
            for (Integer i : a.get(city)) {
                ages.add(i);
            }
            for (int i = 0; i < ages.size(); i++) {
                sum += ages.get(i);
            }
            float avg = (float) sum / (ages.size());
            b.put(city, avg);
        }
        return b;
    }
}
