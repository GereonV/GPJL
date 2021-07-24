package gpjl.gui;

public enum Gravity {

    TOP(Orientation.VERTICAL),
    BOTTOM(Orientation.VERTICAL),
    START(Orientation.HORIZONTAL),
    END(Orientation.HORIZONTAL),
    CENTER(Orientation.BOTH);

    public final byte orientation;

    Gravity(byte orientation) {
        this.orientation = orientation;
    }

}
