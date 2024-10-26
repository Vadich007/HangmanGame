package backend.academy;

public class GuessedLetters {
    private String displayedLine;

    GuessedLetters(String hiddenWord) {
        displayedLine = "_".repeat(hiddenWord.length());
    }

    public void addLetter(char letter, String hiddenWord) {
        StringBuilder sb = new StringBuilder(displayedLine);
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == Character.toUpperCase(letter)) {
                sb.setCharAt(i, Character.toUpperCase(letter));
            }
        }
        displayedLine = sb.toString();
    }

    @SuppressWarnings("magicnumber")
    public SceneObject getObject(Difficulty difficulty) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < displayedLine.length(); i++) {
            sb.append(displayedLine.charAt(i));
            sb.append(' ');
        }

        return new SceneObject(35 + 5 * difficulty.ordinal(), 5, 1, sb.length() - 1,
            new String[] {sb.substring(0, sb.length() - 1)});
    }

    @Override
    public String toString() {
        return displayedLine;
    }
}
