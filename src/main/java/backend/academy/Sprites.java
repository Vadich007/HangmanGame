package backend.academy;

import java.io.File;

public final class Sprites {
    @SuppressWarnings("constantname")
    private static final String spriteDir =
        "." + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator
            + "sprites";
    @SuppressWarnings("constantname")
    public static final String box = spriteDir + File.separator + "box.txt";
    @SuppressWarnings("constantname")
    public static final String startScreen = spriteDir + File.separator + "startScreen.txt";
    @SuppressWarnings("constantname")
    public static final String gameOverScreen = spriteDir + File.separator + "gameOverScreen.txt";
    @SuppressWarnings("constantname")
    public static final String gallows = spriteDir + File.separator + "gallows.txt";
    @SuppressWarnings("constantname")
    public static final String gameWonScreen = spriteDir + File.separator + "gameWonScreen.txt";

    private Sprites() {
    }
}
