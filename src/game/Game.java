package src.game;

import src.asset.AsciiArt;
import src.board.Board;
import src.board.BoardFactory;
import src.board.cell.Cell;
import src.exception.PersoOutOfMapException;
import src.perso.Character;
import src.window.DisplayGameAnimation;
import src.window.Panel;
import java.util.List;
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
    private Character player;
    /**
     * Attribut qui va stocker le random pour le lancer de dés
     */
    private Random random;

    /**
     * Stock la position du personnage
     */
    private int position;
    private List<Cell> gameBoard;
    private Scanner scanner;
    private AsciiArt asciiArt;
    private int shortWait;
    private int longWait;

    private boolean moving;
    private Cell actualCell;

    public Game(Character player, Random random, Scanner scanner) {
        this.map = 64;
        this.dice = 6;
        this.player = player;
        this.random = random;
        this.position = 0;
        this.asciiArt = new AsciiArt();
        this.shortWait = 1500;
        this.longWait = 3000;
        this.moving = true;
        this.scanner = scanner;
        this.gameBoard = null;
        this.actualCell = null;
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

        Board board = new Board();
        BoardFactory boardFactory = new BoardFactory(board);
        this.gameBoard = board.getEntry();

        Panel panel = new Panel();
        panel.setGameBoard(this.gameBoard);
        DisplayGameAnimation displayGameAnimation = new DisplayGameAnimation(panel);
        int pixelMouv = 0;

        while (this.position < this.gameBoard.size()) {
            this.dice = rollDice();
            playerMouve(this.dice);
            getPlayerCell();
            System.out.println("position" + this.position);
            panel.setMoving(true);
            pixelMouv = (this.position * 64);
            panel.changeXDelta(pixelMouv);
            System.out.println(panel.getxDelta());
            System.out.println("Your player advance of " + dice + " case(s)");
            //waitSecond(500);
            panel.setMoving(false);
            //Method pour check la case
        }

        this.position = 65;
        panel.setMoving(true);
        pixelMouv = (this.position * 64);
        panel.changeXDelta(pixelMouv);
        panel.setMoving(false);


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

    public void getPlayerCell() {
        this.actualCell = this.gameBoard.get(this.position);
        System.out.println(this.actualCell);
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
