package main;

import graph.GraphLink;

// ACTIVIDAD 3
// Implementacion del TAD Graph usando listas enlazadas
// Se prueba: insertVertex, insertEdge y toString

public class Actividad3 {

    public static void main(String[] args) {
        System.out.println("=== ACTIVIDAD 3: TAD GraphLink ===");

        GraphLink g = new GraphLink();

        // insertar vertices
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        // insertar aristas
        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");

        // mostrar el grafo
        System.out.println("Grafo creado:");
        System.out.println(g);

        // salida esperada:
        // A -> [B(peso:1), C(peso:1)]
        // B -> [A(peso:1), D(peso:1)]
        // C -> [A(peso:1)]
        // D -> [B(peso:1)]
    }
}