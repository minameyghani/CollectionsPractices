import java.util.*;

public class Practice1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println("welcome.how many numbers would you like to enter? : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Enter numbers : ");
        for (int i = 0; i < number; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        System.out.println("Ascending sorted list : " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Descending sorted list : " + list);

    }


}
