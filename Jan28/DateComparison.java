package Jan28;

import java.time.LocalDate;

public class DateComparison {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2025, 1, 29);
        LocalDate date2 = LocalDate.of(2024, 12, 15);

        boolean isBefore = date1.isBefore(date2);
        boolean isAfter = date1.isAfter(date2);
        boolean isEqual = date1.isEqual(date2);

        System.out.println("Date 1 is before Date 2: " + isBefore);
        System.out.println("Date 1 is after Date 2: " + isAfter);
        System.out.println("Date 1 is equal to Date 2: " + isEqual);
    }
}
