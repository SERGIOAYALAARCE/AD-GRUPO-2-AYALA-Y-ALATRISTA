package main;

import graph.GraphLink;

// ACTIVIDAD 2
// Recorrido BFS y DFS del grafo del PDF
// Vertices: A,B,C,D,E,F,G,H
// Las aristas se insertan al final de la lista de adyacencia

public class Actividad2 {

    public static void main(String[] args) {
        System.out.println("=== ACTIVIDAD 2: BFS y DFS ===");

        GraphLink grafo = new GraphLink();

        // agregar vertices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");
        grafo.insertVertex("F");
        grafo.insertVertex("G");
        grafo.insertVertex("H");

        // agregar aristas segun el diagrama del PDF
        grafo.insertEdge("A", "C");
        grafo.insertEdge("A", "H");
        grafo.insertEdge("A", "B");
        grafo.insertEdge("C", "F");
        grafo.insertEdge("C", "B");
        grafo.insertEdge("C", "E");
        grafo.insertEdge("H", "D");
        grafo.insertEdge("H", "B");
        grafo.insertEdge("H", "G");
        grafo.insertEdge("B", "E");
        grafo.insertEdge("B", "D");
        grafo.insertEdge("B", "G");
        grafo.insertEdge("E", "F");
        grafo.insertEdge("E", "G");
        grafo.insertEdge("D", "G");
        grafo.insertEdge("G", "F");

        System.out.println("Grafo:");
        System.out.println(grafo);

        // recorrido en anchura desde A
        grafo.bfs("A");

        // recorrido en profundidad desde A
        grafo.dfs("A");
    }
}