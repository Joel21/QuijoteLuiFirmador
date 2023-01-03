package dev.mestizos.signer.exception;

public class InvalidCertificateException extends RuntimeException {

    public InvalidCertificateException(String cause) {
        super(cause);
    }
}