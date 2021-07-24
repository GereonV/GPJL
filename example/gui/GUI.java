package example.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import gpjl.gui.GComponent;
import gpjl.gui.GFrame;
import gpjl.gui.Gravity;
import gpjl.gui.LinearLayout;
import gpjl.gui.Margin;
import gpjl.gui.Orientation;
import gpjl.gui.Size;

public class GUI {

    public static GFrame gFrame;

    public static void main(String[] args) throws InterruptedException {
        gFrame = new GFrame("Test-GUI", 1080, 720, GFrame.EXIT_ON_CLOSE);
        gFrame.setRootLayout(new LinearLayout(Orientation.VERTICAL));

        GComponent panel = new GComponent(new JPanel(), Size.MATCH_PARENT, Size.MATCH_PARENT, new Margin(50, 100, 50, 100), Gravity.CENTER);
        panel.setSize(0, 500);
        panel.layout = new LinearLayout(Orientation.HORIZONTAL);

        GComponent button1 = new GComponent(new JButton("1"), Size.MATCH_PARENT, Size.MATCH_PARENT, Margin.zero, Gravity.CENTER);
        button1.setSize(50, 0);
        panel.add(button1);
        GComponent button2 = new GComponent(new JButton("2"), Size.MATCH_PARENT, Size.MATCH_PARENT, Margin.zero, Gravity.CENTER);
        button2.setSize(50, 0);
        panel.add(button2);

        gFrame.add(panel);

        GComponent button = new GComponent(new JButton("Test"), Size.UNCHANGED, Size.UNCHANGED, new Margin(0, 50, 50, 50), Gravity.CENTER);
        button.setSize(500, 250);
        gFrame.add(button);
    }
    
}
