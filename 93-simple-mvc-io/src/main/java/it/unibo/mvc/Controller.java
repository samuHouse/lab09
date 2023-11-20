package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final File DEFAULT_FILE = new File(System.getProperty("user.home")
    + System.getProperty("file.separator")
    + "output.txt");
    private File current = DEFAULT_FILE;

    /**
     * A method for setting a File as current file
     * @param filename is the name of the file to consider
     */
    public void setCurrentFIle(File newFile) {
        this.current = newFile;
    }


    /**
     * A method for getting the current File
     * @return the Name of the current file
     */
    public String getCurrentFile() {
        return this.current.getName();
    }


    /**
     * A method for getting the path (in form of String) of the current `File`
     * @return the path
     */
    public String getCurrentPath() {
        return this.current.toString();
    }

    /**
     * A method that gets a `String` as input and saves its content on the current file.
     * @param data the message that has to be written on file
     * @throws IOException
     */
    public void writeOnFile(String data) throws IOException{
        try (PrintStream ps = new PrintStream(getCurrentPath(), StandardCharsets.UTF_8)) {
            ps.println(data);
        } catch (IOException e) {
            throw new IOException("Error");
        }
    }

}
