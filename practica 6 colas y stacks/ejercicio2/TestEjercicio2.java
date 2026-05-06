package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad1.QueueArray;

public class TestEjercicio2 {
    public static void main(String[] args) {
        QueueArray<Integer> tienda = new QueueArray<>(5);

        try {
            tienda.enqueue(101);
            tienda.enqueue(102);
            tienda.enqueue(103);
            tienda.enqueue(104);
            tienda.enqueue(105);

            // Intento de agregar el 106 (cola llena)
            if (tienda.isFull()) System.out.println("Cola llena");

            System.out.println("Atendiendo cliente: " + tienda.dequeue());
            System.out.println("Atendiendo cliente: " + tienda.dequeue());

            System.out.println("Cliente en frente: " + tienda.front());

            tienda.enqueue(106);
            tienda.enqueue(107);

            while (!tienda.isEmpty()) {
                System.out.println("Atendiendo cliente: " + tienda.dequeue());
            }

            tienda.dequeue(); // Debe lanzar excepción
        } catch (ExceptionIsEmpty e) {
            System.out.println("Cola vacía");
        }
    }
}