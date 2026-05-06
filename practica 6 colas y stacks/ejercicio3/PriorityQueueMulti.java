package ejercicio3;

import actividad1.ExceptionIsEmpty;
import actividad2.DequeLink;

public class PriorityQueueMulti<E> {
    private DequeLink<E>[] queues;
    private int levels;

    @SuppressWarnings("unchecked")
    public PriorityQueueMulti(int levels) {
        this.levels = levels;
        queues = new DequeLink[levels];
        for (int i = 0; i < levels; i++) {
            queues[i] = new DequeLink<>();
        }
    }

    public void enqueue(E x, int priority) {
        if (priority >= 0 && priority < levels) {
            queues[priority].addLast(x);
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].removeFirst();
            }
        }
        throw new ExceptionIsEmpty("All queues are empty");
    }
}