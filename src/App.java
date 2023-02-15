package src;

import src.game.Game;
import src.perso.Character;

import java.util.Random;
import java.util.Scanner;

public final class App {

    private static App instance;
    private Character character;
    private int boardSize;

    private Game game;
    private App() {
        this.character = null;
        this.game = null;
        this.boardSize = 64;
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public void setPersonnage(Character character, Random random, Scanner scanner) {
        this.character = character;
        this.game = new Game(character, random, scanner);
    }

    public Game getGame() {
        return game;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Character getPersonnage() {
        return character;
    }
}
