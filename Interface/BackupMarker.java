interface Backup {}

class StudentData implements Backup {
    String name = "Aman";
}

public class BackupMarker {
    public static void main(String[] args) {
        StudentData s = new StudentData();
        if (s instanceof Backup) System.out.println("Eligible for backup");
    }
}
