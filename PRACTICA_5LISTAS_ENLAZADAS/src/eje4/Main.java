package eje4;

public class Main {

    public static <T> int contarNodos(Node<T> head) {
        int contador = 0;
        Node<T> current = head;
        while (current != null) {
            contador++;
            current = current.next;
        }
        return contador;
    }

    public static void main(String[] args) {
        Node<Integer> head = null;

        head = new Node<>(10);
        head.next = new Node<>(20);
        head.next.next = new Node<>(30);
        head.next.next.next = new Node<>(40);

        System.out.println("Total de nodos: " + contarNodos(head)); // 4
    }
}