package donjon;

import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        boolean quitGame = false;
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Random random = new Random();
        AsciiArt asciiArt = new AsciiArt();

        while (run) {
            /**
             * Lance le premier menu ou le joueur peut choisir son perso
             */
            quitGame = menu.init();
            if (quitGame) {
                run = false;
                asciiArt.goodBye();
                return;
            }

            /**
             * Permet au joueur de recommencer son perso ou de lancer le jeu
             */
            quitGame = menu.playerModification();
            if (quitGame) {
                run = false;
                asciiArt.goodBye();
                return;
            }
            /**
             * Lance le jeu avec le perso du joueur
             */
            Game game = new Game(menu.getPlayer(), random);
            System.out.println(game.getPlayer());
            game.gameLoop();
            quitGame = menu.restartGame();
            if (quitGame) {
                run = false;
                asciiArt.goodBye();
                return;
            }
        }

    }
}
