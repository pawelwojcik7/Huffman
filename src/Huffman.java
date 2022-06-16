// Huffman Coding in Java

import java.util.List;
import java.util.PriorityQueue;


public class Huffman {

    static TextManipulator tm;

    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {

            System.out.println(root.c + "   |  " + s);
            for (int i = 0; i < tm.uniqueList.size(); i++) {


                if (tm.tab[i][1].equals(root.c)) {
                    tm.tab[i][4] = String.valueOf(s);

                }
            }

            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public Huffman(TextManipulator textManipulator) {
        this.tm = textManipulator;
    }

    ;

    public static void calculate() {
        int n = tm.uniqueList.size();
        List<Character> charArray = tm.uniqueList;
        List<Integer> charfreq = tm.occurrencesList;

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray.get(i).toString();
            hn.item = charfreq.get(i);

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;
        while (q.size() > 1) {

            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.item = x.item + y.item;
            f.c = "-";

                f.left = x;
                f.right = y;

            root = f;

            q.add(f);
        }
        System.out.println(" Char | Huffman code ");
        System.out.println("--------------------");
        printCode(root, "");
    }
}
