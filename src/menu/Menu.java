package src.menu;

import src.asset.AsciiArt;
import src.perso.Personnage;
import src.perso.TypePersonage;
import src.perso.Warrior;
import src.perso.Wizard;

import static com.diogonunes.jcolor.Ansi.colorize;
import static src.utils.Utils.waitSecond;


import java.util.Scanner;

public class Menu {
    /**
     * Attribut scanner de type Scanner qui sera initialisé à la construction
     */
    private final Scanner scanner;
    /**
     * Represente la classe AsciiArt qui stock toutes les methodes pour afficher nos
     * asset ascii
     */
    private AsciiArt asciiArt;
    /**
     * Attribut pour stocker le personnage que le joueur aura configuré, par default
     * le nom est "default" et la classe est Warrior.
     */
    private Personnage player;

    /**
     * Parametre pour la fonction waitSecond() represente une valeur en milliseconde
     * ici 1500
     */
    private int shortWait;

    /**
     * Parametre pour la fonction waitSecond() represente une valeur en milliseconde
     * ici 3000
     */
    private int longWait;

    /**
     * Initialisé à false attribut pour déteminer si le joueur souhaite quitter le
     * jeu.
     */
    private boolean quit;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.player = new Warrior("default", TypePersonage.Warrior);
        this.asciiArt = new AsciiArt();
        this.shortWait = 15;
        this.longWait = 30;
        this.quit = false;
    }

    /**
     * Fonction qui lance le premier menu du choix du personnage
     */
    public boolean init() {
        int navChoice = this.welcome();
        scanner.nextLine();

        if (navChoice == 1) {
            this.createPlayer();

        } else if (navChoice == 2) {
            this.quit = true;
        }
        return this.quit;
    }


    /**
     * Premier menu le joueur peut choisir de créer un joueur ou de quitter le jeu
     *
     * @return le choix du joueur pour le premier menu
     */
    public int welcome() {

        asciiArt.intro();
        waitSecond(shortWait);
        System.out.println("Welcome in D&D");
        System.out.println("MENU");
        System.out.println("For navigation select number");
        System.out.println("1 ---| New Player |---");
        System.out.println("2 ---| Exit Game |---");
        return this.scanner.nextInt();
    }

    /***
     * Menu 2 le joueur choisit le nom de son personnage
     * @return le nom du joueur
     */
    public String playerSetName() {
        System.out.println("Enter your player name");
        return this.scanner.nextLine();
    }

    /**
     * Menu 3 le joueur chosit son type de personnage
     *
     * @return le type du personnage
     */
    public int playerSetType() {
        System.out.println("Select your type");
        System.out.println("1 ---| Warrior |---");
        asciiArt.drawWarior();
        waitSecond(shortWait);
        System.out.println("2 ---| Wizard |---");
        this.asciiArt.drawWizzard();
        return this.scanner.nextInt();
    }

    /**
     * Fonction pour créer un player et choisir le nom et le type
     */
    public void createPlayer() {
        String persoName = this.playerSetName();
        int persoType = this.playerSetType();
        scanner.nextLine();
        if (persoType != 1) {
            this.player = new Wizard(persoName, TypePersonage.Wizard);
        } else {
            this.player.setName(persoName);
        }
        this.player.toString();
    }

    /**
     * Fonction pour permettre au joueur de modifier son personnage, de lancer
     * le jeu ou de quitter le jeu.
     * @return Un boolean pour savoir si le joueur souhaite quitter le jeu.
     */
    public boolean playerModification() {
        System.out.println("Are you ready ?");
        System.out.println("1 ---| Lunch The Game |---");
        System.out.println("2 ---| Reset Personage |---");
        System.out.println("3 ---| Exit Game |---");
        int playerChoice = scanner.nextInt();

        switch (playerChoice) {
            case 1:

                //Call game fonction

                asciiArt.journeyStart();
                waitSecond(longWait);

                System.out.println("After a long trip, you see the famous castle of Mogot and is dungeon");
                waitSecond(longWait);

                asciiArt.drawCastle();
                waitSecond(longWait);

                System.out.println("You are enter the dungeon of Morgot");
                waitSecond(longWait);

                asciiArt.drawDoor();
                waitSecond(longWait);

                break;
            case 2:
                scanner.nextLine();
                this.createPlayer();
                this.playerModification();
                break;

            case 3:
                this.quit = true;
                break;
        }
        return this.quit;
    }
    /**
     * Fonction qui se lance quand le joueur fini le jeu pour lui permettre de
     * recommencer le jeu ou quitter.
     * @return
     */
    public boolean restartGame() {

        System.out.println("You finish the dungeon of Morgot");
        waitSecond(longWait);
        System.out.println("Now you have the choice");
        waitSecond(shortWait);
        System.out.println("1 ---| New Game |---");
        waitSecond(shortWait);

        System.out.println("3 ---| Exit Game |---");
        int navChoice = scanner.nextInt();
        if (navChoice == 1){
            System.out.println("New Game");
        } else {
            this.quit = true;
        }
        return this.quit;
    }

    public int nextTurnChoice() {
        System.out.println("Your action");
        System.out.println("1 ---| Roll Dice |---");
        int val = this.scanner.nextInt();
        this.scanner.nextLine();
        return val;
    }
    /**
     * @return Le personnage du joueur avec ses configurations
     */
    public Personnage getPlayer() {
        return player;
    }


}
