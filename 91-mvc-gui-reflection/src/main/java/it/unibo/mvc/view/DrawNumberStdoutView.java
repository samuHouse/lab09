package it.unibo.mvc.view;

import java.io.PrintStream;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdoutView implements DrawNumberView {

    private DrawNumberController controller;
    private final PrintStream LOG = System.out;

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
        LOG.println("... Waiting for a guess ...\n");
    }

    @Override
    public void result(DrawResult res) {
        LOG.println(res.getDescription());
    }
    
}
