package Clase9;

import java.util.*;
import java.io.*;

public class ArrayListExample {
    public static void main(String args[]) throws IOException {
        ArrayList<String> obj = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        int c, ch;
        int i, j;
        String str, str1;
        do {
            System.out.println("MANIPULACION DE CADENAS");
            System.out.println("************************");
            System.out.println("1. Adicionar al final");
            System.out.println("2. Insertar en una posicion particular");
            System.out.println("3. Buscar");
            System.out.println("4. Listar las cadenas que comienzan con la letra");
            System.out.println("5. Tamaño");
            System.out.println("6. Remover");
            System.out.println("7. Ordenar");
            System.out.println("8. Mostrar");
            System.out.println("Ingrese la opcion");
            c = Integer.parseInt(in.next());
            switch (c) {
                case 1: {
                    System.out.println("Digite la cadena ");
                    str = in.next();
                    obj.add(str);
                    break;
                }
                case 2: {
                    System.out.println("Digite la cadena que desea insertar");
                    String nuevaCadena = in.next();
                    System.out.println("Digite la posicion");
                    int posicion = Integer.parseInt(in.next());
                    if (posicion < 0 && posicion > obj.size()) {
                    break;
                }
                case 3: {
                    //codigo
                    break;
                }
                case 4: {
                    //codigo
                    break;
                }
                case 5: {
                    System.out.println("Tama~no de la lista " + obj.size());
                    break;
                }
                case 6: {
                    //codigo
                    break;
                }
                case 7: {
                    //codigo
                    break;
                }
                case 8: {
                    //codigo
                    break;
                }
            }
            System.out.println("Por favor ingrese, 0 para salir, 1 para continuar");
            ch = Integer.parseInt(in.next());
        }
        while (ch == 1);
    }
}
}