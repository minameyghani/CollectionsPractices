package practice3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Student> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many students would you like to insert?");
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Id for Student:");
            int id_student = scanner.nextInt();
            System.out.println("Enter name for Student:");
            String name = scanner.next();
            System.out.println("Enter grade for Student:");
            float grade = scanner.nextFloat();
            students.put(id_student, new Student(id_student, name, grade));
        }
        System.out.println(CalGrades(students).toString());
    }

    public static Map<Float, Integer> CalGrades(Map<Integer, Student> a) {
        List<Float> grades = new ArrayList<>();
        Map<Float, Integer> countGrades = new HashMap<>();
        for (Student s : a.values()) {
            grades.add(s.getGrade());
        }

        for (int i = 0; i < grades.size(); i++) {
            int count = 0;
            float g = grades.get(i);
            for (int j = 0; j < grades.size(); j++) {
                if (grades.get(i).equals(grades.get(j))) {
                    count++;
                }
            }
            countGrades.put(g, count);
        }
        return countGrades;
    }

}