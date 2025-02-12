package Feb10;

import java.util.Scanner;

class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    Movie prev, next;

    Movie(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.prev = this.next = null;
    }
}

class MovieManagementSystem {
    private Movie head, tail;

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(String title, String director, int yearOfRelease, double rating, int position) {
        if (position <= 1) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        Movie current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            addAtEnd(title, director, yearOfRelease, rating);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) current.next.prev = newMovie;
            current.next = newMovie;
            if (newMovie.next == null) tail = newMovie;
        }
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;

                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;

                System.out.println("Movie '" + title + "' removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    // Search for movies by director or rating
    public void searchByDirectorOrRating(String director, double rating) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director) || current.rating == rating) {
                System.out.println(current.title + " (" + current.yearOfRelease + ") - Directed by: " + current.director + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("No movies found with specified criteria.");
    }

    // Display all movie records in forward order
    public void displayForward() {
        Movie current = head;
        while (current != null) {
            System.out.println(current.title + " (" + current.yearOfRelease + ") - Directed by: " + current.director + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayReverse() {
        Movie current = tail;
        while (current != null) {
            System.out.println(current.title + " (" + current.yearOfRelease + ") - Directed by: " + current.director + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating for movie '" + title + "' updated to " + newRating + ".");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie '" + title + "' not found.");
    }
}

public class MovieManagementApp {
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMovie Management System");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director or Rating");
            System.out.println("6. Display All Movies (Forward)");
            System.out.println("7. Display All Movies (Reverse)");
            System.out.println("8. Update Movie Rating");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title1 = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director1 = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year1 = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating1 = sc.nextDouble();
                    mms.addAtBeginning(title1, director1, year1, rating1);
                    break;
                case 2:
                    System.out.print("Enter Title: ");
                    String title2 = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director2 = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year2 = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating2 = sc.nextDouble();
                    mms.addAtEnd(title2, director2, year2, rating2);
                    break;
                case 3:
                    System.out.print("Enter Title: ");
                    String title3 = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director3 = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year3 = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating3 = sc.nextDouble();
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    mms.addAtPosition(title3, director3, year3, rating3, position);
                    break;
                case 4:
                    System.out.print("Enter Title to Remove: ");
                    String title4 = sc.nextLine();
                    mms.removeByTitle(title4);
                    break;
                case 5:
                    System.out.print("Enter Director or Rating to Search: ");
                    String directorOrRating = sc.nextLine();
                    try {
                        double rating = Double.parseDouble(directorOrRating);
                        mms.searchByDirectorOrRating("", rating);
                    } catch (NumberFormatException e) {
                        mms.searchByDirectorOrRating(directorOrRating, -1);
                    }
                    break;
                case 6:
                    mms.displayForward();
                    break;
                case 7:
                    mms.displayReverse();
                    break;
                case 8:
                    System.out.print("Enter Title to Update Rating: ");
                    String title8 = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    mms.updateRating(title8, newRating);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

