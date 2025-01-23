public class DayOfWeek {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java DayOfWeek <month> <day> <year>");
            System.exit(1);
        }
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.err.println("Invalid date.");
            System.exit(1);
        }
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;
        System.out.println("Day of the week: " + d0); 
    }
}