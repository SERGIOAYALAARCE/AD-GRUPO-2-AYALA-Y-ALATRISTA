package actividad3;
import actividad1.ExceptionIsEmpty;
public class TestActividad3 {
    public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueueLinkSort<String, Integer> pq = new PriorityQueueLinkSort<>();
        pq.enqueue("Tarea baja",   1);
        pq.enqueue("Tarea alta",   5);
        pq.enqueue("Tarea media",  3);
        System.out.println(pq);              // orden por prioridad
        System.out.println(pq.dequeue());    // Tarea alta
        System.out.println(pq.dequeue());    // Tarea media
        System.out.println(pq.dequeue());    // Tarea baja
    }
}