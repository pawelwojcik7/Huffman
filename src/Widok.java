import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import static java.awt.SystemColor.text;

public class Widok extends JPanel implements ActionListener, LayoutManager{

    JPanel panel;
    JButton drzewo;
    JButton oblicz1;
    JButton oblicz2;
    JButton oblicz3;

    JTextField tekst;
    JLabel napis;
    JPanel panel1;
    JPanel panel2;
    JScrollPane panel3;
    JTable table;
    public Widok()
    {
        panel=new JPanel();
        panel.setPreferredSize(new Dimension(580,580));
        panel.setFocusable(true);
        panel.setLayout(new GridLayout(3,1));
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(1,4));
        panel1.setFocusable(true);
        panel2.setFocusable(true);
        panel1.setPreferredSize(new Dimension(580,100));
        panel2.setPreferredSize(new Dimension(580,100));



        napis= new JLabel("Słowo",SwingConstants.CENTER);

        panel1.add(napis);
        tekst = new JTextField(20);
        tekst.addActionListener(this);
        tekst.setEditable(true);
        panel1.add(tekst);

        drzewo= new JButton("Rysuj drzewo");
        panel2.add(drzewo);
        drzewo.addActionListener(this);
        oblicz1=new JButton("Huffman");
        oblicz1.addActionListener(this);
        panel2.add(oblicz1);
        oblicz2=new JButton("FGK");
        oblicz2.addActionListener(this);
        panel2.add(oblicz2);
        oblicz3=new JButton("Vitter");
        oblicz3.addActionListener(this);
        panel2.add(oblicz3);
        String[] columns = {"id","index","char","weight","probability","code"};
        String[][] data= {{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},{"1","1","1","1","1","1"},};
        table = new JTable(data,columns);
        table.setPreferredScrollableViewportSize(new Dimension(450,63));
        table.setFillsViewportHeight(true);
        panel3 = new JScrollPane(table);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Oblicz"))
        {

        }
        if(s.equals("Rysuj drzewo"))
        {

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
