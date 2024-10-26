package backend.academy;

public final class GameConstants {
    @SuppressWarnings("membername")
    public static final int WIDTH = 75;

    @SuppressWarnings("membername")
    public static final int HEIGHT = 15;

    @SuppressWarnings("membername")
    public static final String HINT_PHRASE = "HINT";

    @SuppressWarnings("membername")
    public static final int MAX_ATTEMPTS = 6;

    public final static String[] EASY_WORDS = {"DOG", "CAT", "LOVE", "SNOW"};
    public final static String[] MEDIUM_WORDS = {"SUMMER", "APPLE", "GOOSE", "BANANA"};
    public final static String[] HARD_WORDS = {"DIFFRACTION", "ENCAPSULATION", "CRYPTOCURRENCY", "CONCATENATION"};
    public final static String[][] WORDS_COLLECTION = {HARD_WORDS, MEDIUM_WORDS, EASY_WORDS};

    private GameConstants() {
    }
}
