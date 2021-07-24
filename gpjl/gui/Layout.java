package gpjl.gui;

import java.awt.Component;
import java.util.ArrayList;

public abstract class Layout extends ArrayList<GComponent> {

    public Layout() {
        super();
    }

    public abstract void setBounds(Component parent);
    
}
