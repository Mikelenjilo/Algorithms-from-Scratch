package BinarySearchTree;

import javax.swing.*;
import java.awt.*;

public class BSTVisualizer extends JPanel {

    private static final int NODE_RADIUS = 22;
    private static final int V_GAP = 70;
    private final Node root;

    public BSTVisualizer(Node root) {
        this.root = root;
        setBackground(new Color(245, 245, 250));
    }

    private void drawTree(Graphics2D g, Node node, int x, int y, int spread) {
        if (node == null) return;

        g.setStroke(new BasicStroke(2));

        if (node.left != null) {
            int cx = x - spread, cy = y + V_GAP;
            g.setColor(new Color(100, 130, 200)); // ✅ set before drawing
            g.drawLine(x, y, cx, cy);
            drawTree(g, node.left, cx, cy, spread / 2);
        }
        if (node.right != null) {
            int cx = x + spread, cy = y + V_GAP;
            g.setColor(new Color(100, 130, 200)); // ✅ reset after recursive left call
            g.drawLine(x, y, cx, cy);
            drawTree(g, node.right, cx, cy, spread / 2);
        }

        // Draw node circle
        g.setColor(new Color(70, 110, 210));
        g.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(2));
        g.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

        // Draw value
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 13));
        FontMetrics fm = g.getFontMetrics();
        String text = String.valueOf(node.data);
        g.drawString(text, x - fm.stringWidth(text) / 2, y + fm.getAscent() / 2 - 1);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawTree(g2, root, getWidth() / 2, 50, getWidth() / 4);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        int[] values = {5, 1, 9, 2, 7, 8};
        for (int v : values) bst.insert(new Node(v));

        // Launch the window
        JFrame frame = new JFrame("BST Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.add(new BSTVisualizer(bst.root));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}