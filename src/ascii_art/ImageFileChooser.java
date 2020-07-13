package ascii_art;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class ImageFileChooser extends JPanel{
    private final JFileChooser fc;
    JLabel textField;
    JButton openFileButton, quitButton;

    public ImageFileChooser(){
        this.fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        setLayout(new GridLayout(0,1));

        textField = new JLabel("Select an image file", SwingConstants.CENTER);
        add(textField);

        add(new BottomPanel());

    }

    private class BottomPanel extends JPanel{
        private BottomPanel(){
            setLayout(new FlowLayout());

            openFileButton = new JButton("Open file");
            openFileButton.addActionListener(new OpenFileButtonActionListener());
            add(openFileButton);

            quitButton = new JButton("Quit");
            quitButton.addActionListener(new QuitButtonActionListener());
            add(quitButton);
        }
    }

    private class QuitButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }

    private class OpenFileButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // Open the file chooser panel, check if file is chosen, then get the file
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION){
                File file = fc.getSelectedFile();
                BufferedImage image;
                // Check if file is image
                try{
                    image = ImageIO.read(file);
                    if (image == null){
                        throw new IOException();
                    }
                    // If the file is an image, process it in a new thread
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error reading image");
                }
            }
        }
    }
}
