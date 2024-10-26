package backend.academy;

public class SceneObject {
    private int startX;
    private int startY;
    private int height;
    private int width;
    private String[] sprite;

    SceneObject(int startX, int startY, int height, int width, String[] sprite) {
        this.startX = startX;
        this.startY = startY;
        this.height = height;
        this.width = width;
        this.sprite = sprite;
    }

    public String[] getSprite() {
        return sprite;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
