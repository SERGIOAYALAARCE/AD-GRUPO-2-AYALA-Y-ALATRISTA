package actividad3;

import actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>>
        implements PriorityQueue<E, N> {

    // Clase interna EntryNode
    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }

        public String toString() {
            return "(" + data + ", p:" + priority + ")";
        }
    }

    // Clase interna Node
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        T getData() { return data; }
        Node<T> getNext() { return next; }
        void setNext(Node<T> next) { this.next = next; }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, N pr) {
        EntryNode entry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(entry);

        if (isEmpty() || pr.compareTo(first.getData().priority) > 0) {
            newNode.setNext(first);
            first = newNode;
            if (last == null) last = first;
        } else {
            Node<EntryNode> current = first;
            while (current.getNext() != null &&
                   current.getNext().getData().priority.compareTo(pr) >= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) last = newNode;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue empty");
        E aux = first.getData().data;
        first = first.getNext();
        if (first == null) last = null;
        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return first.getData().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return last.getData().data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> aux = first;
        while (aux != null) {
            sb.append("[").append(aux.getData().data)
              .append(" | P:").append(aux.getData().priority).append("] ");
            aux = aux.getNext();
        }
        return sb.toString();
    }
}