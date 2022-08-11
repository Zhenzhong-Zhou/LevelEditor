package tiles;

import java.awt.image.BufferedImage;

public class Tile {
    private final BufferedImage sprite;
    private final boolean collision;
    private final String tileName;
    private final int tileId;

    public Tile(BufferedImage sprite, String tileName, int tileId, boolean collision) {
        this.sprite = sprite;
        this.tileName = tileName;
        this.tileId = tileId;
        this.collision = collision;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public String getTileName() {
        return tileName;
    }

    public int getTileId() {
        return tileId;
    }

    public boolean isCollision() {
        return collision;
    }
}
