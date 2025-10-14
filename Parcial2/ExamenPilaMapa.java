package Parcial2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 si esta vacia

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() {
            return tope == -1;
        }

        public boolean estaLlena() {
            return tope + 1 == datos.length;
        }

        public void apilar(int x) {
            if (estaLlena())
                throw new IllegalStateException(" Pila llena");
            tope++;
            datos[tope] = x;
        }

        public int desapilar() {
            if (estaVacia())
                throw new IllegalStateException(" Pila vacia ");
            int v = datos[tope];
            tope--;
            return v;
        }
    }

    // (50 pts ) Verifica si los parentesis estan balanceados .
    public static boolean esBalanceado(String s) {
        // Crea una pila del tamaño de la cadena
        PilaEnteros pila = new PilaEnteros(s.length());

        for (int i = 0; i < s.length(); i++) {
            // Toma cada carácter
            char simbolo = s.charAt(i);

            if (simbolo == '(') {
                // Abre paréntesis, significa que apila
                pila.apilar(1);
            } else if (simbolo == ')') {
                if (pila.estaVacia()) {
                    // Hay un cierre sin apertura
                    return false;
                }
                // Cierra un paréntesis, significa que desapila
                pila.desapilar();
            }
        }

        // Si al final de todo la pila queda vacía, significa que esta balanceado
        return pila.estaVacia();
    }

    // (50 pts ) Actualiza la calificacion si existe el id y esta en rango
    // 0..100.

    public static boolean actualizarCalificacion(Map<Integer, Integer> califPorId, int id, int nuevo) {
        // Verifica si el id existe y si tiene un rango válido
        if (califPorId.containsKey(id) && nuevo >= 0 && nuevo <= 100) {
            // Se actualiza la nota
            califPorId.put(id, nuevo);
            // Se realiza la actualizacion correctamente
            return true;
        }
        // Cuando no se cumplen las condiciones
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena con paréntesis:");
        String cadena = sc.nextLine();

        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        mapa.put(101, 70);

        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 101, 95));

        sc.close();
    }
}