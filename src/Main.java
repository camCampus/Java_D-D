package src;

import src.asset.AsciiArt;
import src.exception.PersoOutOfMapException;
import src.game.Game;
import src.menu.*;
import src.window.DisplayGameAnimation;
import src.window.GameWindow;
import src.window.Panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

//        /**
//         * Variable d'environement utiliser par les méthodes du jeu.
//         */
//        boolean quitGame = false;
//        boolean run = true;
//        Scanner scanner = new Scanner(System.in);
//        Menu menu = new Menu(scanner);
//        Random random = new Random();
//        AsciiArt asciiArt = new AsciiArt();
//
//        while (run) {
//            /**
//             * Lance le premier menu ou le joueur peut choisir son perso
//             */
//            quitGame = menu.init();
//            if (quitGame) {
//                run = false;
//                asciiArt.goodBye();
//                return;
//            }
//
//            /**
//             * Permet au joueur de recommencer son perso ou de lancer le jeu
//             */
//            quitGame = menu.playerModification();
//            if (quitGame) {
//                run = false;
//                asciiArt.goodBye();
//                return;
//            }
//            /**
//             * Lance le jeu avec le perso du joueur
//             */
//            Game game = new Game(menu.getPlayer(), random, scanner);
//            System.out.println(game.getPlayer());
//
//
//            try {
//                game.gameLoop();
//            } catch (PersoOutOfMapException e) {
//                System.out.println(e.getMessage());
//                new AsciiArt().outOfMap();
//                System.out.println("Dragon kill you");
//            }
//
//            quitGame = menu.restartGame();
//            if (quitGame) {
//                run = false;
//                asciiArt.goodBye();
//                return;
//            }
//        }

        boolean exitGame = false;
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<MenuActionEntry> entry = new ArrayList<>();
        entry.add(new CreatePlayerMenu(scanner, random));
        entry.add(new LunchGame(scanner));
        entry.add(new ExitGameMenu(scanner));
        MainMenu menu = new MainMenu(scanner,entry);
        AsciiArt asciiArt = new AsciiArt();

        while (run) {
            exitGame = menu.runMenu();
            if (exitGame) {
                run = false;
                asciiArt.goodBye();
                return;
            }

        }




   }
}
