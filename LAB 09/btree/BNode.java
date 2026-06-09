package btree;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {

    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    private static int nodeCounter = 0;
    protected int idNode;

    public BNode(int n) {

        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n);

        this.count = 0;
        this.idNode = ++nodeCounter;

        for (int i = 0; i < n; i++) {
            keys.add(null);
            childs.add(null);
        }
    }

    public static void resetCounter() {
        nodeCounter = 0;
    }

    public boolean nodeFull(int n) {
        return count == n;
    }

    public boolean nodeEmpty() {
        return count == 0;
    }

    public boolean searchNode(E cl, int[] pos) {

        int i = 0;

        while (i < count &&
                keys.get(i).compareTo(cl) < 0)
            i++;

        if (i < count &&
                keys.get(i).compareTo(cl) == 0) {

            pos[0] = i;
            return true;
        }

        pos[0] = i;
        return false;
    }

    public boolean isLeaf() {
        return childs.get(0) == null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("[id=").append(idNode).append("] ");

        for (int i = 0; i < count; i++) {

            sb.append(keys.get(i));

            if (i < count - 1)
                sb.append(", ");
        }

        return sb.toString();
    }
}