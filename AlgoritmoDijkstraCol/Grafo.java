package AlgoritmoDijkstraCol;

import java.util.*;

public class Grafo {

    Map<String, List<Arista>> grafo = new HashMap<>();

    public void agregarCiudad(String nombre) {
        grafo.put(nombre, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino, double peso) {
        grafo.get(origen).add(new Arista(destino, peso));
    }
}