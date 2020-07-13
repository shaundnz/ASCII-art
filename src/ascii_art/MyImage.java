package ascii_art;


import java.awt.*;
import java.awt.image.BufferedImage;

public class MyImage {

    private BufferedImage image;
    private int width, height;
    private double scaleFactor;
    private Pixel[][] pixelArray;

    public MyImage(BufferedImage image, double scaleFactor){
        this.scaleFactor = scaleFactor;
        createResizedImage(image);
        generatePixelArray();
    }

    private void createResizedImage(BufferedImage image){
        this.width = (int) Math.round(image.getWidth() * scaleFactor);
        this.height = (int) Math.round(image.getHeight() * scaleFactor);
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    private void generatePixelArray(){
        this.pixelArray = new Pixel[width][height];
        for (int x = 0; x < width; x ++){
            for (int y = 0; y < width; y ++){
                Color color = new Color(image.getRGB(x, y));
                pixelArray[x][y] = new Pixel(color.getRed(), color.getGreen(), color.getBlue());
            }
        }
    }
}
