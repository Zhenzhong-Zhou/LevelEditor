package utilities;

import static utilities.Constant.SceneConstant.SCENE_WIDTH;

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
        public static final float SCALE = 1f;

        /*
            Actual Size
         */
        public static final int TILE_SIZE = (int) (ORIGINAL_TILES_SIZE * SCALE);    // 32*32 tile
        public static final int MAX_SCREEN_COL = 100;
        public static final int MAX_SCREEN_ROW = 100;
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
    }
}
