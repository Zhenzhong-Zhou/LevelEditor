package tiles;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilities.Constant.GUI.ToolBar.*;
import static utilities.Constant.GUI.ToolBar.ROAD_NAME;
import static utilities.LoadSave.*;
import static utilities.LoadSave.ROAD_12_IMAGE;

public class TileManager {
    private final ArrayList<Tile> tiles = new ArrayList<>();
    private Tile GRASS, WATER, WALL, EARTH, TREE, ROAD;

    public TileManager() {
        createTiles();
    }

    private void createTiles() {
        int id = 0 ;
        // GRASS
        tiles.add(GRASS = new Tile(GetSpriteAtlas(GRASS_00_IMAGE), GRASS_NAME, id++, false));
        tiles.add(GRASS = new Tile(GetSpriteAtlas(GRASS_01_IMAGE), GRASS_NAME, id++, false));

        // WATER
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_00_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_01_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_02_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_03_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_04_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_05_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_06_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_07_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_08_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_09_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_10_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_11_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_12_IMAGE), WATER_NAME, id++, true));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_13_IMAGE), WATER_NAME, id++, true));

        // ROAD
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_00_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_01_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_02_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_03_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_04_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_05_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_06_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_07_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_08_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_09_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_10_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_11_IMAGE), ROAD_NAME, id++, false));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_12_IMAGE), ROAD_NAME, id++, false));

        // EARTH, WALL and TREE
        tiles.add(EARTH = new Tile(GetSpriteAtlas(EARTH_IMAGE), EARTH_NAME, id++, false));
        tiles.add(WALL = new Tile(GetSpriteAtlas(WALL_IMAGE), WALL_NAME, id++, true));
        tiles.add(TREE = new Tile(GetSpriteAtlas(TREE_IMAGE), TREE_NAME, id++, true));
        id++;
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
