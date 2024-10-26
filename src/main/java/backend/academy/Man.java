package backend.academy;

public class Man {
    private String manElements = "0|/\\/\\";
    private String[] currentSprite;
    private boolean hasHands;
    private SceneObject object;
    @SuppressWarnings("membername")
    private final int START_X = 14;
    @SuppressWarnings("membername")
    private final int START_Y = 6;
    @SuppressWarnings("membername")
    private final int HEIGHT = 3;
    @SuppressWarnings("membername")
    private final int WIDTH = 3;

    public Man() {
        String startSprite = "   ";
        currentSprite = new String[] {startSprite, startSprite, startSprite};
        this.object = new SceneObject(START_X, START_Y, HEIGHT, WIDTH, currentSprite);
        hasHands = false;
    }

    public SceneObject getObject() {
        return object;
    }

    public void addElement() {
        if (manElements.isEmpty()) {
            return;
        }

        switch (manElements.charAt(0)) {
            case '0':
                currentSprite[0] = " 0 ";
                break;
            case '|':
                currentSprite[1] = " | ";
                break;
            case '/':
                if (!hasHands) {
                    currentSprite[1] = "/| ";
                } else {
                    currentSprite[2] = "/  ";
                }
                break;
            case '\\':
                if (!hasHands) {
                    currentSprite[1] = "/|\\";
                    hasHands = true;
                } else {
                    currentSprite[2] = "/ \\";
                }
                break;
            default:
                break;
        }
        manElements = manElements.substring(1);
        object = new SceneObject(START_X, START_Y, HEIGHT, WIDTH, currentSprite);
    }
}
