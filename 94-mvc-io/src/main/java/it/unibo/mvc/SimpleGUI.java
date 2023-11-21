package it.unibo.mvc;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    static final int PROPORTION = 5;
    private static final String TITLE = "mvc-io";
    private final JFrame frame = new JFrame(TITLE);
    private final SimpleController controller = new SimpleController();
    private static final String PRINT = "Print";
    private static final String HISTORY = "Show history";

    
    public SimpleGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel pane = new JPanel(new BorderLayout());
        final JPanel buttons = new JPanel(new BorderLayout());
        final JTextField txtField = new JTextField();
        final JTextArea txtArea = new JTextArea();
        final JButton printBtn = new JButton(PRINT);
        final JButton historyBtn = new JButton(HISTORY);
        pane.add(txtField, BorderLayout.NORTH);
        pane.add(txtArea, BorderLayout.CENTER);
        buttons.add(printBtn, BorderLayout.CENTER);
        buttons.add(historyBtn, BorderLayout.LINE_END);
        frame.setContentPane(pane);
        pane.add(buttons, BorderLayout.SOUTH);

        printBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextMessage(txtField.getText());
                controller.printMessage();
            }
            
        });

        historyBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.setText(controller.getHistory().toString());
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
