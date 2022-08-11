package states;

import levels.LevelManager;
import main.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Editor extends State implements StateMethods{
    private LevelManager levelManager;

    public Editor(Scene scene) {
        super(scene);
        levelManager = new LevelManager(scene);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(100, 100, 100, 100);
        levelManager.draw(graphics2D);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
//            case KeyEvent.VK_W -> zoomInOut(1);
//            case KeyEvent.VK_D -> zoomInOut(-1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
