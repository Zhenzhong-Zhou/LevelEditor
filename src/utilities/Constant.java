package utilities;

import static utilities.Constant.SceneConstant.SCENE_WIDTH;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class Constant {
    /**
     * GAME SETTINGS
     */
    public static class GameConstant {
        public static final int FPS_SET = 120;
        public static final int UPS_SET = 200;
    }

    /**
     * SCENE SETTINGS
     */
    public static class SceneConstant {
        public static final int ORIGINAL_TILES_SIZE = 16;       // 16*16 tile
        public static final float SCALE = 2f;

        /*
            Actual Size
         */
        public static final int TILE_SIZE = (int) (ORIGINAL_TILES_SIZE * SCALE);    // 32*32 tile
        public static final int MAX_SCREEN_COL = 45;
        public static final int MAX_SCREEN_ROW = 45;
        public static final int SCENE_WIDTH = MAX_SCREEN_COL * TILE_SIZE;       // 1152 pixels
        public static final int SCENE_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;      // 864 pixels
    }

    /**
     * GUI SETTINGS
     */
    public static class GUI {
        public static class Buttons {
            public static final int Y_OFFSET = 65;
            public static final int BUTTON_WIDTH = 220;
            public static final int BUTTON_HEIGHT = 60;
            public static final int BUTTON_X = SCENE_WIDTH / 2 - BUTTON_WIDTH / 2;
            public static final int BUTTON_Y = 770;
        }

        public static class ToolBar {
            public static final int BAR_WIDTH = 200;
            public static final int BAR_HEIGHT = 150;
            public static final int TILE_BUTTON_SIZE = BAR_HEIGHT / 3;
            public static final int X_OFFSET = (int) (TILE_SIZE * 1.5f);
            public static final int X_SELECTED_TILE = 20;
            public static final String GRASS_NAME = "GRASS";
            public static final String WATER_NAME = "WATER";
            public static final String WALL_NAME = "WALL";
            public static final String EARTH_NAME = "EARTH";
            public static final String TREE_NAME = "TREE";
            public static final String ROAD_NAME = "ROAD";
        }
    }
}
