package src;

import src.asset.AsciiArt;
import src.menu.*;
import src.menu.createPlayer.CreatePlayerMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        //--------| DATABASE
        try {
            new database();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //--------| MENU
        boolean exitGame = false;
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        AsciiArt asciiArt = new AsciiArt();
        List<MenuActionEntry> entry = new ArrayList<>();
        entry.add(new CreatePlayerMenu(scanner, random));
        entry.add(new LunchGame(scanner, asciiArt));
        entry.add(new ExitGameMenu(scanner));
        Menu menu = new Menu(scanner,entry);


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
