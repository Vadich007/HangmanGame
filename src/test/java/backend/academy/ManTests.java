package backend.academy;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ManTests {
    @Test
    public void constructorTest() {
        Man man = new Man();
        SceneObject actual = man.getObject();
        String actualSprite = "   ";
        SceneObject expected = new SceneObject(14, 6, 3, 3, new String[] {actualSprite, actualSprite, actualSprite});
        assertThat(expected.getSprite()).isEqualTo(actual.getSprite());
    }

    @Test
    public void addElementTest() {
        Man man = new Man();
        var expected = new String[][] {{" 0 ", "   ", "   "},
            {" 0 ", " | ", "   "}, {" 0 ", "/| ", "   "}, {" 0 ", "/|\\", "   "},
            {" 0 ", "/|\\", "/  "}, {" 0 ", "/|\\", "/ \\"}, {" 0 ", "/|\\", "/ \\"}};
        for (int i = 0; i < 7; i++) {
            man.addElement();
            assertThat(expected[i]).isEqualTo(man.getObject().getSprite());
        }
    }
}
