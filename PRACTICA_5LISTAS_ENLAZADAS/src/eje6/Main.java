package eje6;

public class Main {

    public static <T> ListLinked<T> concatenarListas(ListLinked<T> lista1, ListLinked<T> lista2) {
        ListLinked<T> nueva = new ListLinked<>();
        ListLinked<T> invertida1 = new ListLinked<>();
        ListLinked<T> invertida2 = new ListLinked<>();

        Node<T> current = lista1.head;
        while (current != null) {
            invertida1.insertFirst(current.data);
            current = current.next;
        }

        current = lista2.head;
        while (current != null) {
            invertida2.insertFirst(current.data);
            current = current.next;
        }

        current = invertida2.head;
        while (current != null) {
            nueva.insertFirst(current.data);
            current = current.next;
        }

        current = invertida1.head;
        while (current != null) {
            nueva.insertFirst(current.data);
            current = current.next;
        }

        return nueva;
    }

    public static void main(String[] args) {
        ListLinked<Integer> lista1 = new ListLinked<>();
        lista1.insertFirst(30);
        lista1.insertFirst(20);
        lista1.insertFirst(10);

        ListLinked<Integer> lista2 = new ListLinked<>();
        lista2.insertFirst(60);
        lista2.insertFirst(50);
        lista2.insertFirst(40);

        System.out.print("Lista 1: "); lista1.print();
        System.out.print("Lista 2: "); lista2.print();

        ListLinked<Integer> resultado = concatenarListas(lista1, lista2);
        System.out.print("Concatenada: "); resultado.print();

        System.out.print("Lista 1 sin modificar: "); lista1.print();
        System.out.print("Lista 2 sin modificar: "); lista2.print();
    }
}