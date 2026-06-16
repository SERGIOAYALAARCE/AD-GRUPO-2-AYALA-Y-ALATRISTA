package graph;

import listlinked.ListLinked;
import listlinked.Node;
import java.util.Stack;

// Grafo con listas de adyacencia usando ListLinked
// Usado en: Actividad 3, Ejercicio 1, 2, 3, 4
public class GraphLink {

    public ListLinked vertices;    // lista de Vertex
    public ListLinked adyacencias; // lista de ListLinked, cada una con Edge

    public GraphLink() {
        vertices = new ListLinked();
        adyacencias = new ListLinked();
    }

    // busca el indice de un vertice por nombre, retorna -1 si no existe
    private int buscarIndice(String nombre) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = (Vertex) vertices.get(i);
            if (v.data.equals(nombre)) return i;
        }
        return -1;
    }

    // -------------------------------------------------------
    // ACTIVIDAD 3 - insertar vertice
    // -------------------------------------------------------
    public void insertVertex(String nombre) {
        // no agregar si ya existe
        if (buscarIndice(nombre) != -1) return;
        vertices.addLast(new Vertex(nombre));
        adyacencias.addLast(new ListLinked()); // lista vacia para sus aristas
    }

    // -------------------------------------------------------
    // ACTIVIDAD 3 - insertar arista no dirigida sin peso
    // -------------------------------------------------------
    public void insertEdge(String origen, String destino) {
        int i = buscarIndice(origen);
        int j = buscarIndice(destino);
        if (i == -1 || j == -1) return; // si no existen los vertices, salir

        Vertex vOrigen  = (Vertex) vertices.get(i);
        Vertex vDestino = (Vertex) vertices.get(j);

        // se agrega en ambos sentidos porque es no dirigido
        ListLinked listaI = (ListLinked) adyacencias.get(i);
        ListLinked listaJ = (ListLinked) adyacencias.get(j);
        listaI.addLast(new Edge(vDestino));
        listaJ.addLast(new Edge(vOrigen));
    }

    // -------------------------------------------------------
    // EJERCICIO 1 - insertar arista con peso
    // -------------------------------------------------------
    public void insertEdgeWeight(String origen, String destino, int peso) {
        int i = buscarIndice(origen);
        int j = buscarIndice(destino);
        if (i == -1 || j == -1) return;

        Vertex vOrigen  = (Vertex) vertices.get(i);
        Vertex vDestino = (Vertex) vertices.get(j);

        ListLinked listaI = (ListLinked) adyacencias.get(i);
        ListLinked listaJ = (ListLinked) adyacencias.get(j);
        listaI.addLast(new Edge(vDestino, peso));
        listaJ.addLast(new Edge(vOrigen,  peso));
    }

    // -------------------------------------------------------
    // EJERCICIO 1 - verificar si el grafo es conexo
    // recorre con DFS y cuenta cuantos visito
    // -------------------------------------------------------
    public boolean isConexo() {
        if (vertices.size() == 0) return true;

        boolean[] visitado = new boolean[vertices.size()];
        Stack<Integer> pila = new Stack<>();
        pila.push(0);
        visitado[0] = true;
        int contador = 1;

        while (!pila.isEmpty()) {
            int actual = pila.pop();
            ListLinked lista = (ListLinked) adyacencias.get(actual);
            for (int k = 0; k < lista.size(); k++) {
                Edge e = (Edge) lista.get(k);
                int ind = buscarIndice(e.destino.data);
                if (!visitado[ind]) {
                    visitado[ind] = true;
                    pila.push(ind);
                    contador++;
                }
            }
        }
        // si visito todos es conexo
        return contador == vertices.size();
    }

    // -------------------------------------------------------
    // EJERCICIO 1 - ruta mas corta con Dijkstra, retorna Stack
    // -------------------------------------------------------
    public Stack<String> shortPath(String origen, String destino) {
        int n = vertices.size();
        int[] dist  = new int[n];
        int[] previo = new int[n];
        boolean[] visitado = new boolean[n];

        // inicializar distancias en un numero grande
        for (int i = 0; i < n; i++) {
            dist[i]  = 99999;
            previo[i] = -1;
        }

        int inicio = buscarIndice(origen);
        if (inicio == -1) return new Stack<>();
        dist[inicio] = 0;

        // repetir n veces
        for (int iter = 0; iter < n; iter++) {
            // buscar el vertice no visitado con menor distancia
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!visitado[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            if (u == -1 || dist[u] == 99999) break;
            visitado[u] = true;

            // actualizar distancias de vecinos
            ListLinked lista = (ListLinked) adyacencias.get(u);
            for (int k = 0; k < lista.size(); k++) {
                Edge e  = (Edge) lista.get(k);
                int v   = buscarIndice(e.destino.data);
                int nueva = dist[u] + e.peso;
                if (nueva < dist[v]) {
                    dist[v]  = nueva;
                    previo[v] = u;
                }
            }
        }

        // reconstruir ruta en un Stack
        Stack<String> ruta = new Stack<>();
        int fin = buscarIndice(destino);
        if (fin == -1 || dist[fin] == 99999) return ruta; // sin ruta

        int paso = fin;
        while (paso != -1) {
            ruta.push(((Vertex) vertices.get(paso)).data);
            paso = previo[paso];
        }
        return ruta;
    }

    // -------------------------------------------------------
    // ACTIVIDAD 2 / EJERCICIO 2 - recorrido en profundidad DFS
    // -------------------------------------------------------
    public void dfs(String inicio) {
        boolean[] visitado = new boolean[vertices.size()];
        Stack<Integer> pila = new Stack<>();
        int ind = buscarIndice(inicio);
        if (ind == -1) return;

        pila.push(ind);
        System.out.print("DFS: ");

        while (!pila.isEmpty()) {
            int actual = pila.pop();
            if (visitado[actual]) continue;
            visitado[actual] = true;
            System.out.print(vertices.get(actual) + " ");

            // agregar vecinos no visitados a la pila
            ListLinked lista = (ListLinked) adyacencias.get(actual);
            for (int k = lista.size() - 1; k >= 0; k--) {
                Edge e = (Edge) lista.get(k);
                int v = buscarIndice(e.destino.data);
                if (!visitado[v]) pila.push(v);
            }
        }
        System.out.println();
    }

    // -------------------------------------------------------
    // ACTIVIDAD 2 / EJERCICIO 2 - recorrido en anchura BFS
    // -------------------------------------------------------
    public void bfs(String inicio) {
        boolean[] visitado = new boolean[vertices.size()];
        // usamos un arreglo como cola simple
        int[] cola = new int[vertices.size()];
        int frente = 0, fin = 0;

        int ind = buscarIndice(inicio);
        if (ind == -1) return;

        cola[fin++] = ind;
        visitado[ind] = true;
        System.out.print("BFS: ");

        while (frente < fin) {
            int actual = cola[frente++];
            System.out.print(vertices.get(actual) + " ");

            ListLinked lista = (ListLinked) adyacencias.get(actual);
            for (int k = 0; k < lista.size(); k++) {
                Edge e = (Edge) lista.get(k);
                int v = buscarIndice(e.destino.data);
                if (!visitado[v]) {
                    visitado[v] = true;
                    cola[fin++] = v;
                }
            }
        }
        System.out.println();
    }

    // -------------------------------------------------------
    // EJERCICIO 3 - eliminar un vertice y sus aristas
    // -------------------------------------------------------
    public void removeVertex(String nombre) {
        int ind = buscarIndice(nombre);
        if (ind == -1) return;

        // quitar aristas que apuntan a este vertice en otros nodos
        for (int i = 0; i < adyacencias.size(); i++) {
            ListLinked lista = (ListLinked) adyacencias.get(i);
            Node ant = null;
            Node aux = lista.head;
            while (aux != null) {
                Edge e = (Edge) aux.data;
                if (e.destino.data.equals(nombre)) {
                    if (ant == null) lista.head = aux.next;
                    else ant.next = aux.next;
                    break;
                }
                ant = aux;
                aux = aux.next;
            }
        }

        // quitar el vertice y su lista de adyacencia
        // reconstruir ambas listas sin el indice ind
        ListLinked nuevosV = new ListLinked();
        ListLinked nuevasA = new ListLinked();
        for (int i = 0; i < vertices.size(); i++) {
            if (i != ind) {
                nuevosV.addLast(vertices.get(i));
                nuevasA.addLast(adyacencias.get(i));
            }
        }
        vertices    = nuevosV;
        adyacencias = nuevasA;
    }

    // -------------------------------------------------------
    // EJERCICIO 3 - eliminar una arista
    // -------------------------------------------------------
    public void removeEdge(String origen, String destino) {
        int i = buscarIndice(origen);
        int j = buscarIndice(destino);
        if (i == -1 || j == -1) return;

        // quitar destino de la lista de origen
        quitarDeLista((ListLinked) adyacencias.get(i), destino);
        // quitar origen de la lista de destino (no dirigido)
        quitarDeLista((ListLinked) adyacencias.get(j), origen);
    }

    // metodo auxiliar para quitar una arista de una lista
    private void quitarDeLista(ListLinked lista, String nombre) {
        Node ant = null;
        Node aux = lista.head;
        while (aux != null) {
            Edge e = (Edge) aux.data;
            if (e.destino.data.equals(nombre)) {
                if (ant == null) lista.head = aux.next;
                else ant.next = aux.next;
                return;
            }
            ant = aux;
            aux = aux.next;
        }
    }

    // -------------------------------------------------------
    // EJERCICIO 3 - buscar si un vertice existe
    // -------------------------------------------------------
    public boolean searchVertex(String nombre) {
        return buscarIndice(nombre) != -1;
    }

    // -------------------------------------------------------
    // EJERCICIO 3 - buscar si una arista existe
    // -------------------------------------------------------
    public boolean searchEdge(String origen, String destino) {
        int i = buscarIndice(origen);
        if (i == -1) return false;
        ListLinked lista = (ListLinked) adyacencias.get(i);
        for (int k = 0; k < lista.size(); k++) {
            Edge e = (Edge) lista.get(k);
            if (e.destino.data.equals(destino)) return true;
        }
        return false;
    }

    // muestra el grafo completo
    public String toString() {
        String res = "";
        for (int i = 0; i < vertices.size(); i++) {
            res += vertices.get(i) + " -> " + adyacencias.get(i) + "\n";
        }
        return res;
    }
}