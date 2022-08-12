package levels;

import main.Scene;
import tiles.TileManager;

import java.awt.*;

import static utilities.Constant.SceneConstant.*;
import static utilities.LoadSave.GetLevelData;
import static utilities.LoadSave.SaveLevel;

public class LevelManager {
    private final Scene scene;
    private final TileManager tileManager;
    private int[][] level;

    public LevelManager(Scene scene) {
        this.scene = scene;
        tileManager = new TileManager();
        loadDefaultLevel();
    }


    public void saveLevel() {
        SaveLevel(level);
    }

    private void loadDefaultLevel() {
        level = GetLevelData();
    }

    public void draw(Graphics2D graphics2D) {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < MAX_SCREEN_COL && worldRow < MAX_SCREEN_ROW) {
            int id = level[worldCol][worldRow];
            graphics2D.drawImage(tileManager.getSprite(id), worldCol * TILE_SIZE, worldRow * TILE_SIZE, null);
            worldCol++;

            if(worldCol == MAX_SCREEN_COL) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public int[][] getTileId() {
        return level;
    }
}
