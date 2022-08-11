package tiles;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilities.Constant.GUI.ToolBar.*;
import static utilities.LoadSave.*;

public class TileManager {
    private final ArrayList<Tile> tiles = new ArrayList<>();
    private Tile GRASS, WATER, WALL, EARTH, TREE, ROAD;

    public TileManager() {
        createTiles();
    }

    private void createTiles() {
        int id = 0;
        tiles.add(GRASS = new Tile(GetSpriteAtlas(GRASS_IMAGE), GRASS_NAME, id++, false));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_IMAGE), WATER_NAME, id++, true));
        tiles.add(WALL = new Tile(GetSpriteAtlas(WALL_IMAGE), WALL_NAME, id++, true));
        tiles.add(EARTH = new Tile(GetSpriteAtlas(EARTH_IMAGE), EARTH_NAME, id++, false));
        tiles.add(TREE = new Tile(GetSpriteAtlas(TREE_IMAGE), TREE_NAME, id++, true));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_IMAGE), ROAD_NAME, id++, false));
    }

    public Tile getTile(int id) {
        return tiles.get(id);
    }

    public BufferedImage getSprite(int id) {
        return tiles.get(id).getSprite();
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
