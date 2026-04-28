package eje2;

public class Main {

    public static <T> ListLinked<T> invertirLista(ListLinked<T> lista) {
        ListLinked<T> nueva = new ListLinked<>();
        Node<T> current = lista.head;
        while (current != null) {
            nueva.insertFirst(current.data);
            current = current.next;
        }
        return nueva;
    }

    public static void main(String[] args) {
        ListLinked<Integer> lista = new ListLinked<>();
        lista.insertFirst(10);
        lista.insertFirst(20);
        lista.insertFirst(30);
        lista.insertFirst(40);

        System.out.print("Original:  ");
        lista.print();

        ListLinked<Integer> invertida = invertirLista(lista);
        System.out.print("Invertida: ");
        invertida.print();

        System.out.print("Original sin modificar: ");
        lista.print();
    }
}