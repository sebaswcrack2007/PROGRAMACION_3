package MetodosOrdenamiento;

public class Seleccion {
    public static void main(String[] args) {
        int[] vec = { 29, 10, 14, 37, 13 };

        System.out.println("Antes de ordenar:");
        for (int n : vec)
            System.out.print(n + " ");

        ordenamientoSeleccion(vec);

        System.out.println("\nDespués de ordenar:");
        for (int n : vec)
            System.out.print(n + " ");
    }

    public static void ordenamientoSeleccion(int[] vec) {
        for (int i = 0; i < vec.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < vec.length; j++) {
                if (vec[j] < vec[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = vec[indiceMinimo];
            vec[indiceMinimo] = vec[i];
            vec[i] = temp;
        }
    }
}