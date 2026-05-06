package ejercicio4;

import actividad1.ExceptionIsEmpty;

public class PriorityQueueHybrid<E, V extends Comparable<V>> {

    // Clase interna NodeH
    class NodeH {
        E data;
        V value;
        NodeH next;

        NodeH(E data, V value) {
            this.data = data;
            this.value = value;
        }
    }

    private NodeH[] table;
    private int n;

    @SuppressWarnings("unchecked")
    public PriorityQueueHybrid(int levels) {
        this.n = levels;
        this.table = (NodeH[]) new PriorityQueueHybrid.NodeH[levels];
    }

    public void enqueue(E data, int priority, V value) {
        if (priority < 0 || priority >= n) return;

        NodeH newNode = new NodeH(data, value);

        // Si la lista del nivel está vacía o el nuevo valor es menor al primero
        if (table[priority] == null || value.compareTo(table[priority].value) < 0) {
            newNode.next = table[priority];
            table[priority] = newNode;
        } else {
            // Inserción ordenada por valor V (secundario)
            NodeH current = table[priority];
            while (current.next != null && current.next.value.compareTo(value) <= 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        // Recorrer desde la prioridad más alta (n-1) a la más baja (0)
        for (int i = n - 1; i >= 0; i--) {
            if (table[i] != null) {
                E data = table[i].data;
                table[i] = table[i].next;
                return data;
            }
        }
        throw new ExceptionIsEmpty("Empty Hybrid Queue");
    }
}