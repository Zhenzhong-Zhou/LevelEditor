package states;

import gui.Button;
import main.Scene;

import java.awt.event.MouseEvent;

public class State {
    protected Scene scene;

    public State(Scene scene) {
        this.scene = scene;
    }

    public boolean isBound(MouseEvent e, Button button) {
        return button.getBounds().contains(e.getX(), e.getY());
    }

    public Scene getScene() {
        return scene;
    }
}
