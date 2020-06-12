/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since   29-05-2018
 */
package com.powertamil.exception;

/**
 * Thrown when there is a failure condition due to Invalid Character supplied.
 * This exception is thrown when a class
 * encounters a character specific exception such as invalid data, or characters outside of the expected range.
 */
public class InvalidCharException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with <code>null</code> as its detail message.
     */
    public InvalidCharException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidCharException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     * @param cause   The cause which is saved for later retrieval by the {@link #getCause()} method.
     *                A <code>null</code> indicates that the cause is nonexistent or unknown.
     */
    public InvalidCharException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of
     * <code>(cause==null ? null : cause.toString())</code>
     * (which typically contains the class and detail message of <code>cause</code>).
     * This constructor is useful for exceptions that are little more than wrappers for other throwables.
     *
     * @param cause The cause which is saved for later retrieval by the {@link #getCause()} method.
     *              A <code>null</code> indicates that the cause is nonexistent or unknown.
     */
    public InvalidCharException(final Throwable cause) {
        super(cause);
    }


}
