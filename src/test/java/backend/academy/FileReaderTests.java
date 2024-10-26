package backend.academy;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class FileReaderTests {
    @Test
    public void readObjectTest() {
        FileReader fr = new FileReader();
        var actual = fr.readObject(Sprites.box);
        String[] sprite = new String[GameConstants.HEIGHT];
        Arrays.fill(sprite, "#" + " ".repeat(GameConstants.WIDTH - 2) + "#");
        sprite[0] = "#".repeat(GameConstants.WIDTH);
        sprite[GameConstants.HEIGHT - 1] = "#".repeat(GameConstants.WIDTH);
        var expected = new SceneObject(0, 0, GameConstants.HEIGHT, GameConstants.WIDTH, sprite);
        assertThat(actual.getHeight()).isEqualTo(expected.getHeight());
        assertThat(actual.getWidth()).isEqualTo(expected.getWidth());
        assertThat(actual.getStartX()).isEqualTo(expected.getStartX());
        assertThat(actual.getStartY()).isEqualTo(expected.getStartY());
        assertThat(actual.getSprite()).isEqualTo(expected.getSprite());
    }

    @Test
    public void readNotExistentTest() {
        FileReader fr = new FileReader();
        var actual = fr.readObject("./notexist");
        var expected = ObjectBuilder.emptyObject();
        assertThat(actual.getHeight()).isEqualTo(expected.getHeight());
        assertThat(actual.getWidth()).isEqualTo(expected.getWidth());
        assertThat(actual.getStartX()).isEqualTo(expected.getStartX());
        assertThat(actual.getStartY()).isEqualTo(expected.getStartY());
        assertThat(actual.getSprite()).isEqualTo(expected.getSprite());
    }

}
