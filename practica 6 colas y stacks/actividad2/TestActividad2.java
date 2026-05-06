package actividad2;
import actividad1.ExceptionIsEmpty;
public class TestActividad2 {
    public static void main(String[] args) throws ExceptionIsEmpty {
        DequeLink<Integer> deque = new DequeLink<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        System.out.println("removeFirst: " + deque.removeFirst()); // 5
        System.out.println("removeLast: "  + deque.removeLast());  // 20
        System.out.println("removeFirst: " + deque.removeFirst()); // 10
    }
}