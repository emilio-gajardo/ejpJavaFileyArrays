package clases;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class AdminArch {

    public static String ruta = "C:/Users/Public/Documents/";
    public static String fileNumDesordenados = "numDesordenados.txt";
    public static String fileNumOrdenados = "numOrdenados.txt";
    public static int longitud = 10;
    //public static int[] arregloNumDesor = new int[tamanio];
    //public static int[] arregloNumOrd = new int[tamanio];

    //public static List<Integer> arregloNumDesor = new ArrayList<>();
    //public static List<Integer> arregloNumOrd = new ArrayList<>();
    public static CopyOnWriteArrayList<Integer> arregloNumDesor = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<Integer> arregloNumOrd = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<Integer> arregloNumInputFile = new CopyOnWriteArrayList<>();

    // Crea un archivo con numeros aleatorios agregar numeros aleatorios y desordenados al arreglo
    public void crearNewArchivo() throws IOException {

        FileWriter archivo = new FileWriter(String.format("%s%s", ruta, fileNumDesordenados));
        System.out.println("-> Validando ruta: " + ruta);
        System.out.println("-> Validando nombre de archivo: " + fileNumDesordenados);

        try {
            System.out.println("-> Arreglo desordenado: ");
            for (int i = 0; i < longitud; i++) {
                arregloNumDesor.add((int) (Math.random() * longitud + 1));
                System.out.print(arregloNumDesor.get(i) + ",");
                archivo.write(arregloNumDesor.get(i) + ",");
            }
            archivo.close();
            System.out.println("\n-> Cerrando archivo");
        } catch (IOException e) {
            e.getMessage();
        } finally {
            if (archivo != null) {
                System.out.println("-> Proceso generado ok");
            } else {
                System.out.println("\n-> Error en el proceso");
            }
        }
    }

    // Lee y muestra el archivo que contiene los numeros aleatorios desordenados
    public void leerArchivo() throws IOException {
        lecturaDeArchivo(ruta, fileNumDesordenados);
    }

    // Metodo que permite leer el archivo con numeros desordenados && Crea un archivo con los numeros con orden ascendente
    public void ordenarArchivo() throws IOException {
        File archivoEntrada = new File(String.format("%s%s", ruta, fileNumDesordenados));
        FileWriter archivoSalida = new FileWriter(String.format("%s%s", ruta, fileNumOrdenados));

        BufferedReader buffer = new BufferedReader(new FileReader(archivoEntrada));
        String st;
        ArrayList<String> arregloIn;
        ArrayList<Integer> arregloOut;

        try {
            while ((st = buffer.readLine()) != null) {
                arregloIn = new ArrayList<>(Arrays.asList(st.split(",")));
                System.out.println("-> Validando arregloIn: " + arregloIn);

                arregloOut = new ArrayList<>(arregloIn.size());
                for (String str : arregloIn) {
                    if (isIntegerParse(str)) {
                        arregloOut.add(Integer.parseInt(str));
                    }
                }
                System.out.println("-> Validando arregloOut desordenado: " + arregloOut);

                Collections.sort(arregloOut);
                System.out.println("-> Validando arregloOut ordenado: " + arregloOut);

                for (int i = 0; i < longitud; i++) {
                    archivoSalida.write(arregloOut.get(i) + ",");
                }
                archivoSalida.close();
                System.out.println("-> Cerrando archivo de salida");
            }
            buffer.close();
            System.out.println("-> Cerrando buffer");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    // Metodo que permite leer un archivo y mostrarlo por consola 
    public void leerArchivoOrdenado() throws IOException {
        lecturaDeArchivo(ruta, fileNumOrdenados);
    }

    public void buscarNum(int numInt) throws FileNotFoundException {
        File archivoEntrada = new File(String.format("%s%s", ruta, fileNumDesordenados));
        BufferedReader buffer = new BufferedReader(new FileReader(archivoEntrada));
        String st;
        ArrayList<String> arregloIn = null;
        ArrayList<Integer> arregloInteger = null;
        try {
            while ((st = buffer.readLine()) != null) {
                arregloIn = new ArrayList<>(Arrays.asList(st.split(",")));
            }
            System.out.println("-> Cargando archivo en memoria");
            
            Collections.sort(arregloIn);
            System.out.println("-> Ordenando arreglo");

            arregloInteger = new ArrayList<>(arregloIn.size());
            for (String str : arregloIn) {
                if (isIntegerParse(str)) {
                    arregloInteger.add(Integer.parseInt(str));
                }
            }
            System.out.println("-> Convirtiendo arreglo a Integer");

            Collections.sort(arregloInteger);
            System.out.println("-> Ordenando arreglo");

            boolean existe = arregloInteger.contains(numInt);
            //int indice = arregloIn.indexOf(numInt);

            if (existe) {
                //if (indice != -1) {
                System.out.println(String.format("%s%s%s", "-> El elemento ", numInt, " Si existe"));
            } else {
                System.out.println(String.format("%s%s%s", "-> El elemento ", numInt, " No existe"));
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }

    // Metodo que permite validar si un String es numerico entero
    public boolean isIntegerParse(String str) throws NumberFormatException {
        try {
            if (str == null) {
                return false;
            } else {
                Integer.parseInt(str);
                return true;
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return false;
    }

    // Metodo que permite leer un archivo y mostrarlo por consola
    public void lecturaDeArchivo(String rutaX, String nombreArchivoX) throws IOException {

        String rutaL = rutaX;
        System.out.println("-> Validando ruta: " + rutaX);

        String nombreArchivoL = nombreArchivoX;
        System.out.println("-> Validando nombre de archivo: " + nombreArchivoL);

        System.out.println("\n-> Registros leidos del archivo: ");
        String contenido = "";
        FileReader entrada = new FileReader(String.format("%s%s", rutaL, nombreArchivoL));
        BufferedReader buffer = new BufferedReader(entrada);
        try {
            while ((contenido = buffer.readLine()) != null) {
                System.out.println(contenido);
            }
            buffer.close();
            System.out.println("-> Cerrando buffer");
        } catch (IOException ex) {
            System.out.println("-> Error: Archivo no encontrado");
            ex.getMessage();
        }
    }
}
