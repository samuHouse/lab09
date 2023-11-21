package it.unibo.mvc;

/**
 * it must model a simple controller responsible of I/O access.
 * It considers only the standard output, and it is able to print on it.
 */
public interface Controller {

    /**
     * Prints on the standard output the current message
     */
    public void printOnStdout ();


}
