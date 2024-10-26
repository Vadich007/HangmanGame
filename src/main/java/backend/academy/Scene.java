package backend.academy;

public class Scene {
    @SuppressWarnings("membername")
    private final int WIDTH = GameConstants.WIDTH;
    @SuppressWarnings("membername")
    private final int HEIGHT = GameConstants.HEIGHT;

    private char[][] scene;

    public Scene() {
        scene = new char[HEIGHT][WIDTH];
        clear();
    }

    public Scene(SceneObject... objects) {
        scene = new char[HEIGHT][WIDTH];
        clear();
        update(objects);
    }

    public char[][] getScene() {
        return scene;
    }

    public void clear() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                scene[y][x] = ' ';
            }
        }
    }

    public void update(SceneObject... objects) {
        for (var obj : objects) {
            for (int y = 0; y < obj.getHeight(); y++) {
                for (int x = 0; x < obj.getWidth(); x++) {
                    scene[obj.getStartY() + y][obj.getStartX() + x] = obj.getSprite()[y].charAt(x);
                }
            }
        }
    }
}
