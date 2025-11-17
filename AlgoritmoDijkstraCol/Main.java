package AlgoritmoDijkstraCol;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Grafo g = new Grafo();

        // Agregar ciudades principales
        String[] ciudades = {
                "Cali", "Bogotá", "Medellín",
                "Pereira", "Barranquilla",
                "Bucaramanga", "Cartagena"
        };

        for (String c : ciudades)
            g.agregarCiudad(c);

        // Agregar aristas (solo dirigidas)
        g.agregarArista("Cali", "Bogotá", 656);
        g.agregarArista("Cali", "Medellín", 499);
        g.agregarArista("Cali", "Pereira", 278.9);

        g.agregarArista("Bogotá", "Bucaramanga", 437.3);

        g.agregarArista("Pereira", "Medellín", 196.1);
        g.agregarArista("Medellín", "Barranquilla", 404.2);
        g.agregarArista("Medellín", "Cartagena", 706.7);

        g.agregarArista("Barranquilla", "Cartagena", 134.3);
        g.agregarArista("Bucaramanga", "Cartagena", 635.6);

        // Crear objeto Dijkstra
        Dijkstra d = new Dijkstra(g);

        // Distancia más corta Cali → Cartagena
        Map<String, Double> dist = d.dijkstra("Cali");
        System.out.println("Distancia más corta Cali → Cartagena: "
                + dist.get("Cartagena") + " km\n");

        // Encontrar todas las rutas posibles
        List<List<String>> rutas = new ArrayList<>();
        d.buscarRutas("Cali", "Cartagena", new ArrayList<>(), rutas);

        System.out.println("Rutas encontradas:");
        for (List<String> r : rutas) {
            System.out.println(r + " (" + d.calcularDistancia(r) + " km)");
        }

        // Ordenarlas por distancia
        d.ordenarRutas(rutas);

        System.out.println("\nRutas ordenadas por distancia:");
        for (List<String> r : rutas) {
            System.out.println(r + " (" + d.calcularDistancia(r) + " km)");
        }

        System.out.println("\nRuta más corta según búsqueda completa:");
        System.out.println(rutas.get(0) + " → " + d.calcularDistancia(rutas.get(0)) + " km");
    }
}