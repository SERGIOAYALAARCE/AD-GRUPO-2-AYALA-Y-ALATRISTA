package eje8;

import java.util.Random;

public class ColaReproduccion<T extends Cancion> {

    private NodeDoble<T> head;
    private NodeDoble<T> tail;
    private NodeDoble<T> actual;
    private int size;

    public ColaReproduccion() {
        head = null;
        tail = null;
        actual = null;
        size = 0;
    }

    // 1. Agregar al final
    public void agregarCancion(T cancion) {
        NodeDoble<T> nuevo = new NodeDoble<>(cancion);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
            actual = nuevo;          // primera canción = actual
        } else {
            nuevo.prev = tail;
            tail.next = nuevo;
            tail = nuevo;
        }
        size++;
    }

    // 2. Avanzar al siguiente
    public T reproducirSiguiente() {
        if (actual == null || actual.next == null) {
            System.out.println("[FIN DE LA COLA]");
            return null;
        }
        actual = actual.next;
        return actual.data;
    }

    // 3. Retroceder al anterior
    public T reproducirAnterior() {
        if (actual == null || actual.prev == null) {
            System.out.println("[INICIO DE LA COLA]");
            return null;
        }
        actual = actual.prev;
        return actual.data;
    }

    // 4. Shuffle — Fisher-Yates sobre un arreglo de referencias
    public void mezclar() {
        if (size <= 1) return;

        // Recolectar datos en arreglo
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Cancion[size];
        NodeDoble<T> cur = head;
        for (int i = 0; i < size; i++) {
            arr[i] = cur.data;
            cur = cur.next;
        }

        // Fisher-Yates
        Random rand = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            T tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        // Reescribir datos en nodos (manteniendo estructura de punteros)
        cur = head;
        for (int i = 0; i < size; i++) {
            cur.data = arr[i];
            cur = cur.next;
        }

        actual = head;   // reiniciar posición al principio
    }

    // 5. Mostrar cola
    public void mostrarCola() {
        NodeDoble<T> cur = head;
        int idx = 1;
        while (cur != null) {
            String marcador = (cur == actual) ? " ◄ REPRODUCIENDO" : "";
            System.out.println(idx + ". " + cur.data + marcador);
            cur = cur.next;
            idx++;
        }
        if (actual != null && actual.prev != null) {
            System.out.println("◄ Anterior: " + actual.prev.data);
        }
    }

    // 6. Duración total
    public int duracionTotal() {
        int total = 0;
        NodeDoble<T> cur = head;
        while (cur != null) {
            total += cur.data.getDuracionSeg();
            cur = cur.next;
        }
        return total;
    }

    // Helper: formato mm:ss
    public String duracionFormateada() {
        int total = duracionTotal();
        return String.format("%d:%02d", total / 60, total % 60);
    }
}