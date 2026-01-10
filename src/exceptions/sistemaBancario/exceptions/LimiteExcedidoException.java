package exceptions.sistemaBancario.exceptions;

public class LimiteExcedidoException extends RuntimeException {
    public LimiteExcedidoException(String message) {
        super(message);
    }
}
