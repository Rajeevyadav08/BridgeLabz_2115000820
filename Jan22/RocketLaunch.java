import java.util.Scanner;
public class RocketLaunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the countdown starting number: ");
        int counter = scanner.nextInt();
        scanner.close();
        while (counter > 0) {
            System.out.println(counter);
            counter--; 
        }
        System.out.println("Blast Off!"); 
    }
}