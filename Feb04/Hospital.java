package Feb04;

import java.util.ArrayList;
import java.util.List;

class Doctor {
    private String name;
    private String specialty;
    private List<Patient> patients;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Doctor " + name + " consulted with patient " + patient.getName() + " regarding " + specialty);
    }

    public void showConsultations() {
        System.out.println("Doctor " + name + " has consulted with the following patients:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
    }
}

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consultWithDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.consult(this);
    }

    public void showDoctors() {
        System.out.println("Patient " + name + " has consulted with the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName() + " (Specialty: " + doctor.getSpecialty() + ")");
        }
    }
}

public class Hospital {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("Dr. Smith", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Johnson", "Neurology");

        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        patient1.consultWithDoctor(doctor1);  // Alice consults Dr. Smith
        patient1.consultWithDoctor(doctor2);  // Alice consults Dr. Johnson
        patient2.consultWithDoctor(doctor1);  // Bob consults Dr. Smith

        // Display consultation details
        System.out.println();
        patient1.showDoctors();
        patient2.showDoctors();
        System.out.println();
        doctor1.showConsultations();
        doctor2.showConsultations();
    }
}
