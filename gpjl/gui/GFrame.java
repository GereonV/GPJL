package gpjl.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GFrame extends JFrame {

    private final GComponent root;
    private Runnable preRender;

    public GFrame(String title, int width, int height, int operation) {
        super(title);
        setLayout(null);
        setVisible(true);
        setSize(width, height);
        setLocationRelativeTo(null);;
        setDefaultCloseOperation(operation);

        root = new GComponent(new JPanel(), null, null, null, null);
        root.component.setLayout(null);
        add(root.component);
    }

    public void add(GComponent gComponent) {
        root.add(gComponent);
    }

    public Dimension getSpace() {
        Dimension size = getSize();
        Insets insets = getInsets();
        size.width -= insets.left - insets.right;
        size.height -= insets.top - insets.bottom;
        return size;
    }

    private void setRoot() {
        Dimension size = getSpace();
        root.component.setBounds(0, 0, size.width, size.height);
    }

    public void setBounds() {
        setRoot();
        root.setBounds();
    }

    public void setRootLayout(Layout layout) {
        root.layout = layout;
    }

    public void setPreRenderAction(Runnable action) {
        preRender = action;
    }

    @Override
    public void paint(Graphics g) {
        if(preRender != null)
            preRender.run();
        setBounds();
        super.paint(g);
    }

}
