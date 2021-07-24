package gpjl.gui;

public class Orientation {

    public static final byte VERTICAL = 1;
    public static final byte HORIZONTAL = 2;
    public static final byte BOTH = VERTICAL | HORIZONTAL;

    public static boolean isValid(byte orientation) {
        return isVertical(orientation) ^ isHorizontal(orientation);
    }

    public static boolean isVertical(byte orientation) {
        return (orientation & VERTICAL) == VERTICAL;
    }

    public static boolean isHorizontal(byte orientation) {
        return (orientation & HORIZONTAL) == HORIZONTAL;
    }
    
}
