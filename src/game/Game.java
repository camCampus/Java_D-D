package src.game;

import com.diogonunes.jcolor.Attribute;
import src.App;
import src.asset.AsciiArt;
import src.board.Board;
import src.board.BoardFactory;
import src.board.cell.Cell;
import src.board.cell.MonsterCell;
import src.dice.RollDice;
import src.exception.PersoOutOfMapException;
import src.items.Item;
import src.items.attack.AttackItem;
import src.items.attack.Bow;
import src.items.attack.Stick;
import src.menu.Menu;
import src.menu.MenuActionEntry;
import src.menu.Starter;
import src.menu.inGame.Fight;
import src.menu.inGame.Inventory;
import src.menu.inGame.Run;
import src.perso.Character;
import src.window.DisplayGameAnimation;
import src.window.Panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
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
     * Fonction qui actualise la position du joueur en fonction du lancer de dés
     *
     * @param dice
     */
    public void playerMouve(int dice) {
        this.position = this.position + dice;
    }

    /**
     * La boucle de jeu
     *
     * @throws PersoOutOfMapException
     */
    public void gameLoop() throws PersoOutOfMapException {

        // Création du board de jeux !
        Board board = new Board();
        //Remplissage du board
        new BoardFactory(board);
        this.gameBoard = board.getEntry();

        //Création des éléments pour affichage graphique
        Panel panel = new Panel();
        panel.setGameBoard(this.gameBoard);
        new DisplayGameAnimation(panel);
        int pixelMouv = 0;

        while (this.position < this.gameBoard.size() && player.isAlive()) {

            //Choix de l'équipement
            List<MenuActionEntry> start = new ArrayList<>();
            start.add(new Starter(this.scanner));
            new Menu(this.scanner, start).runMenu();

            String playerStats = App.getInstance().getPersonnage().toString();
            waitSecond(300);

            //Player game
            RollDice roll = new RollDice();
            this.dice = roll.getDice();
            playerMouve(this.dice);
            getPlayerCell();
            waitSecond(300);
            System.out.println(
                    playerStats +
                            colorize(".~~~| DICE |~~~.", Attribute.TEXT_COLOR(0, 255, 255)) + "\n" +
                            "Your player advance of " + this.dice + " case(s)\n" +
                            "position " + this.position);


            //Sprite update
            panel.setMoving(true);
            pixelMouv = (this.position * 64);
            panel.changeXDelta(pixelMouv);
            panel.setMoving(false);


            //Cell effect
            boolean runFight = true;
            boolean canRun = false;
                if (this.actualCell instanceof MonsterCell) {

                    while (runFight && player.isAlive()) {
                        //Afficher le monstre
                        waitSecond(300);
                        System.out.println(colorize(".~~~| MONSTER |~~~.", Attribute.TEXT_COLOR(153, 0, 0)));
                        System.out.println(((MonsterCell) this.actualCell).getMonster().toString());

                        List<MenuActionEntry> fightMenu = new ArrayList<>();

                        Fight fight = new Fight();
                        fightMenu.add(fight);

                        fightMenu.add(new Inventory(this.actualCell));

                        Run esc = new Run(canRun);
                        fightMenu.add(esc);
                        new Menu(this.scanner, fightMenu).runMenu();

                        if (esc.isEscape()) {
                            runFight = false;
                            this.position = Math.max(0, (this.position - 2));
                        } else {

                            this.actualCell.apply();
                            canRun = true;
                            if (((MonsterCell) this.actualCell).getMonster().getLife() <= 0) {
                                runFight = false;
                            }
                        }
                    }
                } else {
                    this.actualCell.apply();
                }




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

    public boolean lunchFight(boolean lunch) {
        return lunch = true;
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
