package gui;

import states.GameState;

import java.awt.*;
import java.awt.event.MouseEvent;

import static utilities.LoadSave.GetFont;
import static utilities.LoadSave.MARU_MONICA;

public class Button {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final String buttonName;
    private final GameState gameState;
    private final int id;
    private Rectangle bounds;
    private boolean mouseHover, mousePressed;
    private Font maruMonica, purisaB;

    /**
     * Menu Buttons
     */
    public Button(int x, int y, int width, int height, String buttonName, GameState gameState) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonName = buttonName;
        this.gameState = gameState;
        this.id = - 1;
        initBounds();
        initFont();
    }

    /**
     * Tile Buttons
     */
    public Button(int x, int y, int width, int height, String buttonName, int id) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonName = buttonName;
        this.gameState = null;
        this.id = id;
        initBounds();
        initFont();
    }

    private void initBounds() {
        bounds = new Rectangle(x, y, width, height);
    }

    private void initFont() {
        maruMonica = GetFont(MARU_MONICA);
    }

    public void draw(Graphics2D graphics2D) {
        // BODY
        drawBody(graphics2D);

        // BORDER
        drawBorder(graphics2D);

        // TEXT
        drawText(graphics2D);
    }

    private void drawBody(Graphics2D graphics2D) {
        if(mouseHover) graphics2D.setColor(Color.GRAY);
        else graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(x, y, width, height);
    }

    private void drawBorder(Graphics2D graphics2D) {
        if(mousePressed) {
            graphics2D.setColor(Color.PINK);
            graphics2D.drawRect(x + 1, y + 1, width - 2, height - 2);
            graphics2D.drawRect(x + 2, y + 2, width - 4, height - 4);
        } else {
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawRect(x, y, width, height);
        }
    }

    private void drawText(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(maruMonica);
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 32F));
        int widthName = graphics2D.getFontMetrics().stringWidth(buttonName);
        int heightName = graphics2D.getFontMetrics().getHeight();
        graphics2D.drawString(buttonName, x - widthName / 2 + width / 2, y + heightName / 2 + height / 2);
    }

    public boolean isBound(MouseEvent e, Button button) {
        return button.getBounds().contains(e.getX(), e.getY());
    }

    public boolean isMouseHover() {
        return mouseHover;
    }

    public void setMouseHover(boolean mouseHover) {
        this.mouseHover = mouseHover;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public int getId() {
        return id;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void applyGameState() {
        GameState.gameState = gameState;
    }

    public void restBooleans() {
        mouseHover = false;
        mousePressed = false;
    }
}
