package backend.academy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SceneObjectTests {
    @Test
    public void constractorTest() {
        SceneObject actual = new SceneObject(1,1,1,1, new String[] {"actual"});
        assertThat(actual.getSprite()).isEqualTo(new String[] {"actual"});
        assertThat(actual.getStartX()).isEqualTo(1);
        assertThat(actual.getStartY()).isEqualTo(1);
        assertThat(actual.getHeight()).isEqualTo(1);
        assertThat(actual.getWidth()).isEqualTo(1);
    }
}
