package Clase9;

import java.util.*;

public class ArrayListExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n=== MANIPULACIÓN DE CADENAS ===");
            System.out.println("1. Agregar cadena al final");
            System.out.println("2. Insertar cadena en una posición");
            System.out.println("3. Buscar una cadena");
            System.out.println("4. Listar cadenas que comienzan con una letra");
            System.out.println("5. Mostrar tamaño de la lista");
            System.out.println("6. Eliminar una cadena");
            System.out.println("7. Ordenar la lista");
            System.out.println("8. Mostrar todas las cadenas");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            opcion = in.nextInt();
            in.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la cadena: ");
                    String cadena = in.nextLine();
                    lista.add(cadena);
                    System.out.println("Cadena agregada correctamente.");
                }

                case 2 -> {
                    System.out.print("Ingrese la cadena a insertar: ");
                    String cadena = in.nextLine();
                    System.out.print("Ingrese la posición (0 a " + lista.size() + "): ");
                    int posicion = in.nextInt();

                    if (posicion >= 0 && posicion <= lista.size()) {
                        lista.add(posicion, cadena);
                        System.out.println("Cadena insertada correctamente.");
                    } else {
                        System.out.println("Posición inválida.");
                    }
                }

                case 3 -> {
                    System.out.print("Ingrese la cadena a buscar: ");
                    String buscar = in.nextLine();
                    if (lista.contains(buscar)) {
                        System.out.println("La cadena \"" + buscar + "\" se encuentra en la lista.");
                    } else {
                        System.out.println("La cadena no fue encontrada.");
                    }
                }

                case 4 -> {
                    System.out.print("Ingrese la letra inicial: ");
                    char letra = in.next().charAt(0);
                    System.out.println("Cadenas que comienzan con '" + letra + "':");
                    boolean encontrada = false;

                    for (String s : lista) {
                        if (!s.isEmpty() && Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(letra)) {
                            System.out.println("- " + s);
                            encontrada = true;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("Ninguna cadena comienza con esa letra.");
                    }
                }

                case 5 -> System.out.println("La lista tiene " + lista.size() + " elementos.");

                case 6 -> {
                    System.out.print("Ingrese la cadena a eliminar: ");
                    String eliminar = in.nextLine();
                    if (lista.remove(eliminar)) {
                        System.out.println("Cadena eliminada correctamente.");
                    } else {
                        System.out.println("La cadena no se encontró.");
                    }
                }

                case 7 -> {
                    Collections.sort(lista);
                    System.out.println("Lista ordenada alfabéticamente.");
                }

                case 8 -> {
                    if (lista.isEmpty()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        System.out.println("Contenido actual de la lista:");
                        for (String s : lista) {
                            System.out.println("- " + s);
                        }
                    }
                }

                case 0 -> System.out.println("Programa finalizado.");

                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        in.close();
    }
}