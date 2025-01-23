import java.util.Scanner;
public class RocketLaunchForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the countdown starting number: ");
        int count = scanner.nextInt();
        scanner.close();
        for (int i = count; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Blast Off!");
    }
}