package backend.academy;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

public class ObjectBuilderTests {
    @Test
    public void emptyObjectTest() {
        SceneObject actual = ObjectBuilder.emptyObject();
        String[] expectedSprite = new String[GameConstants.HEIGHT];
        Arrays.fill(expectedSprite, " ".repeat(GameConstants.WIDTH));
        assertThat(actual.getSprite()).isEqualTo(expectedSprite);
        assertThat(actual.getWidth()).isEqualTo(GameConstants.WIDTH);
        assertThat(actual.getHeight()).isEqualTo(GameConstants.HEIGHT);
        assertThat(actual.getStartX()).isEqualTo(0);
        assertThat(actual.getStartY()).isEqualTo(0);
    }

    @Test
    public void clearMessageAreaTest() {
        SceneObject actual = ObjectBuilder.clearMessageArea();
        String line = " ".repeat(40);
        String[] expectedSprite = new String[] {line, line};
        assertThat(actual.getSprite()).isEqualTo(expectedSprite);
        assertThat(actual.getWidth()).isEqualTo(40);
        assertThat(actual.getHeight()).isEqualTo(2);
        assertThat(actual.getStartX()).isEqualTo(30);
        assertThat(actual.getStartY()).isEqualTo(11);
    }


    @ParameterizedTest
    @EnumSource(Difficulty.class)
    public void difficultyObjectTest(Difficulty difficulty) {
        SceneObject actual = ObjectBuilder.difficultyObject(difficulty);
        String line = "DIFFICULTY: ";
        String[] expectedSprite = new String[] {line + difficulty.toString()};
        assertThat(actual.getSprite()).isEqualTo(expectedSprite);
        assertThat(actual.getWidth()).isEqualTo(line.length() + difficulty.toString().length());
        assertThat(actual.getHeight()).isEqualTo(1);
        assertThat(actual.getStartX()).isEqualTo(25);
        assertThat(actual.getStartY()).isEqualTo(2);
    }

    @Test
    public void attemptsLeftObjectTest() {
        SceneObject actual = ObjectBuilder.attemptsLeftObject(GameConstants.MAX_ATTEMPTS);
        String line = "ATTEMPTS LEFT: ";
        String[] expectedSprite = new String[] {line + Integer.toString(GameConstants.MAX_ATTEMPTS)};
        assertThat(actual.getSprite()).isEqualTo(expectedSprite);
        assertThat(actual.getWidth()).isEqualTo(line.length() + 1);
        assertThat(actual.getHeight()).isEqualTo(1);
        assertThat(actual.getStartX()).isEqualTo(50);
        assertThat(actual.getStartY()).isEqualTo(2);
    }

    @Test
    public void usedLettersObjectTest() {
        ArrayList<Character> usedLetters = new ArrayList<Character>();
        usedLetters.add('b');
        usedLetters.add('a');

        SceneObject actual = ObjectBuilder.usedLettersObject(usedLetters);

        Collections.sort(usedLetters);
        String letters = usedLetters.stream().map(Object::toString)
            .collect(Collectors.joining(" "));

        String line = "USED LETTERS: ";
        String[] expectedSprite = new String[] {line + letters};
        assertThat(actual.getSprite()).isEqualTo(expectedSprite);
        assertThat(actual.getWidth()).isEqualTo(line.length() + letters.length());
        assertThat(actual.getHeight()).isEqualTo(1);
        assertThat(actual.getStartX()).isEqualTo(30);
        assertThat(actual.getStartY()).isEqualTo(7);
    }
}
