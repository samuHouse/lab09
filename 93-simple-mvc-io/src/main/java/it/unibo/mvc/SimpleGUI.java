package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    static final int PROPORTION = 5;
    private final String TITLE = "Simple GUI";
    private final String SAVE = "Save";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();

    public SimpleGUI() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel pane = new JPanel(new BorderLayout());
        final JTextArea txtArea = new JTextArea();
        final JButton saveBtn = new JButton(SAVE);
        pane.add(txtArea, BorderLayout.CENTER);
        pane.add(saveBtn, BorderLayout.SOUTH);
        frame.setContentPane(pane);
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.writeOnFile(txtArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGUI myGUI = new SimpleGUI();
        myGUI.display();
    }
}
