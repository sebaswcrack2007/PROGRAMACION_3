package Clase4;

public class EjecutarLibro {
    // Ejemplo de arreglo de Libro con 5 elementos
    public static void main(String[] args) {
        Libro[] libros = new Libro[5];

        libros[0] = new Libro("Cien años de soledad", "Gabriel García Márquez", 25990);
        libros[1] = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 19500);
        libros[2] = new Libro("El Principito", "Antoine de Saint-Exupéry", 15750);
        libros[3] = new Libro("Rayuela", "Julio Cortázar", 22300);
        libros[4] = new Libro("Ficciones", "Jorge Luis Borges", 18400);

        System.out.println("=== TODOS LOS LIBROS ===");
        for (int i = 0; i < libros.length; i++) {
            System.out.println(libros[i].getTitulo() + " - " + libros[i].getAutor() + " - $" + libros[i].getPrecio());
        }

        // Calcular y mostrar precio total
        double precioTotal = Libro.calcularPrecioTotal(libros);
        System.out.println("\nPrecio total de todos los libros: $" + precioTotal);

        // Filtrar libros con precio mayor a 18000
        double precioMinimo = 18000;
        Libro[] librosFiltrados = Libro.filtrarLibrosPorPrecio(libros, precioMinimo);

        // Mostrar libros filtrados
        System.out.println("\n=== LIBROS CON PRECIO MAYOR A $" + precioMinimo + " ===");
        for (int i = 0; i < librosFiltrados.length; i++) {
            System.out.println(librosFiltrados[i].getTitulo() + " - " +
                    librosFiltrados[i].getAutor() + " - $" +
                    librosFiltrados[i].getPrecio());
        }

        // Ordenar libros por precio
        Libro.ordenarLibrosPorPrecio(libros);

        // Mostrar libros ordenados por precio
        System.out.println("\n=== LIBROS ORDENADOS POR PRECIO (MENOR A MAYOR) ===");
        for (int i = 0; i < libros.length; i++) {
            System.out.println(libros[i].getTitulo() + " - " +
                    libros[i].getAutor() + " - $" +
                    libros[i].getPrecio());
        }
    }
}