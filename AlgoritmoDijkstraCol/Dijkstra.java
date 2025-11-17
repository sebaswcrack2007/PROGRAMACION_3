package AlgoritmoDijkstraCol;

import java.util.*;

public class Dijkstra {

    private Grafo g;

    public Dijkstra(Grafo g) {
        this.g = g;
    }

    // =========================================================
    // DIJKSTRA: distancias más cortas desde una ciudad origen
    // =========================================================
    public Map<String, Double> dijkstra(String origen) {

        Map<String, Double> dist = new HashMap<>();
        Map<String, Boolean> visitado = new HashMap<>();

        for (String ciudad : g.grafo.keySet()) {
            dist.put(ciudad, Double.MAX_VALUE);
            visitado.put(ciudad, false);
        }

        dist.put(origen, 0.0);

        // Repetimos por número de ciudades
        for (int i = 0; i < g.grafo.size() - 1; i++) {

            String u = ciudadMinima(dist, visitado);
            visitado.put(u, true);

            for (Arista ar : g.grafo.get(u)) {

                if (!visitado.get(ar.destino) &&
                        dist.get(u) + ar.peso < dist.get(ar.destino)) {

                    dist.put(ar.destino, dist.get(u) + ar.peso);
                }
            }
        }

        return dist;
    }

    private String ciudadMinima(Map<String, Double> dist, Map<String, Boolean> vis) {
        double min = Double.MAX_VALUE;
        String ciudad = null;

        for (String c : dist.keySet()) {
            if (!vis.get(c) && dist.get(c) <= min) {
                min = dist.get(c);
                ciudad = c;
            }
        }

        return ciudad;
    }

    // =========================================================
    // Encontrar TODAS las rutas posibles (DFS)
    // =========================================================
    public void buscarRutas(String actual, String destino,
            List<String> camino,
            List<List<String>> rutas) {

        camino.add(actual);

        if (actual.equals(destino)) {
            rutas.add(new ArrayList<>(camino));
            camino.remove(camino.size() - 1);
            return;
        }

        for (Arista ar : g.grafo.get(actual)) {
            if (!camino.contains(ar.destino)) {
                buscarRutas(ar.destino, destino, camino, rutas);
            }
        }

        camino.remove(camino.size() - 1);
    }

    // =========================================================
    // Calcular distancia total de una ruta
    // =========================================================
    public double calcularDistancia(List<String> ruta) {

        double total = 0;

        for (int i = 0; i < ruta.size() - 1; i++) {
            String a = ruta.get(i);
            String b = ruta.get(i + 1);

            for (Arista ar : g.grafo.get(a)) {
                if (ar.destino.equals(b)) {
                    total += ar.peso;
                }
            }
        }
        return total;
    }

    // =========================================================
    // ORDENAMIENTO BURBUJA para rutas
    // =========================================================
    public void ordenarRutas(List<List<String>> rutas) {

        for (int i = 0; i < rutas.size() - 1; i++) {
            for (int j = 0; j < rutas.size() - 1 - i; j++) {

                double d1 = calcularDistancia(rutas.get(j));
                double d2 = calcularDistancia(rutas.get(j + 1));

                if (d1 > d2) {
                    List<String> temp = rutas.get(j);
                    rutas.set(j, rutas.get(j + 1));
                    rutas.set(j + 1, temp);
                }
            }
        }
    }
}