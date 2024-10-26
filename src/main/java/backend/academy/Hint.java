package backend.academy;

import java.util.HashMap;

public final class Hint {
    public static HashMap<String, String> hintMap = new HashMap<>();

    public static void initHints() {
        hintMap.put("CAT", "An animal that says \"Meow\"");
        hintMap.put("DOG", "Man's Best Friend");
        hintMap.put("LOVE", "The opposite of the word hate");
        hintMap.put("SNOW", "This is what the snowman consists of");
        hintMap.put("SUMMER", "The warmest time of the year");
        hintMap.put("APPLE", "It's a fruit and a smartphone");
        hintMap.put("GOOSE", " It is a waterfowl known " + '\n'
            + "for its distinctive voice");
        hintMap.put("BANANA", "A fruit that the\nminions loved very much");
        hintMap.put("DIFFRACTION", "The phenomenon of light " + '\n'
            + "bending around obstacles");
        hintMap.put("CRYPTOCURRENCY", "A modern kind of currency" + '\n'
            + " built on the blockchain ");
        hintMap.put("ENCAPSULATION", "    One of the principles     " + '\n'
            + "of object-oriented programming");
        hintMap.put("CONCATENATION", "Adding strings");
    }

    private Hint() {
    }

    @SuppressWarnings("magicnumber")
    public static SceneObject getObject(String key) {
        if (!hintMap.containsKey(key)) {
            return ObjectBuilder.emptyObject();
        }
        String[] hint = hintMap.get(key).split("\n");
        return new SceneObject(35, 11, hint.length, hint[0].length(), hint);
    }
}
