package backend.academy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.assertj.core.api.Assertions.assertThat;

public class WordChooserTests {
    @ParameterizedTest
    @EnumSource(Difficulty.class)
    public void getWordTest(Difficulty difficulty) {
        assertThat(WordChooser.getWord(difficulty)).isIn(GameConstants.WORDS_COLLECTION[difficulty.ordinal()]);
    }
}
