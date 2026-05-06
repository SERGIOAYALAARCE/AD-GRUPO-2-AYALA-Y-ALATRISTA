package actividad1;
public class TestActividad1 {
    public static void main(String[] args) throws ExceptionIsEmpty {
        QueueArray<String> q = new QueueArray<>(3);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        System.out.println("Front: " + q.front());
        System.out.println("Dequeue: " + q.dequeue());
        q.enqueue("D"); // reutiliza espacio circular
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
    }
}