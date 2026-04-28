package eje7;

public class SortedListLinked<T extends Comparable<T>> extends ListLinked<T> {

    public void insertOrden(T x) {
        Node<T> newNode = new Node<>(x);

        // Caso 1: lista vacía o nuevo elemento es el menor
        if (head == null || x.compareTo(head.data) <= 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Caso 2: buscar la posición correcta
        Node<T> current = head;
        while (current.next != null && x.compareTo(current.next.data) > 0) {
            current = current.next;
        }

        // Insertar entre current y current.next
        newNode.next = current.next;
        current.next = newNode;
    }
}