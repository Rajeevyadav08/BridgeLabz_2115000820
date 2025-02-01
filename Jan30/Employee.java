package Jan30;

import java.util.Scanner;

public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void displayDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee emp1 = new Employee(name, id, salary);
        emp1.displayDetails();
        System.out.print("\nDo you want to update the employee details? (yes/no): ");
        scanner.nextLine(); 
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new Name: ");
            String newName = scanner.nextLine();
            emp1.setName(newName);

            System.out.print("Enter new Salary: ");
            double newSalary = scanner.nextDouble();
            emp1.setSalary(newSalary);
        }

        emp1.displayDetails();
        scanner.close();
    }
}
