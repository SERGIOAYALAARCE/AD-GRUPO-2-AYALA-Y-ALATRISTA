package exceptions;

public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty() {
        super("Está vacío");
    }
    public ExceptionIsEmpty(String mensaje) {
        super(mensaje);
    }
}