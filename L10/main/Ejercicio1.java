package main;

import graph.GraphLink;
import java.util.Stack;

// EJERCICIO 1
// Metodos agregados a GraphLink:
//   insertEdgeWeight - arista con peso
//   shortPath        - ruta mas corta, retorna Stack
//   isConexo         - true si el grafo es conexo

public class Ejercicio1 {

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: Grafo ponderado ===");

        GraphLink g = new GraphLink();

        // agregar ciudades como vertices
        g.insertVertex("Arequipa");
        g.insertVertex("Cusco");
        g.insertVertex("Puno");
        g.insertVertex("Tacna");
        g.insertVertex("Moquegua");

        // agregar carreteras con distancia
        g.insertEdgeWeight("Arequipa",  "Cusco",    510);
        g.insertEdgeWeight("Arequipa",  "Moquegua", 230);
        g.insertEdgeWeight("Moquegua",  "Tacna",    160);
        g.insertEdgeWeight("Cusco",     "Puno",     390);
        g.insertEdgeWeight("Puno",      "Tacna",    420);

        System.out.println("Grafo de ciudades:");
        System.out.println(g);

        // verificar si es conexo
        System.out.println("Es conexo: " + g.isConexo());

        // ruta mas corta de Arequipa a Tacna
        Stack<String> ruta = g.shortPath("Arequipa", "Tacna");
        System.out.print("Ruta Arequipa -> Tacna: ");
        // el stack tiene el inicio en el tope, imprimimos vaciandolo
        while (!ruta.isEmpty()) {
            System.out.print(ruta.pop());
            if (!ruta.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();
    }
}