import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import static java.awt.SystemColor.text;

public class Widok extends JPanel implements ActionListener, LayoutManager {

    JTextArea tekst1;
    JScrollPane scroll1;
    JLabel napis1;
    JPanel panel;
    JButton drzewo;
    JButton oblicz1;
    JButton oblicz2;
    JButton oblicz3;
    JScrollPane scroll;

    JTextArea tekst;
    JLabel napis;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JScrollPane panel4;
    JTable table;
    String[] columns = {"id", "char", "weight", "probability", "code"};
    String[][] data;

    public Widok() {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(580, 580));
        panel.setFocusable(true);
        panel.setLayout(new GridLayout(4, 1));
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel1.setLayout(new GridLayout(1, 2));
        panel2.setLayout(new GridLayout(1, 2));
        panel3.setLayout(new GridLayout(1, 4));
        panel1.setFocusable(true);
        panel2.setFocusable(true);
        panel3.setFocusable(true);
        panel1.setPreferredSize(new Dimension(580, 750));
        panel2.setPreferredSize(new Dimension(580, 750));
        panel3.setPreferredSize(new Dimension(580, 50));


        napis = new JLabel("Podaj słowo do zakodowania", SwingConstants.CENTER);
        panel1.add(napis);
        tekst = new JTextArea();
        tekst.setEditable(true);
        tekst.setLineWrap(true);
        tekst.setWrapStyleWord(true);
        scroll = new JScrollPane(tekst);
        panel1.add(scroll);

        napis1 = new JLabel("Słowo po zakodowaniu", SwingConstants.CENTER);
        panel2.add(napis1);
        tekst1 = new JTextArea();
        tekst1.setEditable(false);
        tekst1.setLineWrap(true);
        tekst1.setWrapStyleWord(true);
        scroll1 = new JScrollPane(tekst1);
        panel2.add(scroll1);


        drzewo = new JButton("Rysuj drzewo");
        panel3.add(drzewo);
        drzewo.addActionListener(this);
        oblicz1 = new JButton("Huffman");
        oblicz1.addActionListener(this);
        panel3.add(oblicz1);
        oblicz2 = new JButton("FGK");
        oblicz2.addActionListener(this);
        panel3.add(oblicz2);
        oblicz3 = new JButton("Vitter");
        oblicz3.addActionListener(this);
        panel3.add(oblicz3);
        panel4 = new JScrollPane(table);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Huffman") && (tekst.getText() != null || tekst.getText() != "")) {
            panel.remove(panel4);
            String slowo = tekst.getText().toString();
            TextManipulator tm = new TextManipulator(slowo);
            //Huffman hn = new Huffman(tm);
            //hn.calculate();

            Huffman huffman = new Huffman(tm);
            String encodedText = huffman.encode();
            tekst1.setText(encodedText);
            System.out.println(encodedText);

            huffman.printCodes();

            String originalText = huffman.decode(encodedText);
            System.out.println(originalText);
            data = huffman.tm.tab;
            table = new JTable(data, columns);
            table.setPreferredScrollableViewportSize(new Dimension(450, 63));
            table.setFillsViewportHeight(true);
            panel4 = new JScrollPane(table);
            panel.add(panel4);
            panel.revalidate();

        }
        if (s.equals("Rysuj drzewo")) {

        }

    }

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {

    }
}
