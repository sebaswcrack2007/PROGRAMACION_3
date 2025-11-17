package AlgoritmoDijkstraCol;

import java.util.*;

public class Dijkstra {

    Grafo mapa;

    public Dijkstra(Grafo mapa) {
        this.mapa = mapa;
    }

    // ======================================================
    // ALGORITMO DIJKSTRA — Calcula la distancia más corta
    // ======================================================
    public Map<String, Double> dijkstra(String inicio) {

        Map<String, Double> distancia = new HashMap<>();
        Set<String> visitado = new HashSet<>();

        // Inicializar distancias
        for (String ciudad : mapa.grafo.keySet()) {
            distancia.put(ciudad, Double.MAX_VALUE);
        }
        distancia.put(inicio, 0.0);

        PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingDouble(distancia::get));

        cola.add(inicio);

        while (!cola.isEmpty()) {

            String actual = cola.poll();
            if (visitado.contains(actual))
                continue;
            visitado.add(actual);

            for (Grafo.Arista ar : mapa.grafo.get(actual)) {

                if (distancia.get(actual) + ar.peso < distancia.get(ar.destino)) {

                    distancia.put(ar.destino, distancia.get(actual) + ar.peso);
                    cola.add(ar.destino);
                }
            }
        }
        return distancia;
    }

    // ======================================================
    // DFS → Todas las rutas posibles
    // ======================================================
    public void buscarRutas(String actual, String destino,
            List<String> camino, List<List<String>> rutas) {

        camino.add(actual);

        if (actual.equals(destino)) {
            rutas.add(new ArrayList<>(camino));
            camino.remove(camino.size() - 1);
            return;
        }

        for (Grafo.Arista ar : mapa.grafo.get(actual)) {
            if (!camino.contains(ar.destino)) {
                buscarRutas(ar.destino, destino, camino, rutas);
            }
        }

        camino.remove(camino.size() - 1);
    }

    // ======================================================
    // Calcular distancia de UNA ruta
    // ======================================================
    public double calcularDistancia(List<String> ruta) {
        double total = 0;

        for (int i = 0; i < ruta.size() - 1; i++) {
            String a = ruta.get(i);
            String b = ruta.get(i + 1);

            for (Grafo.Arista ar : mapa.grafo.get(a)) {
                if (ar.destino.equals(b)) {
                    total += ar.peso;
                }
            }
        }

        return total;
    }

    // ======================================================
    // Ordenamiento burbuja de rutas por distancia
    // ======================================================
    public void ordenarRutas(List<List<String>> rutas) {

        for (int i = 0; i < rutas.size() - 1; i++) {
            for (int j = 0; j < rutas.size() - 1 - i; j++) {

                if (calcularDistancia(rutas.get(j)) > calcularDistancia(rutas.get(j + 1))) {

                    List<String> tmp = rutas.get(j);
                    rutas.set(j, rutas.get(j + 1));
                    rutas.set(j + 1, tmp);
                }
            }
        }
    }
}