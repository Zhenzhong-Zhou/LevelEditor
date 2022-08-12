package gui;

import states.Editor;
import states.StateMethods;
import tiles.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static states.GameState.EDITOR;
import static utilities.Constant.GUI.ToolBar.TILE_BUTTON_SIZE;
import static utilities.Constant.GUI.ToolBar.X_OFFSET;
import static utilities.Constant.SceneConstant.SCENE_WIDTH;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class ToolBar implements StateMethods {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Editor editor;
    private final ArrayList<Button> tileButtons = new ArrayList<>();
    private Tile selectedTile;
    private Button save;

    public ToolBar(int x, int y, int width, int height, Editor editor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.editor = editor;
        initButtons();
    }

    private void initButtons() {
        save = new Button(SCENE_WIDTH + 80, 30, 100, 50, "Save", EDITOR);

        ArrayList<Tile> tiles = editor.getLevelManager().getTileManager().getTiles();
        for(int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            tileButtons.add(new Button(SCENE_WIDTH + 10, TILE_BUTTON_SIZE * 2 + X_OFFSET * i, TILE_SIZE, TILE_SIZE, tile.getTileName(), i));
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(220, 123, 15));
        graphics2D.fillRect(x, y, width, height);
        drawButtons(graphics2D);
    }

    private void drawButtons(Graphics2D graphics2D) {
        save.draw(graphics2D);
        drawTileButtons(graphics2D);
        drawSelectedTile(graphics2D);
    }

    private void drawTileButtons(Graphics2D graphics2D) {
        for(Button button : tileButtons) {
            Rectangle bounds = button.getBounds();

            // SPRITE
            graphics2D.drawImage(getButtonImage(button.getId()), bounds.x, bounds.y, bounds.width, bounds.height, null);

            // MOUSE HOVER
            if(button.isMouseHover()) graphics2D.setColor(Color.WHITE);
            else graphics2D.setColor(Color.BLACK);

            // BORDER
            graphics2D.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

            // MOUSE PRESSED
            if(button.isMousePressed()) {
                graphics2D.drawRect(x + 1, y + 1, width - 2, height - 2);
                graphics2D.drawRect(x + 2, y + 2, width - 4, height - 4);
            }
        }
    }

    private void drawSelectedTile(Graphics2D graphics2D) {
        if(selectedTile != null) {
            graphics2D.drawImage(selectedTile.getSprite(), SCENE_WIDTH + 10, 30, TILE_SIZE, TILE_SIZE, null);
            graphics2D.setColor(Color.GREEN);
            graphics2D.drawRect(SCENE_WIDTH + 10, 30, TILE_SIZE, TILE_SIZE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(save.isBound(e, save)) {
            editor.getLevelManager().saveLevel();
        }

        for(Button button : tileButtons) {
            if(button.isBound(e, button)) {
                selectedTile = editor.getLevelManager().getTileManager().getTile(button.getId());
                editor.setSelectedTile(selectedTile);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(save.isBound(e, save)) {
            save.setMousePressed(true);
        }

        for(Button button : tileButtons) {
            if(button.isBound(e, button)) {
                button.setMousePressed(true);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(save.isBound(e, save)) {
            save.restBooleans();
        }

        for(Button button : tileButtons) {
            if(button.isBound(e, button)) {
                button.restBooleans();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        save.setMouseHover(false);
        for(Button button : tileButtons) {
            button.setMouseHover(false);
        }

        if(save.isBound(e, save)) {
            save.setMouseHover(true);
        }

        for(Button button : tileButtons) {
            if(button.isBound(e, button)) {
                button.setMouseHover(true);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private BufferedImage getButtonImage(int id) {
        return editor.getLevelManager().getTileManager().getSprite(id);
    }
}
