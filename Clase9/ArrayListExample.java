package Clase9;

import java.util.*;
import java.io.*;

public class ArrayListExample {
    public static void main(String args[]) throws IOException {
        ArrayList<String> obj = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int c, ch;
        String str;

        do {
            System.out.println("\nMANIPULACION DE CADENAS");
            System.out.println("************************");
            System.out.println("1. Adicionar al final");
            System.out.println("2. Insertar en una posicion particular");
            System.out.println("3. Buscar");
            System.out.println("4. Listar las cadenas que comienzan con una letra");
            System.out.println("5. Tamaño");
            System.out.println("6. Remover");
            System.out.println("7. Ordenar");
            System.out.println("8. Mostrar");
            System.out.println("Ingrese la opcion:");
            c = Integer.parseInt(in.next());

            switch (c) {
                case 1: {
                    System.out.println("Digite la cadena:");
                    str = in.next();
                    obj.add(str);
                    break;
                }

                case 2: {
                    System.out.println("Digite la cadena que desea insertar:");
                    String nuevaCadena = in.next();
                    System.out.println("Digite la posicion:");
                    int posicion = Integer.parseInt(in.next());
                    if (posicion >= 0 && posicion <= obj.size()) {
                        obj.add(posicion, nuevaCadena);
                        System.out.println("Cadena insertada correctamente.");
                    } else {
                        System.out.println("Posicion invalida.");
                    }
                    break;
                }

                case 3: {
                    System.out.println("Digite la cadena a buscar:");
                    String buscar = in.next();
                    if (obj.contains(buscar)) {
                        System.out.println("La cadena '" + buscar + "' se encuentra en la lista.");
                    } else {
                        System.out.println("La cadena no fue encontrada.");
                    }
                    break;
                }

                case 4: {
                    System.out.println("Digite la letra inicial:");
                    char letra = in.next().charAt(0);
                    System.out.println("Cadenas que comienzan con '" + letra + "':");
                    for (String s : obj) {
                        if (s.charAt(0) == letra) {
                            System.out.println(s);
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.println("Tamaño de la lista: " + obj.size());
                    break;
                }

                case 6: {
                    System.out.println("Digite la cadena a remover:");
                    String eliminar = in.next();
                    if (obj.remove(eliminar)) {
                        System.out.println("Cadena eliminada correctamente.");
                    } else {
                        System.out.println("No se encontró la cadena.");
                    }
                    break;
                }

                case 7: {
                    Collections.sort(obj);
                    System.out.println("Lista ordenada correctamente.");
                    break;
                }

                case 8: {
                    System.out.println("Contenido de la lista:");
                    for (String s : obj) {
                        System.out.println(s);
                    }
                    break;
                }

                default: {
                    System.out.println("Opción inválida.");
                    break;
                }
            }

            System.out.println("\nIngrese 0 para salir, 1 para continuar:");
            ch = Integer.parseInt(in.next());
        } while (ch == 1);

        System.out.println("Programa finalizado.");
        in.close();
    }
}