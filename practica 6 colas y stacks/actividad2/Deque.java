package actividad2;

import actividad1.ExceptionIsEmpty;

public interface Deque<E> {
    void addFirst(E x);
    void addLast(E x);
    E removeFirst() throws ExceptionIsEmpty;
    E removeLast() throws ExceptionIsEmpty;
    boolean isEmpty();
}