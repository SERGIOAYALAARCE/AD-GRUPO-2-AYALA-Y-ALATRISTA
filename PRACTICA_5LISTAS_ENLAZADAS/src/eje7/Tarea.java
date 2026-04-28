package eje7;

public class Tarea implements Comparable<Tarea> {
    private String nombre;
    private int prioridad; // 1 = mayor prioridad

    public Tarea(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        return nombre + "(P" + prioridad + ")";
    }
}