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
        PilaEnteros pila = new PilaEnteros(s.length()); // Crea una pila del tamaño de la cadena

        for (int i = 0; i < s.length(); i++) {
            char simbolo = s.charAt(i); // Toma cada carácter

            if (simbolo == '(') {
                pila.apilar(1); // Abre paréntesis, significa que apila
            } else if (simbolo == ')') {
                if (pila.estaVacia()) {
                    return false; // Hay un cierre sin apertura
                }
                pila.desapilar(); // Cierra un paréntesis, significa que desapila
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
            califPorId.put(id, nuevo); // Actualiza la nota
            return true; // Actualización exitosa
        }
        return false; // No cumple condiciones
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println(" Balanceado : " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        mapa.put(101, 70);
        System.out.println(" Actualizado : " + actualizarCalificacion(mapa, 101, 95));

        sc.close();
    }
}
