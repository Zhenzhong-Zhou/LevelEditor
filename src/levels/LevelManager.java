package levels;

import main.Scene;
import tiles.TileManager;

import java.awt.*;

import static utilities.Constant.SceneConstant.*;
import static utilities.LoadSave.*;

public class LevelManager {
    private final Scene scene;
    private final TileManager tileManager;
    private int[][] level;

    public LevelManager(Scene scene) {
        this.scene = scene;
        tileManager = new TileManager();
        createDefaultLevel();
        loadDefaultLevel();
        saveLevel();
    }

    private void createDefaultLevel() {
        int cols = MAX_SCREEN_COL;
        int rows = MAX_SCREEN_ROW;
        int[][] array = new int[cols][rows];

        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                array[i][j] = 0;
            }
        }
        CreateLevel(array);
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
            graphics2D.drawImage(tileManager.getTile(id), worldCol * TILE_SIZE, worldRow * TILE_SIZE, null);
            worldCol++;

            if(worldCol == MAX_SCREEN_COL) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
