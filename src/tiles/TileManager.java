package tiles;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilities.LoadSave.*;

public class TileManager {
    private final ArrayList<Tile> tiles = new ArrayList<>();
    private Tile GRASS, WATER, WALL, EARTH, TREE, ROAD;

    public TileManager() {
        createTiles();
    }

    private void createTiles() {
        tiles.add(GRASS = new Tile(GetSpriteAtlas(GRASS_IMAGE), false));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_IMAGE), true));
        tiles.add(WALL = new Tile(GetSpriteAtlas(WALL_IMAGE), true));
        tiles.add(EARTH = new Tile(GetSpriteAtlas(EARTH_IMAGE), false));
        tiles.add(TREE = new Tile(GetSpriteAtlas(TREE_IMAGE), true));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_IMAGE), false));
    }

    public BufferedImage getTile(int id) {
        return tiles.get(id).getSprite();
    }
}
