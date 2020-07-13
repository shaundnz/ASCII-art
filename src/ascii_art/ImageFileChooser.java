package ascii_art;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageFileChooser extends JPanel{
    private final JFileChooser fc;
    JLabel headingLabel, scaleFactorLabel;
    JButton openFileButton, quitButton;
    JSlider scaleFactorSlider;

    public ImageFileChooser(){
        this.fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        setLayout(new GridLayout(3,0));

        headingLabel = new JLabel("Select an image file", SwingConstants.CENTER);
        add(headingLabel);
        add(new BottomPanel());
        add(new ScaleFactorPanel());
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

    private class ScaleFactorPanel extends JPanel{
        private ScaleFactorPanel(){
            setLayout(new FlowLayout());

            scaleFactorSlider = new JSlider();
            scaleFactorSlider.setValue(100);
            scaleFactorSlider.setMinimum(10);
            scaleFactorSlider.setMaximum(100);
            scaleFactorSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent changeEvent) {
                    scaleFactorLabel.setText("Scale Factor: " + scaleFactorSlider.getValue() + "%");
                }
            });

            scaleFactorLabel = new JLabel("Scale Factor: " + scaleFactorSlider.getValue() + "%");

            add(scaleFactorLabel);
            add(scaleFactorSlider);
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

                    // If the file is an image, process it in a new thread then print output to console
                    ProcessImage processImage = new ProcessImage(image, (double) scaleFactorSlider.getValue() / 100);
                    processImage.execute();

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error reading image");
                }
            }
        }
    }
}
