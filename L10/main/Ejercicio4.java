package main;

import graph.GraphLink;

// EJERCICIO 4
// Verificar propiedades de un grafo:
//   isomorfo         - misma secuencia de grados (condicion necesaria)
//   plano            - formula de Euler: aristas <= 3*vertices - 6
//   conexo           - todos los vertices conectados
//   autocomplementario - el complemento es isomorfo al original

public class Ejercicio4 {

    // cuenta las aristas totales de una matriz
    static int contarAristas(int[][] m, int n) {
        int cont = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (m[i][j] == 1) cont++;
        return cont;
    }

    // calcula el grado de cada vertice (suma de su fila)
    static int[] calcularGrados(int[][] m, int n) {
        int[] grados = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grados[i] += m[i][j];
        return grados;
    }

    // dos grafos son isomorfos si tienen la misma secuencia de grados ordenada
    static boolean esIsomorfo(int[][] m1, int[][] m2, int n) {
        int[] g1 = calcularGrados(m1, n);
        int[] g2 = calcularGrados(m2, n);
        // ordenar ambos arreglos
        java.util.Arrays.sort(g1);
        java.util.Arrays.sort(g2);
        // comparar
        for (int i = 0; i < n; i++) {
            if (g1[i] != g2[i]) return false;
        }
        return true;
    }

    // un grafo es plano si cumple: aristas <= 3*vertices - 6
    static boolean esPlano(int[][] m, int n) {
        int aristas = contarAristas(m, n);
        if (n < 3) return true;
        return aristas <= 3 * n - 6;
    }

    // verifica si el grafo es conexo con BFS simple
    static boolean esConexo(int[][] m, int n) {
        boolean[] visitado = new boolean[n];
        int[] cola = new int[n];
        int frente = 0, fin = 0;
        cola[fin++] = 0;
        visitado[0] = true;
        int contador = 1;

        while (frente < fin) {
            int actual = cola[frente++];
            for (int j = 0; j < n; j++) {
                // consideramos ambas direcciones para conexidad debil
                if ((m[actual][j] == 1 || m[j][actual] == 1) && !visitado[j]) {
                    visitado[j] = true;
                    cola[fin++] = j;
                    contador++;
                }
            }
        }
        return contador == n;
    }

    // crea el complemento del grafo (invierte 0 y 1 sin diagonal)
    static int[][] complemento(int[][] m, int n) {
        int[][] comp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j) comp[i][j] = (m[i][j] == 0) ? 1 : 0;
        return comp;
    }

    // es autocomplementario si el complemento es isomorfo al original
    static boolean esAutoComplementario(int[][] m, int n) {
        int[][] comp = complemento(m, n);
        return esIsomorfo(m, comp, n);
    }

    // imprime una matriz
    static void imprimirMatriz(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 4: Propiedades de grafos ===");

        // Grafo 1: ciclo de 4 vertices  0->1->2->3->0
        int n = 4;
        int[][] g1 = {
            {0,1,0,0},
            {0,0,1,0},
            {0,0,0,1},
            {1,0,0,0}
        };

        System.out.println("\nGrafo 1 (ciclo 0->1->2->3->0):");
        imprimirMatriz(g1, n);
        System.out.println("Es conexo:            " + esConexo(g1, n));
        System.out.println("Es plano:             " + esPlano(g1, n));
        System.out.println("Es autocomplementario:" + esAutoComplementario(g1, n));

        // Grafo 2: mismo ciclo pero diferente orden de vertices
        int[][] g2 = {
            {0,0,1,0},
            {0,0,0,1},
            {0,0,0,1},
            {1,0,0,0}
        };

        System.out.println("\nGrafo 2:");
        imprimirMatriz(g2, n);
        System.out.println("Grafo1 isomorfo a Grafo2: " + esIsomorfo(g1, g2, n));

        // Grafo 3: no conexo  0->1  y  2->3 (separados)
        int[][] g3 = {
            {0,1,0,0},
            {0,0,0,0},
            {0,0,0,1},
            {0,0,0,0}
        };

        System.out.println("\nGrafo 3 (no conexo):");
        imprimirMatriz(g3, n);
        System.out.println("Es conexo: " + esConexo(g3, n));
        System.out.println("Es plano:  " + esPlano(g3, n));

        // usar GraphLink para mostrar BFS y DFS del Grafo 1
        System.out.println("\nRecorridos del Grafo 1 con GraphLink:");
        GraphLink grafo = new GraphLink();
        grafo.insertVertex("0");
        grafo.insertVertex("1");
        grafo.insertVertex("2");
        grafo.insertVertex("3");
        grafo.insertEdge("0","1");
        grafo.insertEdge("1","2");
        grafo.insertEdge("2","3");
        grafo.insertEdge("3","0");
        grafo.bfs("0");
        grafo.dfs("0");
    }
}