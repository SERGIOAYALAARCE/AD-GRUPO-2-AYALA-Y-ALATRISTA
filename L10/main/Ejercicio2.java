package main;

import graph.GraphLink;
import java.util.Stack;

// EJERCICIO 2
// Red de ciudades con grafo ponderado
// Misma logica que Ejercicio 1 pero con mas funcionalidades mostradas
// Nota: si se pide usar JGraphT, agregar la dependencia al proyecto
//       aqui se resuelve con GraphLink propio para no necesitar librerias externas

public class Ejercicio2 {

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: Red de ciudades ===");

        GraphLink red = new GraphLink();

        // agregar ciudades
        red.insertVertex("Arequipa");
        red.insertVertex("Cusco");
        red.insertVertex("Puno");
        red.insertVertex("Tacna");
        red.insertVertex("Moquegua");

        // agregar carreteras con distancia en km
        red.insertEdgeWeight("Arequipa",  "Cusco",    510);
        red.insertEdgeWeight("Arequipa",  "Moquegua", 230);
        red.insertEdgeWeight("Moquegua",  "Tacna",    160);
        red.insertEdgeWeight("Cusco",     "Puno",     390);
        red.insertEdgeWeight("Puno",      "Tacna",    420);

        // mostrar todas las conexiones
        System.out.println("Conexiones del grafo:");
        System.out.println(red);

        // camino mas corto entre dos ciudades
        System.out.println("Camino mas corto Arequipa -> Tacna:");
        Stack<String> ruta = red.shortPath("Arequipa", "Tacna");
        while (!ruta.isEmpty()) {
            System.out.print(ruta.pop());
            if (!ruta.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();

        System.out.println("\nCamino mas corto Cusco -> Tacna:");
        Stack<String> ruta2 = red.shortPath("Cusco", "Tacna");
        while (!ruta2.isEmpty()) {
            System.out.print(ruta2.pop());
            if (!ruta2.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();
    }
}