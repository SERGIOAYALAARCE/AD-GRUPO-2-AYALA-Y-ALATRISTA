import btree.*;

public class Main {

    public static void main(String[] args)
            throws Exception {

        Biblioteca biblioteca =
                new Biblioteca(4);

        biblioteca.cargarDesdeArchivo(
                "biblioteca.txt");

        System.out.println(
                "BUSCAR ISBN");

        biblioteca.buscarPorISBN(
                "9780132350884");

        System.out.println(
                "\nELIMINAR ISBN");

        biblioteca.eliminarLibro(
                "9780201633610");

        System.out.println(
                "\nMOSTRAR TODOS");

        biblioteca.mostrarTodos();
    }
}