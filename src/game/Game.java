package src.game;

import src.App;
import src.asset.AsciiArt;
import src.board.Board;
import src.board.BoardFactory;
import src.board.cell.Cell;
import src.exception.PersoOutOfMapException;
import src.menu.Menu;
import src.menu.MenuActionEntry;
import src.perso.Character;
import src.window.DisplayGameAnimation;
import src.window.Panel;

import java.util.ArrayList;
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

        boolean run = true;

        Panel panel = new Panel();
        panel.setGameBoard(this.gameBoard);
        DisplayGameAnimation displayGameAnimation = new DisplayGameAnimation(panel);
        int pixelMouv = 0;


//        while (run) {
//            List<MenuActionEntry> actionInGame = new ArrayList<>();
//
//            Menu menuInGame = new Menu(this.scanner, actionInGame);
//        }

        while (this.position < this.gameBoard.size() && player.isAlive()) {
            String playerStats = App.getInstance().getPersonnage().toString();
            System.out.println(playerStats );

            //Player game
            this.dice = rollDice();
            playerMouve(this.dice);
            getPlayerCell();
            System.out.println("Your player advance of " + dice + " case(s)");
            System.out.println("position " + this.position );

            //Sprite update
            panel.setMoving(true);
            pixelMouv = (this.position * 64);
            panel.changeXDelta(pixelMouv);

            panel.setMoving(false);

            //Cell effect
            this.actualCell.apply();
            waitSecond(1500);
        }

        if (player.isAlive()) {
            this.position = 65;
            panel.setMoving(true);
            pixelMouv = (this.position * 64);
            panel.changeXDelta(pixelMouv);
            panel.setMoving(false);
        }
    }

    public void getPlayerCell() {
        this.actualCell = this.gameBoard.get(this.position);
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
