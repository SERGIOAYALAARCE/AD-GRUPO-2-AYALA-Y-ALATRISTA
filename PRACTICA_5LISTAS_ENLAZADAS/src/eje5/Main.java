package eje5;

public class Main {

    public static <T> boolean sonIguales(ListLinked<T> lista1, ListLinked<T> lista2) {
        Node<T> current1 = lista1.head;
        Node<T> current2 = lista2.head;
        while (current1 != null && current2 != null) {
            if (!current1.data.equals(current2.data)) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }

    public static void main(String[] args) {
        ListLinked<Integer> lista1 = new ListLinked<>();
        lista1.insertFirst(30);
        lista1.insertFirst(20);
        lista1.insertFirst(10);

        ListLinked<Integer> lista2 = new ListLinked<>();
        lista2.insertFirst(30);
        lista2.insertFirst(20);
        lista2.insertFirst(10);

        ListLinked<Integer> lista3 = new ListLinked<>();
        lista3.insertFirst(30);
        lista3.insertFirst(99);
        lista3.insertFirst(10);

        ListLinked<Integer> lista4 = new ListLinked<>();
        lista4.insertFirst(30);
        lista4.insertFirst(20);

        System.out.print("Lista 1: "); lista1.print();
        System.out.print("Lista 2: "); lista2.print();
        System.out.print("Lista 3: "); lista3.print();
        System.out.print("Lista 4: "); lista4.print();

        System.out.println("Lista1 == Lista2: " + sonIguales(lista1, lista2)); // true
        System.out.println("Lista1 == Lista3: " + sonIguales(lista1, lista3)); // false
        System.out.println("Lista1 == Lista4: " + sonIguales(lista1, lista4)); // false
    }
}