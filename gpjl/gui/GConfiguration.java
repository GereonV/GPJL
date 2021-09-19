package gpjl.gui;

import java.awt.Color;

public class GConfiguration {

    private static final Color DEFAULT_COLOR = Color.BLACK;

    public Color textColor, backgroundColor;

    public GConfiguration() {
        textColor = backgroundColor = DEFAULT_COLOR;
    }

    public GConfiguration(Color backgroundColor) {
        textColor = DEFAULT_COLOR;
        this.backgroundColor = backgroundColor;
    }

    public GConfiguration(Color textColor, Color backgroundColor) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }
    
}
