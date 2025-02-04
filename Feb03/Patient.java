package Feb03;
import java.util.Scanner;
public class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("\nHospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of patients to admit: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Patient[] patients = new Patient[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Patient " + (i + 1) + ":");
            System.out.print("Enter Patient ID: ");
            int patientID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Ailment: ");
            String ailment = scanner.nextLine();
            patients[i] = new Patient(patientID, name, age, ailment);
        }
        getTotalPatients();
        System.out.println("\n--- Patient Records ---");
        for (Patient patient : patients) {
            patient.displayPatientDetails();
        }
        scanner.close();
    }
}
