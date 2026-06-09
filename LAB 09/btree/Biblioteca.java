package btree;

import java.io.*;

public class Biblioteca {

    private BTree<Libro> arbol;

    public Biblioteca(int orden) {
        arbol = new BTree<>(orden);
    }

    public void agregarLibro(
            Libro libro) {

        arbol.insert(libro);
    }

    public void buscarPorISBN(
            String isbn) {

        Libro temp =
                new Libro(
                        isbn,
                        "",
                        "",
                        0);

        arbol.search(temp);
    }

    public void eliminarLibro(
            String isbn) {

        Libro temp =
                new Libro(
                        isbn,
                        "",
                        "",
                        0);

        arbol.remove(temp);
    }

    public void mostrarTodos() {

        arbol.searchRange(
                new Libro("0000000000000","", "",0),
                new Libro("9999999999999","", "",0));
    }

    public void cargarDesdeArchivo(
            String archivo)
            throws IOException {

        BufferedReader br =
                new BufferedReader(
                        new FileReader(archivo));

        int orden =
                Integer.parseInt(
                        br.readLine());

        this.arbol =
                new BTree<>(orden);

        String linea;

        while ((linea =
                br.readLine()) != null) {

            String[] p =
                    linea.split(",");

            agregarLibro(
                    new Libro(
                            p[0],
                            p[1],
                            p[2],
                            Integer.parseInt(p[3])));
        }

        br.close();
    }
}