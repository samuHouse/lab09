package it.unibo.mvc;

import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final PrintStream LOG = System.out;
    private List<String> history = new ArrayList<>();
    private String currentMsg;

    @Override
    public void printOnStdout() {
        LOG.println(currentMsg);
    }

    /**
     * A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced
     * @param data is the message to be set
     */
    public void setNextMessage (final String data) {
        this.currentMsg = data;
        this.history.add(this.currentMsg);
    }

    /**
     * A method for getting the next string to print
     * @return the message
     */
    public String getNextMessage () {
        return this.currentMsg;
    }

    /**
     * A method for getting the history of the printed strings (in form of a `List` of `Strings`)
     * @return the List of the printed Strings starting from the oldest to the newest one
     */
    public List<String> getHistory () {
        return new ArrayList<String>(this.history);
    }
    
    /**
     * A method that prints the current string.
     * If the current string is unset, an `IllegalStateException` should be thrown
     */
    public void printMessage () throws IllegalStateException {
        if (this.currentMsg == null) {
            throw new IllegalStateException("The current message is unset");
        }
        printOnStdout();
    }

}
