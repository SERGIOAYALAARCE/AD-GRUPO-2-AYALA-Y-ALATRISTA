package actividades;

public class Main {
    public static void main(String[] args) {

        // 1. Crear instancia de GestorDeTareas
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        ListaEnlazada<Tarea> tareasCompletadas = new ListaEnlazada<>();

        // 2. Agregar 5 tareas con distintas prioridades y estados
        gestor.agregarTarea(new Tarea("Diseñar BD",        2, "pendiente"));
        gestor.agregarTarea(new Tarea("Deploy produccion", 1, "pendiente"));
        gestor.agregarTarea(new Tarea("Documentar API",    3, "completada"));
        gestor.agregarTarea(new Tarea("Code review",       2, "pendiente"));
        gestor.agregarTarea(new Tarea("Corregir bug #42",  1, "completada"));

        // 3. Eliminar una tarea existente
        gestor.eliminarTarea(new Tarea("Code review", 2, "pendiente"));
        System.out.println("Tarea 'Code review' eliminada.");

        // 4. Imprimir todas las tareas actuales
        System.out.println("\nTareas pendientes:");
        gestor.imprimirTareas();

        // 5. Verificar si cierta tarea existe
        boolean existe = gestor.contieneTarea(new Tarea("Diseñar BD", 2, "pendiente"));
        System.out.println("\n¿Existe 'Diseñar BD'? " + (existe ? "Sí" : "No"));

        // 6. Obtener e imprimir la tarea más prioritaria
        Tarea masPrioritaria = gestor.obtenerTareaMasPrioritaria();
        System.out.println("\nMás prioritaria: " + 
            (masPrioritaria != null ? masPrioritaria : "No hay tareas."));

        // 7. Invertir la lista e imprimirla
        gestor.invertirTareas();
        System.out.println("\nTareas en orden invertido:");
        gestor.imprimirTareas();

        // 8. Transferir tareas completadas a la segunda lista
        // Recorremos con un arreglo auxiliar para no modificar la lista mientras iteramos
        Tarea[] aux = new Tarea[gestor.contarTareas()];
        int i = 0;
        Nodo_act<Tarea> actual = gestor.getCabeza();
        while (actual != null) {
            aux[i++] = actual.dat;
            actual = actual.siguiente;
        }

        for (Tarea t : aux) {
            if (t != null && t.getEstado().equals("completada")) {
                gestor.eliminarTarea(t);
                tareasCompletadas.agregar(t);
            }
        }

        System.out.println("\nTareas pendientes (sin completadas):");
        gestor.imprimirTareas();

        System.out.println("\nTareas completadas:");
        tareasCompletadas.imprimir();
    }
}
