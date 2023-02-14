package src.game;

import src.asset.AsciiArt;
import src.exception.PersoOutOfMapException;
import src.menu.Menu;
import src.perso.Personnage;
import src.window.DisplayGameAnimation;
import src.window.GameWindow;
import src.window.Panel;

import java.util.Random;
import java.util.Scanner;

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

    private Scanner scanner;
    private AsciiArt asciiArt;
    private int shortWait;
    private int longWait;

    private boolean moving;


    public Game(Personnage player, Random random, Scanner scanner) {
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
        Panel panel = new Panel();
        DisplayGameAnimation displayGameAnimation = new DisplayGameAnimation(panel);
        Menu menu = new Menu(scanner);

        while (this.position < this.map) {
            int playerAction = menu.nextTurnChoice();

            if (playerAction == 1) {
                System.out.println("Your position: " + this.position);
                /**
                 * Lance le dés
                 */
                this.dice = this.rollDice();

                //Passe la valeur du dés au pannel pour pouvoir faire scroller la fenetre de jeu
                panel.setDice(this.dice);

                // Passe moving a true pour jouer l'animation RUN et faire avancer la frame du joueur en fonction du jet de dés
                this.moving = true;
                panel.setMoving(this.moving);

                //Passe moving a false pour jouer l'animation IDLE quand la frame du joueur reste sur place
                this.moving = false;

                this.playerMouve(dice);
            }

            waitSecond(1000);
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

    public void setPlayer(Personnage player) {
        this.player = player;
    }
}
