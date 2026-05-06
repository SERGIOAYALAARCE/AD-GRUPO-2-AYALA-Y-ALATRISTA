package ejercicio3;
import actividad1.ExceptionIsEmpty;
public class TestEjercicio3 {
    public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueueMulti<String> pq = new PriorityQueueMulti<>(3); // niveles 0,1,2
        pq.enqueue("Normal",      0);
        pq.enqueue("Importante",  2);
        pq.enqueue("Medio",       1);
        pq.enqueue("Urgente",     2);
        System.out.println(pq.dequeue()); // Importante (nivel 2, primero)
        System.out.println(pq.dequeue()); // Urgente    (nivel 2, segundo)
        System.out.println(pq.dequeue()); // Medio      (nivel 1)
        System.out.println(pq.dequeue()); // Normal     (nivel 0)
    }
}