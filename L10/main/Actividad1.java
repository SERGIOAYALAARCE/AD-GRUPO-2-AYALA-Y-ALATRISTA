package main;

// ACTIVIDAD 1
// Representar grafos con matriz de adyacencia y lista de adyacencia
// a) Grafo dirigido   - inserciones al final
// b) Grafo no dirigido - inserciones al inicio
// c) Grafo ponderado  - inserciones al final

public class Actividad1 {

    public static void main(String[] args) {

        // ------------------------------------------------
        // a) GRAFO DIRIGIDO
        // Vertices: 1,2,3,4,5,6
        // Aristas dirigidas segun el diagrama del PDF
        // ------------------------------------------------
        System.out.println("=== a) GRAFO DIRIGIDO ===");

        int n = 6;
        int[][] matrizA = new int[n + 1][n + 1];

        // definir aristas {origen, destino}
        int[][] aristasA = {
            {1,3},{1,2},{3,2},{3,5},{2,4},{5,4},{5,6},{4,6}
        };

        // llenar la matriz
        for (int[] a : aristasA) {
            matrizA[a[0]][a[1]] = 1;
        }

        // mostrar matriz
        System.out.println("Matriz de adyacencia:");
        System.out.print("  ");
        for (int i = 1; i <= n; i++) System.out.print(" " + i);
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= n; j++) {
                System.out.print(" " + matrizA[i][j]);
            }
            System.out.println();
        }

        // mostrar lista de adyacencia (inserciones al final)
        System.out.println("Lista de adyacencia:");
        String[] listaA = new String[n + 1];
        for (int i = 1; i <= n; i++) listaA[i] = "";
        for (int[] a : aristasA) {
            listaA[a[0]] += a[1] + " ";
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " -> " + listaA[i]);
        }

        // ------------------------------------------------
        // b) GRAFO NO DIRIGIDO
        // Vertices: A,B,C,D,E
        // Inserciones al inicio de las listas
        // ------------------------------------------------
        System.out.println("\n=== b) GRAFO NO DIRIGIDO ===");

        // A=0, B=1, C=2, D=3, E=4
        int m = 5;
        int[][] matrizB = new int[m][m];
        String[] nombresB = {"A","B","C","D","E"};

        int[][] aristasB = {
            {0,1},{1,3},{2,4},{0,2},{1,2},{3,4},{1,4}
        };

        // llenar matriz simetrica (no dirigido)
        for (int[] a : aristasB) {
            matrizB[a[0]][a[1]] = 1;
            matrizB[a[1]][a[0]] = 1;
        }

        System.out.println("Matriz de adyacencia:");
        System.out.print("  ");
        for (String s : nombresB) System.out.print(" " + s);
        System.out.println();
        for (int i = 0; i < m; i++) {
            System.out.print(nombresB[i] + " ");
            for (int j = 0; j < m; j++) {
                System.out.print(" " + matrizB[i][j]);
            }
            System.out.println();
        }

        // lista con inserciones al inicio (simulado con arrays)
        System.out.println("Lista de adyacencia (inserciones al inicio):");
        String[] listaB = new String[m];
        for (int i = 0; i < m; i++) listaB[i] = "";
        for (int[] a : aristasB) {
            // insertar al inicio: nuevo elemento va adelante
            listaB[a[0]] = nombresB[a[1]] + " " + listaB[a[0]];
            listaB[a[1]] = nombresB[a[0]] + " " + listaB[a[1]];
        }
        for (int i = 0; i < m; i++) {
            System.out.println(nombresB[i] + " -> " + listaB[i]);
        }

        // ------------------------------------------------
        // c) GRAFO PONDERADO dirigido
        // Vertices: 1,2,3,4,5
        // Inserciones al final
        // ------------------------------------------------
        System.out.println("\n=== c) GRAFO PONDERADO ===");

        int p = 5;
        int[][] matrizC = new int[p + 1][p + 1];

        // {origen, destino, peso}
        int[][] aristasC = {
            {1,2,5},{1,5,4},{3,5,1},{2,4,3},{4,2,6},{4,5,2}
        };

        for (int[] a : aristasC) {
            matrizC[a[0]][a[1]] = a[2]; // guardamos el peso en vez de 1
        }

        System.out.println("Matriz de adyacencia (0 = sin arista):");
        System.out.print("  ");
        for (int i = 1; i <= p; i++) System.out.print("  " + i);
        System.out.println();
        for (int i = 1; i <= p; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= p; j++) {
                System.out.print("  " + matrizC[i][j]);
            }
            System.out.println();
        }

        System.out.println("Lista de adyacencia ponderada:");
        String[] listaC = new String[p + 1];
        for (int i = 1; i <= p; i++) listaC[i] = "";
        for (int[] a : aristasC) {
            listaC[a[0]] += a[1] + "(w:" + a[2] + ") ";
        }
        for (int i = 1; i <= p; i++) {
            System.out.println(i + " -> " + listaC[i]);
        }
    }
}