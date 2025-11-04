import java.util.Random;

class ArbolBinario {
    private Nodo raiz;
    private Random random = new Random();

    public void generarArbolAleatorio(int n) {
        for (int i = 0; i < n; i++) {
            int valor = random.nextInt(100);
            raiz = insertar(raiz, valor);
        }
    }

    private Nodo insertar(Nodo actual, int valor) {
        if (actual == null)
            return new Nodo(valor);
        if (valor < actual.valor)
            actual.izquierdo = insertar(actual.izquierdo, valor);
        else
            actual.derecho = insertar(actual.derecho, valor);
        return actual;
    }

    public void preOrden() {
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(Nodo n) {
        if (n != null) {
            System.out.print(n.valor + " ");
            preOrden(n.izquierdo);
            preOrden(n.derecho);
        }
    }

    public void inOrden() {
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(Nodo n) {
        if (n != null) {
            inOrden(n.izquierdo);
            System.out.print(n.valor + " ");
            inOrden(n.derecho);
        }
    }

    public void postOrden() {
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(Nodo n) {
        if (n != null) {
            postOrden(n.izquierdo);
            postOrden(n.derecho);
            System.out.print(n.valor + " ");
        }
    }

    private int altura(Nodo n) {
        if (n == null)
            return 0;
        return 1 + Math.max(altura(n.izquierdo), altura(n.derecho));
    }

    private int contarNodosEnNivel(Nodo n, int nivel) {
        if (n == null)
            return 0;
        if (nivel == 1)
            return 1;
        return contarNodosEnNivel(n.izquierdo, nivel - 1) + contarNodosEnNivel(n.derecho, nivel - 1);
    }

    private int ancho(Nodo n) {
        int h = altura(n);
        int maxAncho = 0;
        for (int i = 1; i <= h; i++) {
            int anchoNivel = contarNodosEnNivel(n, i);
            if (anchoNivel > maxAncho)
                maxAncho = anchoNivel;
        }
        return maxAncho;
    }

    public boolean estaBalanceado() {
        return estaBalanceado(raiz);
    }

    private boolean estaBalanceado(Nodo n) {
        if (n == null)
            return true;
        int altIzq = altura(n.izquierdo);
        int altDer = altura(n.derecho);
        if (Math.abs(altIzq - altDer) > 1)
            return false;
        return estaBalanceado(n.izquierdo) && estaBalanceado(n.derecho);
    }

    public int getAltura() {
        return altura(raiz);
    }

    public int getAncho() {
        return ancho(raiz);
    }
}