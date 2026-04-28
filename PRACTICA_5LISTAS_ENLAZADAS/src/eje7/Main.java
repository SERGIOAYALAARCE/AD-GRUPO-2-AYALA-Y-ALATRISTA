package eje7;

public class Main {
    public static void main(String[] args) {
        SortedListLinked<Tarea> lista = new SortedListLinked<>();

        lista.insertOrden(new Tarea("Diseñar UI", 3));
        lista.insertOrden(new Tarea("Fix crítico", 1));
        lista.insertOrden(new Tarea("Reunión", 2));
        lista.insertOrden(new Tarea("Documentar", 5));
        lista.insertOrden(new Tarea("Code review", 2));

        lista.print();
        // [Fix crítico(P1) -> Reunión(P2) -> Code review(P2) -> Diseñar UI(P3) -> Documentar(P5)]
    }
}