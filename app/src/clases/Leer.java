package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {

    public static String dato() {
        String sdato = null;
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            sdato = entrada.readLine();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return sdato;
    }

    public static int datoInt() {
        try {
            return (Integer.parseInt(dato()));
        } catch (NumberFormatException error) {
            return Integer.MIN_VALUE;
        }
    }

    public static float datoFloat() {
        try {
            Float f = new Float(dato());
            return (f.floatValue());
        } catch (NumberFormatException e) {
            return (Float.NaN);
        }
    }

    public static double datoDouble() {
        try {
            Double f = new Double(dato());
            return (f.doubleValue());
        } catch (NumberFormatException error) {
            return (Double.NaN);
        }
    }

    public static char datoChar() {
        try {
            char resp = dato().charAt(0);
            return resp;
        } catch (Exception error) {
            return ('z');
        }
    }

    public static boolean datoBoolean() {
        try {
            return (Boolean.parseBoolean(dato()));

        } catch (NumberFormatException error) {
            return (false);
        }
    }
}
