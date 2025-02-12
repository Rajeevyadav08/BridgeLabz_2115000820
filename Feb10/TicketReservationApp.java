package Feb10;

import java.util.Scanner;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private int totalTickets = 0;

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        totalTickets++;
        System.out.println("Ticket booked successfully for " + customerName);
    }

    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;
        do {
            if (current.ticketID == ticketID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket with ID " + ticketID + " removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket with ID " + ticketID + " not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("\nCurrent Ticket Reservations:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + 
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + 
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for keyword: " + keyword);
        }
    }

    public void countTickets() {
        System.out.println("Total number of booked tickets: " + totalTickets);
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nOnline Ticket Reservation System");
            System.out.println("1. Add Ticket Reservation");
            System.out.println("2. Remove Ticket by Ticket ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer Name or Movie Name");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String bookingTime = sc.nextLine();
                    system.addTicket(ticketID, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeID = sc.nextInt();
                    system.removeTicket(removeID);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;
                case 5:
                    system.countTickets();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
