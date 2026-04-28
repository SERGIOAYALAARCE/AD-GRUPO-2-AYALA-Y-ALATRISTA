package eje8;

public class Main {
    public static void main(String[] args) {
        ColaReproduccion<Cancion> cola = new ColaReproduccion<>();

        cola.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        cola.agregarCancion(new Cancion("Blinding Lights", "The Weeknd", 200));
        cola.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", 234));
        cola.agregarCancion(new Cancion("Bad Guy", "Billie Eilish", 194));
        cola.agregarCancion(new Cancion("Levitating", "Dua Lipa", 203));
        cola.agregarCancion(new Cancion("Peaches", "Justin Bieber", 198));

        System.out.println("=== Cola de Reproducción Inicial ===");
        cola.mostrarCola();

        System.out.println("\n--- Avanzando 3 canciones ---");
        for (int i = 0; i < 3; i++) {
            Cancion c = cola.reproducirSiguiente();
            if (c != null) System.out.println("► " + c);
        }

        System.out.println("\n--- Retrocediendo 1 canción ---");
        Cancion anterior = cola.reproducirAnterior();
        if (anterior != null) System.out.println("◄ " + anterior);

        System.out.println("\n=== Mezclando... ===");
        cola.mezclar();
        cola.mostrarCola();

        System.out.println("\nDuración total: " + cola.duracionFormateada());
    }
}