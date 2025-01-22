import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your city of origin: ");
        String fromCity = input.nextLine();

        System.out.print("Enter your via city: ");
        String viaCity = input.nextLine();

        System.out.print("Enter your final destination city: ");
        String toCity = input.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = input.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = input.nextDouble();

        System.out.print("Enter the time taken for the journey in hours: ");
        double timeTaken = input.nextDouble();
        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;
        System.out.printf("Traveler: %s%n", name);
        System.out.printf("Journey details: From %s to %s via %s%n", fromCity, toCity, viaCity);
        System.out.printf("Total distance covered: %.2f miles%n", totalDistance);
        System.out.printf("Average speed: %.2f miles/hour%n", averageSpeed);

        input.close();
    }
}
