package AlgoritmoDijkstraCol;

import java.util.*;

public class Dijkstra {

    private Grafo grafo;

    public Dijkstra(Grafo g) {
        this.grafo = g;
    }

    public Map<String, Double> dijkstra(String origen) {
        Map<String, Map<String, Double>> ady = grafo.getAdyacencia();

        Map<String, Double> dist = new HashMap<>();
        Map<String, Boolean> visitado = new HashMap<>();

        for (String ciudad : ady.keySet()) {
            dist.put(ciudad, Double.MAX_VALUE);
            visitado.put(ciudad, false);
        }

        dist.put(origen, 0.0);

        for (int i = 0; i < ady.size(); i++) {

            String actual = null;
            double min = Double.MAX_VALUE;

            // Seleccionar nodo no visitado con menor distancia
            for (String c : dist.keySet()) {
                if (!visitado.get(c) && dist.get(c) < min) {
                    min = dist.get(c);
                    actual = c;
                }
            }

            visitado.put(actual, true);

            // Relajar distancias
            for (String vecino : ady.get(actual).keySet()) {
                double nuevaDist = dist.get(actual) + ady.get(actual).get(vecino);

                if (nuevaDist < dist.get(vecino)) {
                    dist.put(vecino, nuevaDist);
                }
            }
        }

        return dist;
    }

    // =============================
    // BUSCAR TODAS LAS RUTAS
    // =============================
    public void buscarRutas(String actual, String destino, List<String> camino, List<List<String>> rutas) {
        camino.add(actual);

        if (actual.equals(destino)) {
            rutas.add(new ArrayList<>(camino));
        } else {
            for (String vecino : grafo.getAdyacencia().get(actual).keySet()) {
                if (!camino.contains(vecino)) {
                    buscarRutas(vecino, destino, camino, rutas);
                }
            }
        }

        camino.remove(camino.size() - 1);
    }

    // =============================
    // CALCULAR DISTANCIA DE UNA RUTA
    // =============================
    public double calcularDistancia(List<String> ruta) {
        double total = 0;

        for (int i = 0; i < ruta.size() - 1; i++) {
            String a = ruta.get(i);
            String b = ruta.get(i + 1);
            total += grafo.getAdyacencia().get(a).get(b);
        }

        return total;
    }

    // =============================
    // ORDENAR RUTAS POR BURBUJA
    // =============================
    public void ordenarRutas(List<List<String>> rutas) {
        int n = rutas.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                double d1 = calcularDistancia(rutas.get(j));
                double d2 = calcularDistancia(rutas.get(j + 1));

                if (d1 > d2) {
                    List<String> tmp = rutas.get(j);
                    rutas.set(j, rutas.get(j + 1));
                    rutas.set(j + 1, tmp);
                }
            }
        }
    }
}