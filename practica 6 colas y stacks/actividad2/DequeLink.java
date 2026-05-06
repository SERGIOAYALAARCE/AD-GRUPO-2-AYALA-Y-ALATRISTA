package actividad2;

import actividad1.ExceptionIsEmpty;

public class DequeLink<E> implements Deque<E> {
    private Node<E> first;
    private Node<E> last;

    public DequeLink() {
        first = null;
        last = null;
    }

    public void addFirst(E x) {
        Node<E> newNode = new Node<>(x);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }

    public void addLast(E x) {
        Node<E> newNode = new Node<>(x);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    public E removeFirst() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Deque is empty");
        E data = first.getData();
        first = first.getNext();
        if (first == null) last = null;
        return data;
    }

    public E removeLast() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Deque is empty");
        E data = last.getData();
        if (first == last) {
            first = last = null;
        } else {
            Node<E> current = first;
            while (current.getNext() != last) {
                current = current.getNext();
            }
            current.setNext(null);
            last = current;
        }
        return data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}