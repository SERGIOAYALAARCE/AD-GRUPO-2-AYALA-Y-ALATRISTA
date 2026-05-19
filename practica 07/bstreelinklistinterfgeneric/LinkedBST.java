package bstreelinklistinterfgeneric;

import exceptions.*;
import bstreeInterface.BinarySearchTree;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this(data, null, null);
        }
        public Node(E data, Node left, Node right) {
            this.data  = data;
            this.left  = left;
            this.right = right;
        }
    }

    protected Node root;

    public LinkedBST() {
        this.root = null;
    }

    // ══════════════════════════════════
    // ACTIVIDAD 6 – Operaciones básicas
    // ══════════════════════════════════

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node actual, E data) throws ItemDuplicated {
        if (actual == null) return new Node(data);
        int cmp = data.compareTo(actual.data);
        if      (cmp < 0) actual.left  = insert(actual.left,  data);
        else if (cmp > 0) actual.right = insert(actual.right, data);
        else throw new ItemDuplicated("Elemento duplicado: " + data);
        return actual;
    }

    @Override
    public E search(E data) throws ItemNoFound {
        return search(root, data);
    }

    private E search(Node actual, E data) throws ItemNoFound {
        if (actual == null) throw new ItemNoFound("Elemento no encontrado: " + data);
        int cmp = data.compareTo(actual.data);
        if      (cmp < 0) return search(actual.left,  data);
        else if (cmp > 0) return search(actual.right, data);
        else              return actual.data;
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty("El árbol está vacío");
        root = delete(root, data);
    }

    private Node delete(Node actual, E data) {
        if (actual == null) return null;
        int cmp = data.compareTo(actual.data);
        if      (cmp < 0) actual.left  = delete(actual.left,  data);
        else if (cmp > 0) actual.right = delete(actual.right, data);
        else {
            if (actual.left == null && actual.right == null) return null;
            if (actual.left  == null) return actual.right;
            if (actual.right == null) return actual.left;
            E min = findMinValue(actual.right);
            actual.data  = min;
            actual.right = delete(actual.right, min);
        }
        return actual;
    }

    private E findMinValue(Node actual) {
        while (actual.left != null) actual = actual.left;
        return actual.data;
    }

    @Override
    public boolean isEmpty() { return root == null; }

    @Override
    public String toString() { return toString(root).trim(); }

    private String toString(Node actual) {
        if (actual == null) return "";
        return toString(actual.left) + actual.data + " " + toString(actual.right);
    }

    // ══════════════════════════════════
    // ACTIVIDAD 7 – Recorrido In-Orden
    // ══════════════════════════════════

    public void recorrerInOrder() { inOrder(root); }

    private void inOrder(Node actual) {
        System.out.println("Recorrer el subárbol izquierdo en in-orden.");
        if (actual == null) { System.out.println("Vacío"); return; }
        inOrder(actual.left);
        System.out.println("Visitar la raíz: " + actual.data);
        System.out.println("Recorrer el subárbol derecho en in-orden.");
        inOrder(actual.right);
    }

    // ══════════════════════════════════
    // ACTIVIDAD 8 – Recorrido Pre-Orden
    // ══════════════════════════════════

    public void recorrerPreOrder() { preOrder(root); }

    private void preOrder(Node actual) {
        if (actual == null) { System.out.println("Vacío"); return; }
        System.out.println("Visitar la raíz: " + actual.data);
        System.out.println("Recorrer el subárbol izquierdo en pre-orden.");
        preOrder(actual.left);
        System.out.println("Recorrer el subárbol derecho en pre-orden.");
        preOrder(actual.right);
    }

    // ═══════════════════════════════════
    // ACTIVIDAD 9 – Recorrido Post-Orden
    // ═══════════════════════════════════

    public void recorrerPostOrder() { postOrder(root); }

    private void postOrder(Node actual) {
        System.out.println("Recorrer el subárbol izquierdo en postorden.");
        if (actual == null) { System.out.println("Vacío"); return; }
        postOrder(actual.left);
        System.out.println("Recorrer el subárbol derecho en postorden.");
        postOrder(actual.right);
        System.out.println("Visitar la raiz: " + actual.data);
    }

    // ══════════════════════════════════════
    // ACTIVIDAD 10 – Mínimo y Máximo
    // ══════════════════════════════════════

    private E findMinNode(Node node) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("Subárbol nulo.");
        Node current = node;
        while (current.left != null) current = current.left;
        return search(current.data);
    }

    private E findMaxNode(Node node) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("Subárbol nulo.");
        Node current = node;
        while (current.right != null) current = current.right;
        return search(current.data);
    }

    public E obtenerMinimoDesde(E data) throws ItemNoFound {
        Node node = buscarNodo(root, data);
        if (node == null) throw new ItemNoFound("No se encontró el nodo: " + data);
        return findMinNode(node);
    }

    public E obtenerMaximoDesde(E data) throws ItemNoFound {
        Node node = buscarNodo(root, data);
        if (node == null) throw new ItemNoFound("No se encontró el nodo: " + data);
        return findMaxNode(node);
    }

    private Node buscarNodo(Node actual, E data) {
        if (actual == null) return null;
        int cmp = data.compareTo(actual.data);
        if      (cmp == 0) return actual;
        else if (cmp  < 0) return buscarNodo(actual.left,  data);
        else               return buscarNodo(actual.right, data);
    }

    // ══════════════════════════════════════
    // EJERCICIO 01-a – destroyNodes()
    // ══════════════════════════════════════

    public void destroyNodes() throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty("El árbol ya está vacío");
        root = null;
    }

    // ══════════════════════════════════════
    // EJERCICIO 01-b – countAllNodes()
    // ══════════════════════════════════════

    public int countAllNodes() { return countAllNodes(root); }

    private int countAllNodes(Node actual) {
        if (actual == null) return 0;
        return 1 + countAllNodes(actual.left) + countAllNodes(actual.right);
    }

    // ══════════════════════════════════════════════
    // EJERCICIO 01-c – countNodes() solo NO-hojas
    // ══════════════════════════════════════════════

    public int countNodes() { return countNodes(root); }

    private int countNodes(Node actual) {
        if (actual == null) return 0;
        if (actual.left == null && actual.right == null) return 0;
        return 1 + countNodes(actual.left) + countNodes(actual.right);
    }

    // ════════════════════════════════════════════
    // EJERCICIO 01-d – height(x)  iterativo + BFS
    // ════════════════════════════════════════════

    public int height(E x) {
        Node actual = root;
        while (actual != null) {
            int cmp = x.compareTo(actual.data);
            if      (cmp < 0) actual = actual.left;
            else if (cmp > 0) actual = actual.right;
            else              break;
        }
        if (actual == null) return -1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(actual);
        int altura = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            altura++;
            for (int i = 0; i < size; i++) {
                Node nodo = queue.poll();
                if (nodo.left  != null) queue.add(nodo.left);
                if (nodo.right != null) queue.add(nodo.right);
            }
        }
        return altura;
    }

    // ══════════════════════════════════════
    // EJERCICIO 01-e – amplitude(level)
    // ══════════════════════════════════════

    public int amplitude(int level) {
        if (root == null) return 0;
        int alturaTotal = height(root.data);
        if (level < 0 || level > alturaTotal) return 0;
        return countNodesAtLevel(root, level);
    }

    private int countNodesAtLevel(Node actual, int nivel) {
        if (actual == null) return 0;
        if (nivel == 0)     return 1;
        return countNodesAtLevel(actual.left,  nivel - 1)
             + countNodesAtLevel(actual.right, nivel - 1);
    }

    // ══════════════════════════════════════════════
    // EJERCICIO 02-a – areaBST()  iterativo
    // ══════════════════════════════════════════════

    public int areaBST() {
        if (root == null) return 0;

        Object[] queue = new Object[1000];
        int front = 0, back = 0;
        queue[back++] = root;
        int hojas = 0, altura = -1;

        while (front < back) {
            int size = back - front;
            altura++;
            for (int i = 0; i < size; i++) {
                Node nodo = (Node) queue[front++];
                if (nodo.left == null && nodo.right == null) hojas++;
                if (nodo.left  != null) queue[back++] = nodo.left;
                if (nodo.right != null) queue[back++] = nodo.right;
            }
        }
        return hojas * altura;
    }

    // ══════════════════════════════════════
    // EJERCICIO 02-b – drawBST()
    // ══════════════════════════════════════

    public void drawBST() {
        if (root == null) { System.out.println("[Árbol vacío]"); return; }
        drawBST(root, 0);
    }

    private void drawBST(Node actual, int nivel) {
        if (actual == null) return;
        drawBST(actual.right, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print("    ");
        System.out.println("[" + actual.data + "]");
        drawBST(actual.left, nivel + 1);
    }

    // ══════════════════════════════════════════════
    // EJERCICIO 03 – parenthesize()  pila manual
    // ══════════════════════════════════════════════

    public void parenthesize() {
        if (root == null) { System.out.println("[Árbol vacío]"); return; }
        Node[] stackNode  = new Node[1000];
        int[]  stackLevel = new int[1000];
        int top = -1;
        stackNode[++top]  = root;
        stackLevel[top]   = 0;
        while (top >= 0) {
            Node actual = stackNode[top];
            int  nivel  = stackLevel[top--];
            for (int i = 0; i < nivel; i++) System.out.print("  ");
            System.out.println(actual.data);
            if (actual.right != null) {
                stackNode[++top]  = actual.right;
                stackLevel[top]   = nivel + 1;
            }
            if (actual.left != null) {
                stackNode[++top]  = actual.left;
                stackLevel[top]   = nivel + 1;
            }
        }
    }

    // ══════════════════════════════════════
    // EJERCICIO 04 – isValidBST()
    // ══════════════════════════════════════

    public boolean isValidBST() { return isValidBST(root, null, null); }

    private boolean isValidBST(Node actual, E min, E max) {
        if (actual == null) return true;
        if (min != null && actual.data.compareTo(min) <= 0) return false;
        if (max != null && actual.data.compareTo(max) >= 0) return false;
        return isValidBST(actual.left,  min,         actual.data)
            && isValidBST(actual.right, actual.data, max);
    }

    // ══════════════════════════════════════
    // EJERCICIO 05-b – searchRange(min, max)
    // ══════════════════════════════════════

    public Object[] searchRange(E min, E max) {
        Object[] resultado = new Object[1000];
        int[]    index     = {0};
        searchRange(root, min, max, resultado, index);
        Object[] recortado = new Object[index[0]];
        for (int i = 0; i < index[0]; i++) recortado[i] = resultado[i];
        return recortado;
    }

    private void searchRange(Node actual, E min, E max, Object[] resultado, int[] index) {
        if (actual == null) return;
        if (actual.data.compareTo(min) > 0)
            searchRange(actual.left,  min, max, resultado, index);
        if (actual.data.compareTo(min) >= 0 && actual.data.compareTo(max) <= 0)
            resultado[index[0]++] = actual.data;
        if (actual.data.compareTo(max) < 0)
            searchRange(actual.right, min, max, resultado, index);
    }

    // ══════════════════════════════════════
    // EJERCICIO 05-c – countLeaves()
    // ══════════════════════════════════════

    public int countLeaves() { return countLeaves(root); }

    private int countLeaves(Node actual) {
        if (actual == null) return 0;
        if (actual.left == null && actual.right == null) return 1;
        return countLeaves(actual.left) + countLeaves(actual.right);
    }

    // ══════════════════════════════════════
    // EJERCICIO 05-d – printDescending()
    // ══════════════════════════════════════

    public void printDescending() {
        System.out.println("Productos en orden descendente:");
        printDescending(root);
        System.out.println();
    }

    private void printDescending(Node actual) {
        if (actual == null) return;
        printDescending(actual.right);
        System.out.print(actual.data + " ");
        printDescending(actual.left);
    }
}