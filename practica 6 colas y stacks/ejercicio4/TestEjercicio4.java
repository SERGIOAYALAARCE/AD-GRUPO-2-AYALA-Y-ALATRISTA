package ejercicio4;
import actividad1.ExceptionIsEmpty;
public class TestEjercicio4 {
    public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueueHybrid<String, Integer> pq = new PriorityQueueHybrid<>(3);
        pq.enqueue("Tarea C", 2, 30); // prioridad 2, valor secundario 30
        pq.enqueue("Tarea A", 2, 10); // prioridad 2, valor secundario 10
        pq.enqueue("Tarea B", 1, 20); // prioridad 1
        System.out.println(pq.dequeue()); // Tarea A (nivel 2, menor valor)
        System.out.println(pq.dequeue()); // Tarea C (nivel 2, mayor valor)
        System.out.println(pq.dequeue()); // Tarea B (nivel 1)
    }
}