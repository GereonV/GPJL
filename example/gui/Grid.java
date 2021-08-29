package example.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gpjl.gui.GComponent;
import gpjl.gui.GFrame;
import gpjl.gui.Gravity;
import gpjl.gui.LinearLayout;
import gpjl.gui.Margin;
import gpjl.gui.Orientation;
import gpjl.gui.Size;

public class Grid {

    private static int count;
    private static GComponent root;
    private static GComponent[] rows;

    public static void main(String[] args) {
        GFrame frame = new GFrame("Grid-Test", 1080, 720, GFrame.EXIT_ON_CLOSE);
        frame.setRootLayout(new LinearLayout(Orientation.VERTICAL));

        root = new GComponent(new JPanel(null), Size.UNCHANGED, Size.UNCHANGED, new Margin(10, 0, 10, 0), Gravity.CENTER);
        root.layout = new LinearLayout(Orientation.VERTICAL);
        frame.add(root);

        rows = new GComponent[5];
        for(int i = 0; i < 5; i++) {
            rows[i] = new GComponent(new JPanel(null), Size.MATCH_PARENT, Size.MATCH_PARENT, Margin.zero, Gravity.TOP);
            rows[i].layout = new LinearLayout(Orientation.HORIZONTAL);
            for(int j = 0; j < 5; j++) {
                GComponent comp = new GComponent(new JLabel(), Size.MATCH_PARENT, Size.MATCH_PARENT, Margin.zero, Gravity.START);
                comp.component.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                rows[i].add(comp);
            }
            root.add(rows[i]);
        }

        frame.setPreRenderAction(() -> {
            Dimension dimens = frame.getSpace();
            int size = Math.min(dimens.width, dimens.height - 20);
            root.setSize(size, size);
            count++;
            for(int y = 0; y < 5; y++) {
                for(int x = 0; x < 5; x++) {
                    JLabel label = (JLabel) rows[y].layout.get(x).component;
                    label.setText("(" + x + "|" + y + "): " + count);
                }
            }
        });

    }
    
}
