package gpjl.gui;

import java.awt.Insets;

public class Margin extends Insets {

    public static final Margin zero = new Margin(0, 0, 0, 0);

    public Margin(int top, int left, int bottom, int right) {
        super(top, left, bottom, right);
    }

    public int getHorizontal() {
        return left + right;
    }

    public int getVertical() {
        return top + bottom;
    }
    
}
