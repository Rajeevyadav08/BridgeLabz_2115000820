public class EarthVolumeCalculator {
    public static void main(String[] args) {
        double radiusInKm = 6378.0;
        double pi = Math.PI;
        double volumeInKm3 = (4.0 / 3.0) * pi * Math.pow(radiusInKm, 3);
        double conversionFactor = 0.239913;
        double volumeInMiles3 = volumeInKm3 * conversionFactor;
        System.out.printf("The volume of earth in cubic kilometers is %.2f and cubic miles is %.2f%n", volumeInKm3, volumeInMiles3);
    }
}
