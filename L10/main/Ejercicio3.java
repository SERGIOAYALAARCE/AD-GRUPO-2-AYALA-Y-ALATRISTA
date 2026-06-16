package main;

import graph.GraphLink;

// EJERCICIO 3
// Prueba de todos los metodos del TAD GraphLink:
//   insertVertex, insertEdge, removeVertex, removeEdge,
//   searchVertex, searchEdge, BFS, DFS

public class Ejercicio3 {

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 3: Metodos del TAD GraphLink ===");

        GraphLink g = new GraphLink();

        // insertar vertices
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");

        // insertar aristas
        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");
        g.insertEdge("C", "D");
        g.insertEdge("D", "E");

        System.out.println("Grafo inicial:");
        System.out.println(g);

        // buscar vertice
        System.out.println("Existe vertice C: " + g.searchVertex("C"));
        System.out.println("Existe vertice Z: " + g.searchVertex("Z"));

        // buscar arista
        System.out.println("Existe arista A-B: " + g.searchEdge("A", "B"));
        System.out.println("Existe arista A-E: " + g.searchEdge("A", "E"));

        // recorridos
        g.bfs("A");
        g.dfs("A");

        // eliminar arista
        System.out.println("\nEliminando arista A-C...");
        g.removeEdge("A", "C");
        System.out.println("Existe arista A-C: " + g.searchEdge("A", "C"));
        System.out.println(g);

        // eliminar vertice
        System.out.println("Eliminando vertice D...");
        g.removeVertex("D");
        System.out.println("Existe vertice D: " + g.searchVertex("D"));
        System.out.println(g);
    }
}