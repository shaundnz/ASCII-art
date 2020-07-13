package ascii_art;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ImageFileChooser extends JPanel{
    private final JFileChooser fc;
    JLabel textField;
    JButton openFileButton, quitButton;

    public ImageFileChooser(){
        this.fc = new JFileChooser();
        setLayout(new GridLayout(0,1));

        textField = new JLabel("Select an image file", SwingConstants.CENTER);
        add(textField);

        add(new BottomPanel());

    }

    private class BottomPanel extends JPanel{
        private BottomPanel(){
            setLayout(new FlowLayout());

            openFileButton = new JButton("Open file");
            add(openFileButton);

            quitButton = new JButton("Quit");
            add(quitButton);
        }
    }
}
