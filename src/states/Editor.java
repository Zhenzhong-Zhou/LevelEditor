package states;

import gui.ToolBar;
import levels.LevelManager;
import main.Scene;
import tiles.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static utilities.Constant.GUI.ToolBar.BAR_WIDTH;
import static utilities.Constant.GUI.ToolBar.X_SELECTED_TILE;
import static utilities.Constant.SceneConstant.*;

public class Editor extends State implements StateMethods {
    private final ToolBar toolBar;
    private final LevelManager levelManager;
    private Tile selectedTile;
    private int mouseX, mouseY;
    private int lastTileX, lastTileY, lastTileId;
    private boolean drawSelected;

    public Editor(Scene scene) {
        super(scene);
        levelManager = new LevelManager(scene);
        toolBar = new ToolBar(SCENE_WIDTH, 0, BAR_WIDTH, SCENE_HEIGHT, this);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        levelManager.draw(graphics2D);
        toolBar.draw(graphics2D);
        drawSelectedTile(graphics2D);
    }

    private void drawSelectedTile(Graphics2D graphics2D) {
        if(selectedTile != null && drawSelected) {
            graphics2D.drawImage(selectedTile.getSprite(), mouseX, mouseY, TILE_SIZE, TILE_SIZE, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() >= SCENE_WIDTH) {
            toolBar.mouseClicked(e);
        } else {
            changeTile(mouseX, mouseY);
        }
    }

    private void changeTile(int mouseX, int mouseY) {
        if(selectedTile != null) {
            int tileX = mouseX / TILE_SIZE;
            int tileY = mouseY / TILE_SIZE;

            if(lastTileX == tileX && lastTileY == tileY && lastTileId == selectedTile.getTileId()) return;
            lastTileX = tileX;
            lastTileY = tileY;
            levelManager.getTileId()[tileX][tileY] = selectedTile.getTileId();
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getX() >= SCENE_WIDTH) {
            toolBar.mouseReleased(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getX() >= SCENE_WIDTH) {
            toolBar.mouseReleased(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getX() >= SCENE_WIDTH - X_SELECTED_TILE) {
            toolBar.mouseMoved(e);
            drawSelected = false;
        } else {
            mouseX = (e.getX() / TILE_SIZE) * TILE_SIZE;
            mouseY = (e.getY() / TILE_SIZE) * TILE_SIZE;
            drawSelected = true;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getX() >= SCENE_WIDTH) {
            toolBar.mouseDragged(e);
        } else {
            changeTile(e.getX(), e.getY());
        }
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

    public void setSelectedTile(Tile selectedTile) {
        this.selectedTile = selectedTile;
        drawSelected = true;
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }
}
