package inputs;

import main.Scene;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static states.GameState.gameState;

public class KeyInputs implements KeyListener {
    private final Scene scene;

    public KeyInputs(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(gameState) {
            case MENU -> scene.getMenu().keyPressed(e);
            case EDITOR -> scene.getEditor().keyPressed(e);
            case OPTIONS -> scene.getOptions().keyPressed(e);
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(gameState) {
            case MENU -> scene.getMenu().keyReleased(e);
            case EDITOR -> scene.getEditor().keyReleased(e);
            case OPTIONS -> scene.getOptions().keyReleased(e);
            default -> {
            }
        }
    }
}
