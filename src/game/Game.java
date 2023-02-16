package src.game;

import src.asset.AsciiArt;
import src.exception.PersoOutOfMapException;
import src.perso.Character;

import java.util.Random;
import java.util.Scanner;

public class Game {

    /**
     * Le plateau de jeux ou le joueur évolue
     */
    private int map;

    /**
     * Le dés que le joueur va lancer pour faire des actions
     */
    private int dice;
    /**
     * Le personnage du joueur
     */
    private Character player;
    /**
     * Attribut qui va stocker le random pour le lancer de dés
     */
    private Random random;

    /**
     * Stock la position du personnage
     */
    private int position;

    private Scanner scanner;
    private AsciiArt asciiArt;
    private int shortWait;
    private int longWait;

    private boolean moving;


    public Game(Character player, Random random, Scanner scanner) {
        this.map = 64;
        this.dice = 6;
        this.player = player;
        this.random = random;
        this.position = 1;
        this.asciiArt = new AsciiArt();
        this.shortWait = 1500;
        this.longWait = 3000;
        this.moving = true;
        this.scanner = scanner;
    }

    /**
     * Fonction qui lance un dés a 6 faces
     */
    public int rollDice() {
        int rand = this.random.nextInt(6);
        rand++;
        return rand;
    }

    public void playerMouve(int dice) {
        this.position = this.position + dice;
    }

    public void gameLoop() throws PersoOutOfMapException {

// Création du board de jeux !



//        Panel panel = new Panel();
//        DisplayGameAnimation displayGameAnimation = new DisplayGameAnimation(panel);
//        int pixelMouv = 0;
//
//        while (this.position < this.map) {
//
//            System.out.println("Your position: " + this.position);
//            /**
//             * Lance le dés
//             */
//            this.dice = this.rollDice();
//            this.playerMouve(dice);
//            panel.setMoving(true);
//            pixelMouv = (this.position * 5);
//            panel.changeXDelta(pixelMouv);
//            System.out.println(panel.getxDelta());
//            waitSecond(500);
//            panel.setMoving(false);
//            System.out.println("Your player advance of " + dice + " case(s)");
//        }
//
//
//        if (this.position == map) {
//            asciiArt.congratulation();
//            waitSecond(longWait);
//        } else {
//            throw new PersoOutOfMapException();
//        }
    }

    public int getMap() {
        return map;
    }

    public int getDice() {
        return dice;
    }

    public Character getPlayer() {
        return player;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }
}
