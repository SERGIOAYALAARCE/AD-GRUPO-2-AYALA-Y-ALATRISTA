package eje1;

public class Main {

    public static <T> boolean buscarElemento(ListLinked<T> lista, T valor) {
        Node<T> current = lista.head;
        while (current != null) {
            if (current.data.equals(valor)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListLinked<Integer> lista = new ListLinked<>();
        lista.insertFirst(10);
        lista.insertFirst(20);
        lista.insertFirst(30);
        lista.insertFirst(40);

        lista.print();

        System.out.println(buscarElemento(lista, 20));  // true
        System.out.println(buscarElemento(lista, 99));  // false
    }
}