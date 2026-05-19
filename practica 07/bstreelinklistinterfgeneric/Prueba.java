package bstreelinklistinterfgeneric;

import exceptions.*;

public class Prueba {

    private static void sep(String titulo) {
        System.out.println("\n" + "=".repeat(55));
        System.out.println("  " + titulo);
        System.out.println("=".repeat(55));
    }

    public static <E extends Comparable<E>> boolean sameArea(
            LinkedBST<E> a1, LinkedBST<E> a2) {
        return a1.areaBST() == a2.areaBST();
    }

    public static void main(String[] args) {

        LinkedBST<Integer> arbol = new LinkedBST<>();
        try {
            arbol.insert(50); arbol.insert(30); arbol.insert(70);
            arbol.insert(20); arbol.insert(40); arbol.insert(60);
            arbol.insert(80);
        } catch (Exception e) { e.printStackTrace(); }

        sep("ACTIVIDAD 6 - insert / search / delete / toString");
        System.out.println("toString: " + arbol);
        try { System.out.println("search(40): " + arbol.search(40)); }
        catch (ItemNoFound e) { System.out.println(e.getMessage()); }
        try { arbol.insert(40); }
        catch (ItemDuplicated e) {
            System.out.println("ItemDuplicated: " + e.getMessage()); }
        try {
            arbol.delete(30);
            System.out.println("Tras delete(30): " + arbol);
            arbol.insert(30);
        } catch (Exception e) { System.out.println(e.getMessage()); }

        sep("ACTIVIDAD 7 - Recorrido In-Orden");
        arbol.recorrerInOrder();

        sep("ACTIVIDAD 8 - Recorrido Pre-Orden");
        arbol.recorrerPreOrder();

        sep("ACTIVIDAD 9 - Recorrido Post-Orden");
        arbol.recorrerPostOrder();

        sep("ACTIVIDAD 10 - Minimo y Maximo");
        try {
            System.out.println("Minimo desde 50: " + arbol.obtenerMinimoDesde(50));
            System.out.println("Maximo desde 50: " + arbol.obtenerMaximoDesde(50));
        } catch (ItemNoFound e) { System.out.println(e.getMessage()); }

        sep("EJERCICIO 01-a - destroyNodes()");
        LinkedBST<Integer> tmp = new LinkedBST<>();
        try {
            tmp.insert(10); tmp.insert(5); tmp.insert(15);
            System.out.println("Antes: " + tmp);
            tmp.destroyNodes();
            System.out.println("Despues isEmpty: " + tmp.isEmpty());
            tmp.destroyNodes();
        } catch (ExceptionIsEmpty e) {
            System.out.println("ExceptionIsEmpty: " + e.getMessage());
        } catch (ItemDuplicated e) { e.printStackTrace(); }

        sep("EJERCICIO 01-b - countAllNodes()");
        System.out.println("Total nodos: " + arbol.countAllNodes());

        sep("EJERCICIO 01-c - countNodes() no-hojas");
        System.out.println("Nodos no-hojas: " + arbol.countNodes());

        sep("EJERCICIO 01-d - height(x)");
        System.out.println("height(50): " + arbol.height(50));
        System.out.println("height(30): " + arbol.height(30));
        System.out.println("height(20): " + arbol.height(20));
        System.out.println("height(99): " + arbol.height(99));

        sep("EJERCICIO 01-e - amplitude(nivel)");
        System.out.println("amplitude(0): " + arbol.amplitude(0));
        System.out.println("amplitude(1): " + arbol.amplitude(1));
        System.out.println("amplitude(2): " + arbol.amplitude(2));

        sep("EJERCICIO 02-a - areaBST()");
        System.out.println("areaBST: " + arbol.areaBST());

        sep("EJERCICIO 02-b - drawBST()");
        arbol.drawBST();

        sep("EJERCICIO 02-c - sameArea()");
        LinkedBST<Integer> arbol2 = new LinkedBST<>();
        try {
            arbol2.insert(10); arbol2.insert(5);  arbol2.insert(15);
            arbol2.insert(3);  arbol2.insert(7);
        } catch (ItemDuplicated e) { e.printStackTrace(); }
        System.out.println("arbol  areaBST: " + arbol.areaBST());
        System.out.println("arbol2 areaBST: " + arbol2.areaBST());
        System.out.println("Misma area: " + sameArea(arbol, arbol2));

        sep("EJERCICIO 03 - parenthesize()");
        arbol.parenthesize();

        sep("EJERCICIO 04 - isValidBST()");
        System.out.println("Es BST valido: " + arbol.isValidBST());

        sep("EJERCICIO 05 - Inventario");
        LinkedBST<Integer> inv = new LinkedBST<>();
        try {
            inv.insert(105); inv.insert(203); inv.insert(47);
            inv.insert(158); inv.insert(312); inv.insert(89);
            inv.insert(271);
        } catch (ItemDuplicated e) { e.printStackTrace(); }
        System.out.println("Inventario: " + inv);
        System.out.print("searchRange(89,271): ");
        for (Object o : inv.searchRange(89, 271)) System.out.print(o + " ");
        System.out.println();
        System.out.println("countLeaves: " + inv.countLeaves());
        inv.printDescending();
    }
}