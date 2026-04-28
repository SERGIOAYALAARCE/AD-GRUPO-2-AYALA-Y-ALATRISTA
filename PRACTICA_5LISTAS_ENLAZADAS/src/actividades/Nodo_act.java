package actividades;
public class Nodo_act<T> {
    T dat; //Dato que se va a almacenar en el nodo
    Nodo_act<T> siguiente; //Referencia al siguiente nodo

    public Nodo_act(T dat){
        this.dat = dat;
        this.siguiente = null;
    }
}
