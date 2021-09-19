package gpjl.gui;

import java.awt.Color;

import javax.swing.ButtonModel;
import javax.swing.JButton;

public final class GButtonConfiguration {

    public final Runnable onClick;
    public Color textColor, backgroundColor, backgroundColorHover, backgroundColorPressed;

    public GButtonConfiguration(Runnable onClick, Color textColor, Color backgroundColor) {
        this.onClick = onClick;
        this.textColor = textColor;
        this.backgroundColor = backgroundColorHover = backgroundColorPressed = backgroundColor;
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
