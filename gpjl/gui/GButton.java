package gpjl.gui;

import javax.swing.JButton;

public class GButton extends GComponent {

    private final JButton button;
    private GButtonConfiguration buttonConfiguration;

    public GButton(String text, GButtonConfiguration buttonConfig, Size width, Size height, Margin margin, Gravity gravity) {
        super(new JButton(text), width, height, margin, gravity);
        button = (JButton) component;
        buttonConfiguration = buttonConfig;
        applyConfig();
    }

    private void applyConfig() {
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setForeground(buttonConfiguration.textColor);
        button.setBackground(buttonConfiguration.backgroundColor);
        button.addActionListener(e -> buttonConfiguration.onClick.run());
        button.addChangeListener(e -> buttonConfiguration.setBackground(button));
    }

    public GButtonConfiguration getConfig() {
        return buttonConfiguration;
    }

    @Override
    public void setBounds() {
        super.setBounds();
    }
    
}
