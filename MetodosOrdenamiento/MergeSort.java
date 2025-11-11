package MetodosOrdenamiento;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] vec = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Antes de ordenar:");
        for (int n : vec)
            System.out.print(n + " ");

        ordenacionMergeSort(vec);

        System.out.println("\nDespués de ordenar:");
        for (int n : vec)
            System.out.print(n + " ");
    }

    public static void ordenacionMergeSort(int[] vec) {
        if (vec.length <= 1)
            return;

        int mitad = vec.length / 2;
        int[] izq = Arrays.copyOfRange(vec, 0, mitad);
        int[] der = Arrays.copyOfRange(vec, mitad, vec.length);

        ordenacionMergeSort(izq);
        ordenacionMergeSort(der);

        combinarVector(vec, izq, der);
    }

    public static void combinarVector(int[] v, int[] izq, int[] der) {
        int i = 0, j = 0;
        for (int k = 0; k < v.length; k++) {
            if (i >= izq.length) {
                v[k] = der[j++];
                continue;
            }
            if (j >= der.length) {
                v[k] = izq[i++];
                continue;
            }
            if (izq[i] < der[j]) {
                v[k] = izq[i++];
            } else {
                v[k] = der[j++];
            }
        }
    }
}