package eje8;

public class NodeDoble<T> {
    public T data;
    public NodeDoble<T> next;
    public NodeDoble<T> prev;

    public NodeDoble(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}