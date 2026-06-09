package btree;

public class BTree<E extends Comparable<E>> {

    private BNode<E> root;
    private int orden;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public void insert(E cl) {
        System.out.println("Insertando: " + cl);
    }

    public boolean search(E cl) {
        System.out.println("Buscando: " + cl);
        return false;
    }

    public void searchRange(E min, E max) {
        System.out.println("Rango: " + min + " - " + max);
    }

    public void remove(E cl) {
        System.out.println("Eliminando: " + cl);
    }

    @Override
    public String toString() {
        return "BTree";
    }
}