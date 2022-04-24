package main;

import clases.Leer;
import clases.AdminArch;
import java.io.*;

public class Main {

    Leer leer = new Leer();

    public static void main(String[] args) throws IOException {

        AdminArch adminArch = new AdminArch();// clase que contiene la logica de los metodos

        int op = 0;// opcion ingresada por usuario

        do {
            System.out.println("\n\n-- Java Challenge --");
            System.out.println("====================");
            System.out.println("1 - Genera nuevo archivo");
            System.out.println("2 - Lee archivo generado");
            System.out.println("3 - Ordenar archivo");
            System.out.println("4 - Lee archivo ordenado");
            System.out.println("5 - Buscar número en archivo");
            System.out.println("6 - Salir");
            System.out.print("\nSeleccione una opción: ");

            op = Leer.datoInt();

            switch (op) {
                case 1:
                    System.out.println("-> Creando nuevo archivo...");
                    adminArch.crearNewArchivo();
                    break;
                case 2:
                    System.out.println("-> Mostrando archivo...");
                    adminArch.leerArchivo();
                    break;
                case 3:
                    System.out.println("-> Creando archivo ordenado...");
                    adminArch.ordenarArchivo();
                    break;
                case 4:
                    System.out.println("-> Mostrando archivo ordenado...");
                    adminArch.leerArchivoOrdenado();
                    break;
                case 5:
                    System.out.print("-> Ingrese el número entero a buscar: ");
                    int numIn = Leer.datoInt();
                    System.out.println("-> Buscando elemento...");
                    adminArch.buscarNum(numIn);
                    break;
                case 6:
                    System.out.println("-> Saliendo...");
                    break;
                default:
                    System.out.println("-> Opciones validas: 1/2/3/4/5");
            }
        } while (op != 6);
        System.exit(0);
    }

}
