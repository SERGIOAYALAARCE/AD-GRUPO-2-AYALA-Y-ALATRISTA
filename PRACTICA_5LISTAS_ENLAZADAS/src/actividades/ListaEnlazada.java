package actividades;

public class ListaEnlazada<T> {
    private Nodo_act<T> cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }
    // Agrega al final de la lista
    public void agregar(T dato) {
        Nodo_act<T> nuevo = new Nodo_act<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo_act<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    // Elimina la primera ocurrencia del dato
    public boolean eliminar(T dato) {
        if (cabeza == null) return false;

        if (cabeza.dat.equals(dato)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo_act<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dat.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) return false;

        actual.siguiente = actual.siguiente.siguiente;
        return true;
    }
    // Verifica si existe una tarea
    public boolean contiene(T dato) {
        Nodo_act<T> actual = cabeza;
        while (actual != null) {
            if (actual.dat.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    // Imprime todas las tareas
    public void imprimir() {
        Nodo_act<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dat);
            actual = actual.siguiente;
        }
    }

    // Cuenta todas las tareas
    public int contar() {
        int contador = 0;
        Nodo_act<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // Invierte la lista
    public void invertir() {
        Nodo_act<T> anterior = null;
        Nodo_act<T> actual = cabeza;
        Nodo_act<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }

    // Devuelve la cabeza (para tareas más complejas como obtener la de mayor prioridad)
    public Nodo_act<T> getCabeza() {
        return cabeza;
    }
}
