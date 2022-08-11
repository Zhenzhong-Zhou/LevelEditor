package tiles;

import java.awt.image.BufferedImage;

public class Tile {
    private final BufferedImage sprite;
    private final boolean collision;

    public Tile(BufferedImage sprite, boolean collision) {
        this.sprite = sprite;
        this.collision = collision;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public boolean isCollision() {
        return collision;
    }
}
