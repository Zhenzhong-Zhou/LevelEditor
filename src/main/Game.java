package main;

import static utilities.Constant.SceneConstant.MAX_SCREEN_COL;
import static utilities.Constant.SceneConstant.MAX_SCREEN_ROW;
import static utilities.LoadSave.CreateLevel;
import static utilities.LoadSave.CreatedFolder;

public class Game {
    public Game() {
        CreatedFolder();
        createDefaultLevel();

        Scene scene = new Scene();
        new Window(scene);

        scene.start();
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
}
