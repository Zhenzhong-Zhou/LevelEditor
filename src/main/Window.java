package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Window extends JFrame {
    private Scene scene;

    public Window(Scene scene) {
        setTitle("Tile Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(scene);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                scene.windowFocusLost();
            }
        });
    }
}
