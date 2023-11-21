package it.unibo.mvc;

import java.util.List;

/**
 * it must model a simple controller responsible of I/O access.
 * It considers only the standard output, and it is able to print on it.
 */
public interface Controller {

    /**
     * A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced
     * @param data is the message to be set
     */
    public void setNextMessage (String data);

    /**
     * A method for getting the next string to print
     * @return the message
     */
    public String getNextMessage ();

    /**
     * A method for getting the history of the printed strings (in form of a `List` of `Strings`)
     * @return the List of the printed Strings starting from the oldest to the newest one
     */
    public List<String> getHistory ();
    
    /**
     * A method that prints the current string.
     * If the current string is unset, an `IllegalStateException` should be thrown
     */
    public void printMessage ();

}
