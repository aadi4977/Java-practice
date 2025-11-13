class Model implements Cloneable {
    String data = "Prototype";
    public Model clone() {
        try { return (Model) super.clone(); } 
        catch (Exception e) { return null; }
    }
}

public class PrototypeClone {
    public static void main(String[] args) {
        Model m1 = new Model();
        Model m2 = m1.clone();
        System.out.println(m2.data);
    }
}
