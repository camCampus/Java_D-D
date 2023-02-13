package src.game;

import src.asset.AsciiArt;
import src.exception.PersoOutOfMapException;
import src.perso.Personnage;

import java.util.Random;

import static src.utils.Utils.waitSecond;

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
    private Personnage player;
    /**
     * Attribut qui va stocker le random pour le lancer de dés
     */
    private Random random;

    /**
     * Stock la position du personnage
     */
    private int position;

    private AsciiArt asciiArt;
    private int shortWait;
    private int longWait;

    public Game(Personnage player, Random random) {
        this.map = 64;
        this.dice = 6;
        this.player = player;
        this.random = random;
        this.position = 1;
        this.asciiArt = new AsciiArt();
        this.shortWait = 1500;
        this.longWait = 3000;
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

        while (this.position < this.map) {
            System.out.println("Your position: "+this.position);
            int dice = this.rollDice();
            this.playerMouve(dice);
            //waitSecond(1000);
            System.out.println("Your player advance of " + dice + " case(s)");
        }


        if (this.position == map) {
            asciiArt.congratulation();
            waitSecond(longWait);
        } else {
            throw new PersoOutOfMapException();
        }
    }

    public int getMap() {
        return map;
    }

    public int getDice() {
        return dice;
    }

    public Personnage getPlayer() {
        return player;
    }


}
