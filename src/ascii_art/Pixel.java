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
}
