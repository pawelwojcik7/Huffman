

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {





    public static void main(String[] args) {
        Huffman huffman=new Huffman();
        JFrame frame = new JFrame("HuffmanCalculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Widok widok = new Widok();
        frame.getContentPane().add(widok);
        frame.setPreferredSize(new Dimension(600,650));
        frame.pack();
        frame.setVisible(true);
        //frame.setResizable(true);
        huffman.calculate();
    }
}