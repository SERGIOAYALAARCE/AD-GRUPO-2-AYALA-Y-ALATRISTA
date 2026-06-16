package listlinked;

//Nodo simple para la lista enlazada
public class Node {
 public Object data; // dato que guarda el nodo
 public Node next;   // apunta al siguiente nodo

 public Node(Object data) {
     this.data = data;
     this.next = null;
 }
}