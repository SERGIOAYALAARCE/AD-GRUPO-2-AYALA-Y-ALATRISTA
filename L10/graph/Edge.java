package graph;

// Representa una arista entre dos vertices
// Usado en: Actividad 3, Ejercicio 1, 2, 3, 4
public class Edge {
    public Vertex destino; // vertice al que apunta la arista
    public int peso;       // peso de la arista

    // arista sin peso (se pone 1 por defecto)
    public Edge(Vertex destino) {
        this.destino = destino;
        this.peso = 1;
    }

    // arista con peso
    public Edge(Vertex destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public String toString() {
        return destino.data + "(peso:" + peso + ")";
    }
}