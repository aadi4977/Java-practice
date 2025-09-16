package EncapsulAbsJAVA;

import java.util.*;

// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Abstract Method
    public abstract double calculateBill();

    // Concrete Method
    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis);
    }

    // Encapsulation - medical history access
    protected void addToHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }
}

// InPatient
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRoomCharge;
    private double treatmentCost;

    public InPatient(String patientId, String name, int age, String diagnosis,
                     int daysAdmitted, double dailyRoomCharge, double treatmentCost) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRoomCharge = dailyRoomCharge;
        this.treatmentCost = treatmentCost;
    }

    @Override
    public double calculateBill() {
        return (daysAdmitted * dailyRoomCharge) + treatmentCost;
    }

    @Override
    public void addRecord(String record) {
        addToHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("InPatient Medical Records: " + getMedicalHistory());
    }
}

// OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private double testFee;

    public OutPatient(String patientId, String name, int age, String diagnosis,
                      double consultationFee, double testFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
        this.testFee = testFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee + testFee;
    }

    @Override
    public void addRecord(String record) {
        addToHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("OutPatient Medical Records: " + getMedicalHistory());
    }
}

// Main Class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient("P001", "Rahul Sharma", 45, "Pneumonia", 5, 2000, 15000);
        OutPatient outPatient = new OutPatient("P002", "Neha Gupta", 30, "Flu", 500, 1200);

        inPatient.addRecord("Admitted on 10th Sept, given antibiotics.");
        inPatient.addRecord("Recovered well, discharged on 15th Sept.");

        outPatient.addRecord("Visited on 12th Sept, prescribed medication.");
        
        patients.add(inPatient);
        patients.add(outPatient);

        System.out.println("===== Patient Billing Details =====");
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Total Bill: ₹" + p.calculateBill());
            if (p instanceof MedicalRecord) {
                ((MedicalRecord)p).viewRecords();
            }
            System.out.println("-----");
        }
    }
}
