package backend.academy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public final class ObjectBuilder {

    private ObjectBuilder() {
    }

    @SuppressWarnings({"multiplestringliterals", "constantname"})
    public static final SceneObject incorrectLetter =
        new SceneObject(40, 11, 1, "INCORRECT LETTER".length(), new String[] {"INCORRECT LETTER"});
    @SuppressWarnings({"multiplestringliterals", "constantname"})
    public static final SceneObject correctLetter =
        new SceneObject(40, 11, 1, "CORRECT LETTER".length(), new String[] {"CORRECT LETTER"});
    @SuppressWarnings({"multiplestringliterals", "constantname"})
    public static final SceneObject invalidInput =
        new SceneObject(40, 11, 1, "INVALID INPUT".length(), new String[] {"INVALID INPUT"});
    @SuppressWarnings({"multiplestringliterals", "constantname"})
    public static final SceneObject letterAlreadyUsed =
        new SceneObject(30, 11, 1, "THE LETTER HAS ALREADY BEEN USED".length(),
            new String[] {"THE LETTER HAS ALREADY BEEN USED"});
    @SuppressWarnings({"multiplestringliterals", "constantname"})
    public static final SceneObject instruction =
        new SceneObject(30, 9, 1, "Write the letter or \"hint\" to get a hint".length(),
            new String[] {"Write the letter or \"hint\" to get a hint"});
    @SuppressWarnings({"multiplestringliterals", "constantname"})
    public static final SceneObject congratulations =
        new SceneObject(27, 12, 1, "Congratulations! You guessed the word!".length(),
            new String[] {"Congratulations! You guessed the word!"});

    @SuppressWarnings("magicnumber")
    public static SceneObject gameOverCorrectWord(String correctWord) {
        String line = "The correct word was ";
        return new SceneObject(30, 12, 1, line.length() + correctWord.length(),
            new String[] {line + correctWord});
    }

    @SuppressWarnings("magicnumber")
    public static SceneObject usedLettersObject(ArrayList<Character> usedLetters) {
        Collections.sort(usedLetters);
        String letters = usedLetters.stream().map(Object::toString)
            .collect(Collectors.joining(" "));
        String line = "USED LETTERS: ";
        return new SceneObject(30, 7, 1, line.length() + letters.length(),
            new String[] {line + letters});
    }

    @SuppressWarnings("magicnumber")
    public static SceneObject attemptsLeftObject(int attemptsLeft) {
        String line = "ATTEMPTS LEFT: ";
        return new SceneObject(50, 2, 1, line.length() + 1,
            new String[] {line + Integer.toString(attemptsLeft)});
    }

    @SuppressWarnings("magicnumber")
    public static SceneObject difficultyObject(Difficulty difficulty) {
        String line = "DIFFICULTY: ";
        return new SceneObject(25, 2, 1, line.length() + difficulty.toString().length(),
            new String[] {line + difficulty.toString()});
    }

    @SuppressWarnings("magicnumber")
    public static SceneObject clearMessageArea() {
        String line = " ".repeat(40);
        return new SceneObject(30, 11, 2, 40, new String[] {line, line});
    }

    public static SceneObject emptyObject() {
        String[] sprite = new String[GameConstants.HEIGHT];
        Arrays.fill(sprite, " ".repeat(GameConstants.WIDTH));
        return new SceneObject(0, 0, GameConstants.HEIGHT, GameConstants.WIDTH, sprite);
    }
}
