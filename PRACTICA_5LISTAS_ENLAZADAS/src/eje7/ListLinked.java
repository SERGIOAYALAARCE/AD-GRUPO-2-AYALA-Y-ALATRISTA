package eje7;

public class ListLinked<T extends Comparable<T>> {
    protected Node<T> head;

    public ListLinked() {
        this.head = null;
    }

    public void insertFirst(T x) {
        Node<T> newNode = new Node<>(x);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("]");
    }

    public boolean isEmpty() {
        return head == null;
    }
}
