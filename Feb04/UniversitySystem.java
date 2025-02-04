package Feb04;

import java.util.ArrayList;
import java.util.List;

class Department {
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

class Faculty {
    private String name;
    private Department department;

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void assignToDepartment(Department department) {
        this.department = department;
    }

    public void showDetails() {
        if (department != null) {
            System.out.println("Faculty: " + name + ", Department: " + department.getDepartmentName());
        } else {
            System.out.println("Faculty: " + name + " is not assigned to any department.");
        }
    }
}

class University {
    private String universityName;
    private List<Department> departments;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public void showUniversityDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Departments:");
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
        } else {
            for (Department department : departments) {
                System.out.println("- " + department.getDepartmentName());
            }
        }
    }

    public void deleteUniversity() {
        departments.clear();
        System.out.println("All departments of " + universityName + " have been deleted.");
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("Tech University");
        Department department1 = new Department("Computer Science");
        Department department2 = new Department("Electrical Engineering");
        university.addDepartment(department1);
        university.addDepartment(department2);
        Faculty faculty1 = new Faculty("Dr. Smith", department1);
        Faculty faculty2 = new Faculty("Dr. Johnson", department2);
        Faculty faculty3 = new Faculty("Dr. Brown"); 
        faculty1.showDetails();
        faculty2.showDetails();
        faculty3.showDetails();
        university.showUniversityDetails();
        university.deleteUniversity();
        university.showUniversityDetails();  
    }
}
