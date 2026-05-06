package actividadPilaLista;

import actividad1.ExceptionIsEmpty;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(top);
        top = newNode;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty");
        E data = top.getData();
        top = top.getNext();
        return data;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty");
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        String s = "Top -> ";
        Node<E> aux = top;
        while (aux != null) {
            s += aux.getData() + " ";
            aux = aux.getNext();
        }
        return s;
    }
}