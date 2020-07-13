package ascii_art;

public class Pixel {
    private final double red;
    private final double green;
    private final double blue;

    public Pixel(double r, double g, double b){
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    // Getters
    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    // Calculate average brightness of pixel
    public double averageBrightness(){
        return (red + green + blue) / 3;
    }

    // Index of which character from list to print, determined by brightness of pixel
    public int averageToMapIndex(){
        double average = averageBrightness();
        return (int) Math.round((average/255) * 64);
    }

}
