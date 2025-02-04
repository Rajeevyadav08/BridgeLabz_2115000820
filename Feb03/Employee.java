package Feb03;
import java.util.Scanner;
public class Employee {
    private static String companyName = "Tech Solutions";
    private static int totalEmployees = 0;
    private final int id;
    private String name;
    private String designation;
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("\nCompany: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();
            employees[i] = new Employee(name, id, designation);
        }
        displayTotalEmployees();
        System.out.println("\n--- Employee List ---");
        for (Employee emp : employees) {
            emp.displayEmployeeDetails();
        }
        scanner.close();
    }
}
