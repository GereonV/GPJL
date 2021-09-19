package gpjl.gui;

import java.awt.Color;

import javax.swing.ButtonModel;
import javax.swing.JButton;

public final class GButtonConfiguration extends GConfiguration {

    public final Runnable onClick;
    public Color backgroundColorHover, backgroundColorPressed;

    public GButtonConfiguration(Runnable onClick) {
        super();
        this.onClick = onClick;
        backgroundColorHover = backgroundColorPressed = backgroundColor;
    }

    public GButtonConfiguration(Runnable onClick, Color backgroundColor) {
        super(backgroundColor);
        this.onClick = onClick;
        backgroundColorHover = backgroundColorPressed = backgroundColor;
    }

    public GButtonConfiguration(Runnable onClick, Color textColor, Color backgroundColor) {
        super(textColor, backgroundColor);
        this.onClick = onClick;
        backgroundColorHover = backgroundColorPressed = backgroundColor;
    }

    public GButtonConfiguration(Runnable onClick, Color textColor, Color backgroundColor, Color backgroundColorHover, Color backgroundColorPressed) {
        super(textColor, backgroundColor);
        this.onClick = onClick;
        this.backgroundColorHover = backgroundColorHover;
        this.backgroundColorPressed = backgroundColorPressed;
    }

    public void setBackground(JButton button) {
        ButtonModel model = button.getModel();
        if(model.isPressed())
            button.setBackground(backgroundColorPressed);
        else if(model.isRollover())
            button.setBackground(backgroundColorHover);
        else
            button.setBackground(backgroundColor);
    }
    
}
