import java.util.Scanner;

public class YoungestTallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter Akbar's age: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter Anthony's age: ");
        int ageAnthony = scanner.nextInt();

        System.out.print("Enter Amar's height (in meters): ");
        double heightAmar = scanner.nextDouble();
        System.out.print("Enter Akbar's height (in meters): ");
        double heightAkbar = scanner.nextDouble();
        System.out.print("Enter Anthony's height (in meters): ");
        double heightAnthony = scanner.nextDouble();

        String youngest = "Amar";
        if (ageAkbar < ageAmar) {
            youngest = "Akbar";
        }
        if (ageAnthony < Math.min(ageAmar, ageAkbar)) {
            youngest = "Anthony";
        }

        String tallest = "Amar";
        if (heightAkbar > heightAmar) {
            tallest = "Akbar";
        }
        if (heightAnthony > Math.max(heightAmar, heightAkbar)) {
            tallest = "Anthony";
        }

        System.out.println("Youngest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);

        scanner.close();
    }
}