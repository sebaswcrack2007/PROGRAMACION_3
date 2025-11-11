package MetodosOrdenamiento;

public class QuickShort {
    public static void main(String[] args) {
        int[] vec = { 10, 7, 8, 9, 1, 5 };

        System.out.println("Antes de ordenar:");
        for (int n : vec)
            System.out.print(n + " ");

        quickSort(vec, 0, vec.length - 1);

        System.out.println("\nDespués de ordenar:");
        for (int n : vec)
            System.out.print(n + " ");
    }

    public static void quickSort(int[] vec, int inicio, int fin) {
        if (inicio >= fin)
            return;
        int pivote = vec[inicio];
        int izq = inicio + 1;
        int der = fin;

        while (izq <= der) {
            while (izq <= fin && vec[izq] < pivote)
                izq++;
            while (der > inicio && vec[der] >= pivote)
                der--;
            if (izq < der) {
                int temp = vec[izq];
                vec[izq] = vec[der];
                vec[der] = temp;
            }
        }

        if (der > inicio) {
            int temp = vec[inicio];
            vec[inicio] = vec[der];
            vec[der] = temp;
        }

        quickSort(vec, inicio, der - 1);
        quickSort(vec, der + 1, fin);
    }
}