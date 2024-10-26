package backend.academy;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SceneTests {
    @Test
    public void emptyConstructorTest() {
        Scene scene = new Scene();
        var actual = scene.getScene();
        for (int y = 0; y < GameConstants.HEIGHT; y++) {
            for (int x = 0; x < GameConstants.WIDTH; x++) {
                assertThat(actual[y][x]).isEqualTo(' ');
            }
        }
    }

    @Test
    public void objectConstructorTest() {
        FileReader fr = new FileReader();
        Scene scene = new Scene(fr.readObject(Sprites.box));
        var actual = scene.getScene();

        for (int y = 0; y < GameConstants.HEIGHT; y++) {
            for (int x = 0; x < GameConstants.WIDTH; x++) {
                if (y == 0 || y == GameConstants.HEIGHT - 1 || x == 0 || x == GameConstants.WIDTH - 1)
                    assertThat(actual[y][x]).isEqualTo('#');
                else assertThat(actual[y][x]).isEqualTo(' ');
            }
        }
    }

    @Test
    public void updateTest() {
        Scene scene = new Scene();
        FileReader fr = new FileReader();
        scene.update(fr.readObject(Sprites.box));
        var actual = scene.getScene();

        for (int y = 0; y < GameConstants.HEIGHT; y++) {
            for (int x = 0; x < GameConstants.WIDTH; x++) {
                if (y == 0 || y == GameConstants.HEIGHT - 1 || x == 0 || x == GameConstants.WIDTH - 1)
                    assertThat(actual[y][x]).isEqualTo('#');
                else assertThat(actual[y][x]).isEqualTo(' ');
            }
        }
    }
}
