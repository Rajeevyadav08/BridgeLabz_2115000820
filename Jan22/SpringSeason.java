public class SpringSeason {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java SpringSeason <month> <day>");
            System.exit(1);
        }
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}