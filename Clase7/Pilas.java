package Clase7;

import java.util.Stack;

public class Pilas {
    public static void main(String[] args) {
        // Creacion de una pila de numeros enteros
        Stack<Integer> pila = new Stack<>();

        // Verificar si la pila esta vacia

        System.out.println(pila.empty()); // true

        // Insertar elementos en la pila
        pila.push(8);
        pila.push(4);
        pila.push(9);
        pila.push(10);
        pila.push(6);

        // Imprimir la pila

        System.out.println(pila);

        // Mostrar el elemento que esta en el tope de la pila sin removerlo
        System.out.println("Tope de la pila: " + pila.peek());

        // Remover el elemento que se encuentra en el tope de la pila
        System.out.println("Elemento removido del tope de la pila: " + pila.pop());

        // Imprimir la pila

        System.out.println(pila);

        // Buscar y mostrar la posición del elemento dentro de la pila

        System.out.println(pila.search(10));
        System.out.println(pila.search(9));
        System.out.println(pila.search(4));
        System.out.println(pila.search(8));
        System.out.println(pila.search(50));

        // Verificar si la pila esta vacia

        System.out.println(pila.empty()); // false
       
    }

}