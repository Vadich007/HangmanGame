package backend.academy;

public class ConsoleSceneDrawer implements BaseSceneDrawer {
    @Override @SuppressWarnings("regexpsinglelinejava")
    public void drawScene(Scene scene) {
        clearConsole();
        for (char[] line : scene.getScene()) {
            System.out.println(line);
        }
    }

    @SuppressWarnings("regexpsinglelinejava")
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
