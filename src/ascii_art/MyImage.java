package ascii_art;


import java.awt.*;
import java.awt.image.BufferedImage;

public class MyImage {

    private BufferedImage scaledImage;
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
        this.scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
    }

    private void generatePixelArray(){
        this.pixelArray = new Pixel[width][height];
        for (int x = 0; x < width; x ++){
            for (int y = 0; y < height; y ++){
                Color color = new Color(scaledImage.getRGB(x, y));
                pixelArray[x][y] = new Pixel(color.getRed(), color.getGreen(), color.getBlue());
            }
        }
    }

    public void printToConsole(){
        for (int y = 0; y < height; y ++) {
            for (int x = 0; x < width; x++) {
                System.out.print(pixelArray[x][y].getCharToPrint());
            }
            System.out.print("\n");
        }
    }
}
