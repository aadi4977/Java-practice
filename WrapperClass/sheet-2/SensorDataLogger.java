package WrapperClass.sheet-2;

import java.util.ArrayList;

public class SensorDataLogger {

    public static void logData(double value, ArrayList<Double> list) {
        list.add(value);
    }

    public static void logData(Double value, ArrayList<Double> list) {
        list.add(value);
    }

    public static void main(String[] args) {
        ArrayList<Double> readings = new ArrayList<>();

        logData(25.6, readings);
        logData(30.2, readings);
        logData(Double.valueOf(28.9), readings);
        logData(null, readings);

        for (Double r : readings) {
            if (r == null) {
                System.out.println("Null reading stored");
            } else {
                double temp = r;
                System.out.println("Reading: " + temp);
            }
        }
    }
}

