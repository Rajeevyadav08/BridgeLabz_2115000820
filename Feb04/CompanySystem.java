package Feb04;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void showEmployees() {
        System.out.println("Employees in " + departmentName + " department:");
        for (Employee employee : employees) {
            System.out.println("- " + employee.getName());
        }
    }

    // The Department is deleted when the Company is deleted (due to Composition)
    public void deleteDepartment() {
        employees.clear();
        System.out.println("All employees in " + departmentName + " have been deleted.");
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void showCompanyDetails() {
        System.out.println("Company: " + companyName);
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
        } else {
            for (Department department : departments) {
                department.showEmployees();
            }
        }
    }

    // Deleting a company deletes all departments and employees (Composition relationship)
    public void deleteCompany() {
        for (Department department : departments) {
            department.deleteDepartment();
        }
        departments.clear();
        System.out.println("All departments and employees in " + companyName + " have been deleted.");
    }
}

public class CompanySystem {
    public static void main(String[] args) {
        // Creating employees
        Employee emp1 = new Employee("Alice");
        Employee emp2 = new Employee("Bob");
        Employee emp3 = new Employee("Charlie");
        Employee emp4 = new Employee("David");

        // Creating departments
        Department dept1 = new Department("HR");
        Department dept2 = new Department("Engineering");

        // Adding employees to departments
        dept1.addEmployee(emp1);
        dept1.addEmployee(emp2);
        dept2.addEmployee(emp3);
        dept2.addEmployee(emp4);

        // Creating a company and adding departments
        Company company = new Company("TechCorp");
        company.addDepartment(dept1);
        company.addDepartment(dept2);

        // Showing company details
        System.out.println("\nCompany Details:");
        company.showCompanyDetails();

        // Deleting the company (will also delete all departments and employees)
        System.out.println("\nDeleting the company...");
        company.deleteCompany();
    }
}

