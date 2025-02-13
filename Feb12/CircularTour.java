package Feb12;

public class CircularTour {
    static int findStartingPoint(int[] petrol, int[] distance) {
        int totalPetrol = 0;
        int totalDistance = 0;
        int currentSurplus = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currentSurplus += petrol[i] - distance[i];

            // If currentSurplus becomes negative, reset start to the next pump
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }

        // If total petrol is less than total distance, no solution exists
        return (totalPetrol >= totalDistance) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startPoint = findStartingPoint(petrol, distance);
        System.out.println("Starting Point: " + (startPoint == -1 ? "No solution" : startPoint));
    }
}

