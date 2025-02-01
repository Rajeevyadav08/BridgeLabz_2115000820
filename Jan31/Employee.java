package Jan31;

public class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID + ", Department: " + department + ", Salary: $" + salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerInfo() {
        System.out.println("Manager ID: " + employeeID + ", Department: " + department);
    }

    public static void main(String[] args) {
        Manager manager1 = new Manager(101, "IT", 75000);
        manager1.displayManagerInfo();
        System.out.println(manager1);
        manager1.setSalary(80000);
        System.out.println("Updated " + manager1);
    }
}
