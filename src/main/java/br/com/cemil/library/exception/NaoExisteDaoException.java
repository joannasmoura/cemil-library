package br.com.cemil.library.exception;

public class NaoExisteDaoException extends RuntimeException {

    public NaoExisteDaoException(String message) {
        super(message);
    }
}
