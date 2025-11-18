package AlgoritmoDijkstraCol;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Grafo g = new Grafo();

        // Crear ciudades (sin Pereira)
        String[] ciudades = {
                "Cali", "Bogotá", "Medellín",
                "Barranquilla", "Bucaramanga", "Cartagena"
        };

        for (String c : ciudades)
            g.agregarCiudad(c);

        // Agregar aristas reales simplificadas
        g.agregarArista("Cali", "Bogotá", 656);
        g.agregarArista("Cali", "Medellín", 416);

        g.agregarArista("Bogotá", "Bucaramanga", 437.3);

        g.agregarArista("Medellín", "Barranquilla", 404.2);
        g.agregarArista("Medellín", "Cartagena", 706.7);

        g.agregarArista("Barranquilla", "Cartagena", 134.3);
        g.agregarArista("Bucaramanga", "Cartagena", 635.6);

        Dijkstra d = new Dijkstra(g);

        System.out.println("== DISTANCIAS DE DIJKSTRA DESDE CALI ==\n");
        Map<String, Double> dist = d.dijkstra("Cali");
        System.out.println(dist);

        // ===============================
        // ENCONTRAR TODAS LAS RUTAS
        // ===============================
        List<List<String>> rutas = new ArrayList<>();
        d.buscarRutas("Cali", "Cartagena", new ArrayList<>(), rutas);

        System.out.println("\n== TODAS LAS RUTAS ENCONTRADAS ==");
        for (List<String> r : rutas) {
            System.out.println(r + "  |  " + d.calcularDistancia(r) + " km");
        }

        // ===============================
        // ORDENAR POR BURBUJA
        // ===============================
        d.ordenarRutas(rutas);

        System.out.println("\n== RUTAS ORDENADAS POR DISTANCIA ==");
        for (List<String> r : rutas) {
            System.out.println(r + "  |  " + d.calcularDistancia(r) + " km");
        }

        System.out.println("\n== MEJOR RUTA ==");
        System.out.println(rutas.get(0) + " → " + d.calcularDistancia(rutas.get(0)) + " km");
    }
}