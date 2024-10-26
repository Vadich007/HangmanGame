package backend.academy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements BaseReader {

    @SuppressWarnings("magicnumber")
    public SceneObject readObject(String path) {

        try {
            Scanner in = new Scanner(new File(path));

            var buffer = in.nextLine().split(",");

            int startX = Integer.parseInt(buffer[0]);
            int startY = Integer.parseInt(buffer[1]);
            int height = Integer.parseInt(buffer[2]);
            int width = Integer.parseInt(buffer[3]);

            String[] sprite = new String[height];
            for (int y = 0; y < height; y++) {
                sprite[y] = in.nextLine();
            }

            in.close();

            return new SceneObject(startX, startY, height, width, sprite);
        } catch (FileNotFoundException e) {
            return ObjectBuilder.emptyObject();
        }
    }
}
