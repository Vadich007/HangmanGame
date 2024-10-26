package backend.academy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HintTests {

    @Test
    public void initHintsTest() {
        Hint.initHints();
        assertThat(Hint.hintMap.size()).isEqualTo(12);
    }
    @Test
    public void getObjectTest() {
        Hint.initHints();
        assertThat(Hint.getObject("CONCATENATION").getSprite()).isEqualTo(new String[] {"Adding strings"});
    }

    @Test
    public void getNotExistObjectTest() {
        Hint.initHints();
        assertThat(Hint.getObject("JAVA").getSprite()).isEqualTo(ObjectBuilder.emptyObject().getSprite());
        assertThat(Hint.getObject("JAVA").getStartX()).isEqualTo(ObjectBuilder.emptyObject().getStartX());
        assertThat(Hint.getObject("JAVA").getStartY()).isEqualTo(ObjectBuilder.emptyObject().getStartY());
        assertThat(Hint.getObject("JAVA").getWidth()).isEqualTo(ObjectBuilder.emptyObject().getWidth());
        assertThat(Hint.getObject("JAVA").getHeight()).isEqualTo(ObjectBuilder.emptyObject().getHeight());
    }
}
