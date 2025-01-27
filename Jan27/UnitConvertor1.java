package Jan27;

public class UnitConvertor1 {

    private static final double YARDS_TO_FEET = 3.0;
    private static final double FEET_TO_YARDS = 1.0 / YARDS_TO_FEET;
    private static final double METERS_TO_INCHES = 39.3701;
    private static final double INCHES_TO_METERS = 1.0 / METERS_TO_INCHES;
    private static final double INCHES_TO_CENTIMETERS = 2.54;

    public static double convertYardsToFeet(double yards) {
        return yards * YARDS_TO_FEET;
    }

    public static double convertFeetToYards(double feet) {
        return feet * FEET_TO_YARDS;
    }

    public static double convertMetersToInches(double meters) {
        return meters * METERS_TO_INCHES;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * INCHES_TO_METERS;
    }

    public static double convertInchesToCentimeters(double inches) {
        return inches * INCHES_TO_CENTIMETERS;
    }
}