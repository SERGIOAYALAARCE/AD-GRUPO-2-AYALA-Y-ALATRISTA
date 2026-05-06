package actividad1;

public class QueueArray<E> implements Queue<E> {
    private Object[] array;
    private int front;
    private int rear;
    private int size;
    private int n;

    public QueueArray(int n) {
        this.n = n;
        array = (E[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == n;
    }

    public void enqueue(E x) {
        if (isFull()) {
            System.out.println("Queue esta full");
            return;
        }
        rear = (rear + 1) % n;
        array[rear] = x;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue esta vacio");
        E x = (E) array[front];
        array[front] = null;
        front = (front + 1) % n;
        size--;
        return x;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue esta vacio");
        return (E) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}