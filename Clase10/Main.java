public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.generarArbolAleatorio(10);

        System.out.println("Recorrido en preorden:");
        arbol.preOrden();

        System.out.println("Recorrido en inorden:");
        arbol.inOrden();

        System.out.println("Recorrido en postorden:");
        arbol.postOrden();

        System.out.println("\nAltura del árbol: " + arbol.getAltura());
        System.out.println("Ancho del árbol: " + arbol.getAncho());

        if (arbol.estaBalanceado())
            System.out.println("El árbol está balanceado");
        else
            System.out.println("El árbol no está balanceado");
    }
}