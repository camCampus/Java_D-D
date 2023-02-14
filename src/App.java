package src;

import src.game.Game;
import src.perso.Personnage;

import java.util.Random;
import java.util.Scanner;

public final class App {

    private static App instance;
    private Personnage personnage;


    private Game game;
    private App() {
        this.personnage = null;
        this.game = null;
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public void setPersonnage(Personnage personnage , Random random) {
        this.personnage = personnage;
        this.game = new Game(personnage, random, new Scanner(System.in));
    }

    public Game getGame() {
        return game;
    }
    public Personnage getPersonnage() {
        return personnage;
    }
}
