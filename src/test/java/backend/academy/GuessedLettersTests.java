package backend.academy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GuessedLettersTests {
    @Test
    public void constructorTest() {
        String word = "actual";
        GuessedLetters actual = new GuessedLetters(word);
        assertThat(actual.toString()).isEqualTo("_".repeat(word.length()));
    }

    @Test
    public void addLetterTest() {
        String word = "ACTUAL";
        GuessedLetters actual = new GuessedLetters(word);
        actual.addLetter('a', word);
        assertThat(actual.toString()).isEqualTo("A___A_");
    }

    @Test
    public void addNotExistLetterTest() {
        String word = "actual";
        GuessedLetters actual = new GuessedLetters(word);
        actual.addLetter('b', word);
        assertThat(actual.toString()).isEqualTo("_".repeat(word.length()));
    }

    @Test
    public void getObjectTest() {
        String word = "actual";
        GuessedLetters actual = new GuessedLetters(word);
        assertThat(actual.getObject(Difficulty.HARD).getSprite()).isEqualTo(new String[] {"_ _ _ _ _ _"});
    }

}
