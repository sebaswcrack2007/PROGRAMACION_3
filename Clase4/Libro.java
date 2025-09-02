package Clase4;

public class Libro {
    private String titulo;
    private String autor;
    private double precio;

    public Libro(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;

    }

    public static double calcularPrecioTotal(Libro[] libros) {
        double total = 0.0;
        for (int i = 0; i < libros.length; i++) {
            total += libros[i].getPrecio();
        }
        return total;
    }

    // Método para filtrar libros por precio
    public static Libro[] filtrarLibrosPorPrecio(Libro[] libros, double precioMinimo) {
        int contador = 0;

        // Primero contamos cuántos libros cumplen con el criterio
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getPrecio() > precioMinimo) {
                contador++;
            }
        }

        // Creamos un nuevo arreglo con el tamaño adecuado
        Libro[] librosFiltrados = new Libro[contador];
        int indice = 0;

        // Llenamos el nuevo arreglo con los libros que cumplen el criterio
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getPrecio() > precioMinimo) {
                librosFiltrados[indice] = libros[i];
                indice++;
            }
        }

        return librosFiltrados;
    }

    // Método para ordenar libros por precio (usando ordenamiento burbuja)
    public static void ordenarLibrosPorPrecio(Libro[] libros) {
        int n = libros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (libros[j].getPrecio() > libros[j + 1].getPrecio()) {
                    // Intercambiar los libros
                    Libro temp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temp;
                }
            }
        }
    }
}