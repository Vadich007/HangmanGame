package backend.academy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private String hiddenWord;
    private GuessedLetters guessedLetters;
    private int attemptsLeft = GameConstants.MAX_ATTEMPTS;
    private ArrayList<Character> usedLetters;
    private Difficulty difficulty;
    private Scene scene;
    private BaseSceneDrawer sceneDrawer;
    private BaseReader reader;
    private Scanner scanner;
    private Man man;

    public Game() {
        scanner = new Scanner(System.in);
        reader = new FileReader();
        sceneDrawer = new ConsoleSceneDrawer();
        scene = new Scene(reader.readObject(Sprites.box), reader.readObject(Sprites.startScreen));
        man = new Man();
        usedLetters = new ArrayList<>(attemptsLeft);
        Hint.initHints();
    }

    public void start() {
        sceneDrawer.drawScene(scene);
        initDifficulty();
        scene.clear();

        scene.update(reader.readObject(Sprites.box), reader.readObject(Sprites.gallows), ObjectBuilder.instruction,
            ObjectBuilder.attemptsLeftObject(attemptsLeft), ObjectBuilder.usedLettersObject(usedLetters),
            ObjectBuilder.difficultyObject(difficulty), man.getObject(), guessedLetters.getObject(difficulty));

        while (!isEnd()) {
            sceneDrawer.drawScene(scene);
            String currentInput = scanner.nextLine();
            if (currentInput.equalsIgnoreCase(GameConstants.HINT_PHRASE)) {
                scene.update(Hint.getObject(hiddenWord));
            } else if (currentInput.length() != 1) {
                scene.update(ObjectBuilder.clearMessageArea(), ObjectBuilder.invalidInput);
            } else if (usedLetters.contains(currentInput.toUpperCase().charAt(0))) {
                scene.update(ObjectBuilder.clearMessageArea(), ObjectBuilder.letterAlreadyUsed,
                    guessedLetters.getObject(difficulty));
            } else if (hiddenWord.contains(currentInput.toUpperCase())) {
                guessedLetters.addLetter(currentInput.charAt(0), hiddenWord);
                usedLetters.add(currentInput.toUpperCase().charAt(0));
                scene.update(ObjectBuilder.clearMessageArea(), ObjectBuilder.correctLetter,
                    guessedLetters.getObject(difficulty),
                    ObjectBuilder.usedLettersObject(usedLetters));
            } else {
                usedLetters.add(currentInput.toUpperCase().charAt(0));
                man.addElement();
                attemptsLeft--;
                scene.update(ObjectBuilder.clearMessageArea(), man.getObject(), ObjectBuilder.incorrectLetter,
                    ObjectBuilder.attemptsLeftObject(attemptsLeft), ObjectBuilder.usedLettersObject(usedLetters));
            }
        }

        scene.clear();
        initFinalScene();
        sceneDrawer.drawScene(scene);
        scanner.close();
    }

    private void initFinalScene() {
        if (isLost()) {
            scene.update(reader.readObject(Sprites.box), reader.readObject(Sprites.gallows), man.getObject(),
                reader.readObject(Sprites.gameOverScreen), ObjectBuilder.gameOverCorrectWord(hiddenWord));
        } else {
            scene.update(reader.readObject(Sprites.box), ObjectBuilder.attemptsLeftObject(attemptsLeft),
                reader.readObject(Sprites.gallows),
                man.getObject(), guessedLetters.getObject(difficulty), reader.readObject(Sprites.gameWonScreen),
                ObjectBuilder.difficultyObject(difficulty), ObjectBuilder.congratulations);
        }
    }

    @SuppressWarnings("hiddenfield")
    private void initDifficulty() {
        String difficulty = scanner.nextLine().toUpperCase();
        if (Arrays.stream(Difficulty.values()).anyMatch(e -> e.name().equals(difficulty))) {
            this.difficulty = Difficulty.valueOf(difficulty);
        } else {
            this.difficulty = Difficulty.HARD;
        }
        hiddenWord = WordChooser.getWord(this.difficulty);
        guessedLetters = new GuessedLetters(hiddenWord);
    }

    private boolean isWon() {
        return hiddenWord.equals(guessedLetters.toString());
    }

    private boolean isLost() {
        return attemptsLeft == 0;
    }

    private boolean isEnd() {
        return isWon() || isLost();
    }
}
