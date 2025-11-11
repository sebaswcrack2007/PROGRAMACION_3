package MetodosOrdenamiento;

public class Insercion {
    public static void main(String[] args) {
        int[] nums = { 5, 2, 4, 6, 1, 3 };

        System.out.println("Antes de ordenar:");
        for (int n : nums)
            System.out.print(n + " ");

        ordenamientoInsercion(nums);

        System.out.println("\nDespués de ordenar:");
        for (int n : nums)
            System.out.print(n + " ");
    }

    public static void ordenamientoInsercion(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int clave = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > clave) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = clave;
        }
    }
}