package inputs;

import main.Scene;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static states.GameState.gameState;

public class MouseInputs implements MouseListener, MouseMotionListener {
    private final Scene scene;

    public MouseInputs(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            switch(gameState) {
                case MENU -> scene.getMenu().mouseClicked(e);
                case EDITOR -> scene.getEditor().mouseClicked(e);
                case OPTIONS -> scene.getOptions().mouseClicked(e);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(gameState) {
            case MENU -> scene.getMenu().mousePressed(e);
            case EDITOR -> scene.getEditor().mousePressed(e);
            case OPTIONS -> scene.getOptions().mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(gameState) {
            case MENU -> scene.getMenu().mouseReleased(e);
            case EDITOR -> scene.getEditor().mouseReleased(e);
            case OPTIONS -> scene.getOptions().mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch(gameState) {
            case MENU -> scene.getMenu().mouseMoved(e);
            case EDITOR -> scene.getEditor().mouseMoved(e);
            case OPTIONS -> scene.getOptions().mouseMoved(e);
        }
    }
}
