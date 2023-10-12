package util;

public class CaException extends Exception {

    private String detalle;
    private String clase;

    public CaException(String clase, String error) {
        super(error);
        this.clase = clase;
        detalle = error;
    }

    public String toString() {
        return "[" + clase + "] " + detalle;
    }
}
