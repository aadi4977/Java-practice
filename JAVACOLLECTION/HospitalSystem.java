package JAVACOLLECTION;

import java.util.*;

class Patient {
    int id;
    String name;

    Patient(int id, String name) {
        this.id = id; this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Patient) && this.id == ((Patient)o).id;
    }

    @Override
    public int hashCode() { return id; }

    @Override
    public String toString() { return id + " - " + name; }
}

public class HospitalSystem {

    Set<Patient> admitted = new HashSet<>();        // admitted patients
    Queue<Patient> waiting = new LinkedList<>();    // waiting for treatment
    Stack<Patient> discharged = new Stack<>();      // recently discharged
    List<Patient> history = new ArrayList<>();      // all-time history

    // 1. Admit + queue for treatment
    void admitPatient(Patient p) {
        if (admitted.add(p)) {
            waiting.add(p);
            history.add(p);
            System.out.println("Admitted: " + p);
        } else {
            System.out.println("Already admitted: " + p);
        }
    }

    // 2. Treat in order of arrival
    void treatNext() {
        if (waiting.isEmpty()) {
            System.out.println("No patients waiting.");
            return;
        }
        Patient p = waiting.poll();
        System.out.println("Treating: " + p);
    }

    // 3. Discharge and push to stack
    void discharge(Patient p) {
        if (admitted.remove(p)) {
            discharged.push(p);
            System.out.println("Discharged: " + p);
        }
    }

    // 4. Re-admit most recently discharged
    void readmitLast() {
        if (discharged.isEmpty()) {
            System.out.println("No recently discharged patients.");
            return;
        }
        Patient p = discharged.pop();
        admitPatient(p);
        System.out.println("Re-admitted: " + p);
    }

    // ---- Demo ----
    public static void main(String[] args) {
        HospitalSystem hs = new HospitalSystem();

        Patient p1 = new Patient(1, "Aadi");
        Patient p2 = new Patient(2, "Riya");

        hs.admitPatient(p1);
        hs.admitPatient(p2);
        hs.treatNext();
        hs.treatNext();

        hs.discharge(p1);
        hs.readmitLast();
    }
}

