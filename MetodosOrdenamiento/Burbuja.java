package MetodosOrdenamiento;

public class Burbuja {
    public static void main(String[] args) {
        int[] vec = { 5, 3, 8, 4, 2 };

        System.out.println("Antes de ordenar:");
        for (int n : vec)
            System.out.print(n + " ");

        ordenamientoBurbuja(vec);

        System.out.println("\nDespués de ordenar:");
        for (int n : vec)
            System.out.print(n + " ");
    }

    public static void ordenamientoBurbuja(int[] vec) {
        int aux;
        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = 0; j < vec.length - 1 - i; j++) {
                if (vec[j] > vec[j + 1]) {
                    aux = vec[j];
                    vec[j] = vec[j + 1];
                    vec[j + 1] = aux;
                }
            }
        }
    }
}