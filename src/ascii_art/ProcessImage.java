package ascii_art;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ProcessImage extends SwingWorker<Void, Void> {
    private BufferedImage image;
    private MyImage myImage;
    private double scaleFactor;

    public ProcessImage(BufferedImage image, double scaleFactor){
        this.image = image;
        this.scaleFactor = scaleFactor;
    }

    @Override
    protected Void doInBackground() {
        this.myImage = new MyImage(image, scaleFactor);
        return null;
    }
}
