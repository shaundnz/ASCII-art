package ascii_art;

import javax.swing.*;

public class AsciiArt {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        JFrame frame = new JFrame("Ascii art");
        frame.add(new ImageFileChooser());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
