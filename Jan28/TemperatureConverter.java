package Jan28;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature:");
        double temperature = scanner.nextDouble();
        
        System.out.println("Convert to (C/F):");
        char unit = scanner.next().toUpperCase().charAt(0);
        
        if (unit == 'C') {
            System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(temperature));
        } else if (unit == 'F') {
            System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(temperature));
        } else {
            System.out.println("Invalid unit. Please enter C for Celsius or F for Fahrenheit.");
        }
    }
    
    private static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
    
    private static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}
