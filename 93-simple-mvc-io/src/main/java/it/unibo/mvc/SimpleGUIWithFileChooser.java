package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser{

    private final int PROPORTION = 5;
    private final String TITLE = "Simple GUI with File chooser";
    private final String SAVE = "Save";
    private final String BROSWE = "Browse...";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel pane = new JPanel(new BorderLayout());
        final JTextArea txtArea = new JTextArea();
        final JButton saveBtn = new JButton(SAVE);
        pane.add(txtArea, BorderLayout.CENTER);
        pane.add(saveBtn, BorderLayout.SOUTH);
        frame.setContentPane(pane);
        final JTextField txtField = new JTextField();
        txtField.setEditable(false);
        txtField.setText(controller.getCurrentFile());
        final JButton brosweBtn = new JButton(BROSWE);
        final JPanel upper = new JPanel(new BorderLayout());
        upper.add(brosweBtn, BorderLayout.LINE_END);
        upper.add(txtField, BorderLayout.CENTER);
        pane.add(upper,BorderLayout.NORTH);
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
        brosweBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fChooser = new JFileChooser();
                if (fChooser.showSaveDialog(brosweBtn) == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFIle(fChooser.getSelectedFile());
                    txtField.setText(fChooser.getSelectedFile().toString());
                } else if (fChooser.showSaveDialog(brosweBtn) != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(brosweBtn, "Error occurred");
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
        SimpleGUIWithFileChooser myGUI = new SimpleGUIWithFileChooser();
        myGUI.display();
    }


}
