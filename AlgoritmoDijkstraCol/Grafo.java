package AlgoritmoDijkstraCol;

import java.util.*;

public class Grafo {

    // ======== ARISTA =========
    static class Arista {
        String destino;
        double peso;

        Arista(String destino, double peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // ======== MAPA (lista de adyacencia) =========
    Map<String, List<Arista>> grafo = new HashMap<>();

    void agregarCiudad(String ciudad) {
        grafo.putIfAbsent(ciudad, new ArrayList<>());
    }

    void agregarArista(String origen, String destino, double peso) {
        grafo.get(origen).add(new Arista(destino, peso));
    }
}