package AlgoritmoDijkstraCol;

import java.util.*;

public class Grafo {

    private Map<String, Map<String, Double>> adyacencia = new HashMap<>();

    public void agregarCiudad(String ciudad) {
        adyacencia.putIfAbsent(ciudad, new HashMap<>());
    }

    public void agregarArista(String origen, String destino, double distancia) {
        adyacencia.get(origen).put(destino, distancia);
        adyacencia.get(destino).put(origen, distancia); // no dirigido
    }

    public Map<String, Map<String, Double>> getAdyacencia() {
        return adyacencia;
    }
}
