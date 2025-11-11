package Parcial3;

import java.util.Arrays;

public class AlgoritmoDijkstra {

    // Constante para representar "infinito" (cuando no hay conexión entre nodos)
    static final int INFINITO = Integer.MAX_VALUE;

    // Método principal que implementa el algoritmo de Dijkstra
    public static void dijkstra(int[][] grafo, int origen) {
        int n = grafo.length; // Número de nodos en el grafo
        int[] distancia = new int[n]; // Arreglo que guarda las distancias más cortas desde el origen
        boolean[] visitado = new boolean[n]; // Marca los nodos que ya se han procesado

        // Inicializamos todas las distancias en "infinito"
        Arrays.fill(distancia, INFINITO);

        // La distancia del nodo de origen a sí mismo siempre es 0
        distancia[origen] = 0;

        // Repetimos el proceso n-1 veces (una por cada nodo)
        for (int contador = 0; contador < n - 1; contador++) {
            // Buscar el nodo no visitado con la distancia mínima actual
            int u = distanciaMinima(distancia, visitado);

            // Marcamos el nodo como visitado (ya se procesó)
            visitado[u] = true;

            // Recorremos todos los nodos adyacentes a u
            for (int v = 0; v < n; v++) {
                // Si el nodo v no ha sido visitado y existe conexión entre u y v
                // y además encontramos una distancia más corta, la actualizamos
                if (!visitado[v] && grafo[u][v] != 0 &&
                        distancia[u] != INFINITO &&
                        distancia[u] + grafo[u][v] < distancia[v]) {

                    // Se actualiza la distancia del nodo v
                    distancia[v] = distancia[u] + grafo[u][v];
                }
            }
        }

        // Al finalizar, mostramos las distancias más cortas desde el origen
        imprimirSolucion(distancia);
    }

    // Método para encontrar el índice del nodo con la menor distancia
    // entre los que aún no han sido visitados
    private static int distanciaMinima(int[] distancia, boolean[] visitado) {
        int minimo = INFINITO;
        int indiceMinimo = -1;

        for (int v = 0; v < distancia.length; v++) {
            if (!visitado[v] && distancia[v] <= minimo) {
                minimo = distancia[v];
                indiceMinimo = v;
            }
        }
        return indiceMinimo;
    }

    // Método que imprime las distancias más cortas desde el nodo origen
    private static void imprimirSolucion(int[] distancia) {
        System.out.println("Distancias más cortas desde el nodo origen:");
        for (int i = 0; i < distancia.length; i++) {
            System.out.println("Hasta el nodo " + i + ": " + distancia[i]);
        }
    }

    // Método principal del programa
    public static void main(String[] args) {
        // Representación de un grafo mediante una matriz de adyacencia
        // 0 significa que no hay conexión directa entre los nodos
        int[][] grafo = {
                { 0, 2, 0, 4, 0 },
                { 2, 0, 5, 0, 0 },
                { 0, 5, 0, 8, 0 },
                { 4, 0, 8, 0, 3 },
                { 0, 0, 0, 3, 0 }
        };

        // Ejecutamos el algoritmo desde el nodo 0 (origen)
        dijkstra(grafo, 0);
    }
}