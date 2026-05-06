package actividadPilaLista;
import actividad1.ExceptionIsEmpty;
public class TestEjercicio1 {
    public static void main(String[] args) throws ExceptionIsEmpty {
        StackLink<String> stack = new StackLink<>();
        stack.push("Primero");
        stack.push("Segundo");
        stack.push("Tercero");
        System.out.println(stack);           // Top -> Tercero Segundo Primero
        System.out.println(stack.pop());     // Tercero
        System.out.println(stack.top());     // Segundo
    }
}