interface Exportable {
    void export();
    default void exportToJSON() { System.out.println("Exporting JSON"); }
}

class CSVExport implements Exportable {
    public void export() { System.out.println("CSV Export"); }
}

class PDFExport implements Exportable {
    public void export() { System.out.println("PDF Export"); }
}

public class DataExport {
    public static void main(String[] args) {
        Exportable e = new CSVExport(); e.export(); e.exportToJSON();
        e = new PDFExport(); e.export(); e.exportToJSON();
    }
}

