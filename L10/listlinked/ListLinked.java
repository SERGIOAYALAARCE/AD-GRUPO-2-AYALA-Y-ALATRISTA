package listlinked;

// Lista enlazada simple usada por el grafo
public class ListLinked {
    public Node head; // primer nodo de la lista

    public ListLinked() {
        head = null;
    }

    // agrega un elemento al final de la lista
    public void addLast(Object data) {
        Node nuevo = new Node(data);
        if (head == null) {
            head = nuevo;
        } else {
            Node aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
        }
    }

    // agrega un elemento al inicio de la lista
    public void addFirst(Object data) {
        Node nuevo = new Node(data);
        nuevo.next = head;
        head = nuevo;
    }

    // retorna el elemento en la posicion i
    public Object get(int i) {
        Node aux = head;
        int cont = 0;
        while (aux != null) {
            if (cont == i) return aux.data;
            aux = aux.next;
            cont++;
        }
        return null;
    }

    // retorna cuantos elementos tiene la lista
    public int size() {
        int cont = 0;
        Node aux = head;
        while (aux != null) {
            cont++;
            aux = aux.next;
        }
        return cont;
    }

    // muestra la lista como texto
    public String toString() {
        String res = "[";
        Node aux = head;
        while (aux != null) {
            res += aux.data;
            if (aux.next != null) res += ", ";
            aux = aux.next;
        }
        return res + "]";
    }
}