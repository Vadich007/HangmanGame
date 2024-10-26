package backend.academy;

public final class WordChooser {

    public static String getWord(Difficulty difficulty) {
        return GameConstants.WORDS_COLLECTION[difficulty.ordinal()][(int) (Math.random()
            * (GameConstants.WORDS_COLLECTION[difficulty.ordinal()].length - 1))];
    }

    private WordChooser() {
    }
}
