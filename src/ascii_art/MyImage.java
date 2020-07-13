package ascii_art;


import java.awt.*;
import java.awt.image.BufferedImage;

public class MyImage {

    private BufferedImage image;
    private int width;
    private int height;
    private Pixel[][] pixelArray;

    public MyImage(BufferedImage image){
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.pixelArray = new Pixel[width][height];
        generatePixelArray();
    }

    private void generatePixelArray(){
        for (int x = 0; x < width; x ++){
            for (int y = 0; y < width; y ++){
                Color color = new Color(image.getRGB(x, y));
                pixelArray[x][y] = new Pixel(color.getRed(), color.getGreen(), color.getBlue());
            }
        }
    }
}
