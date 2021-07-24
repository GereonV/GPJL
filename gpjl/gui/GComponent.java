package gpjl.gui;

import java.awt.Dimension;

import javax.swing.JComponent;

public class GComponent {

    public final JComponent component;
    public Layout layout;
    public Dimension preferedSize;
    public Size width, height;
    public Margin margin;
    public Gravity gravity;

    public GComponent(JComponent component, Size width, Size height, Margin margin, Gravity gravity) {
        this.component = component;
        preferedSize = component.getSize();
        this.width = width;
        this.height = height;
        this.margin = margin;
        this.gravity = gravity;
    }

    public void add(GComponent gComponent) {
        component.add(gComponent.component);
        if(layout != null)
            layout.add(gComponent);
    }

    public void setBounds() {
        if(layout != null)
            layout.setBounds(component);
    }

    public void setSize(int width, int height) {
        setSize(new Dimension(width, height));
    }

    public void setSize(Dimension d) {
        preferedSize = d;
        setBounds();
    }
    
}
