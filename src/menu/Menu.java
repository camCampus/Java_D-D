package src.menu;

import java.util.List;
import java.util.Scanner;

/**
 * Classe responsable d'afficher les options du menu.
 * Les options sont des classes qui implemente l'interface MenuActionEntry
 */

public class Menu {
    private Scanner scanner;
    private List<MenuActionEntry> entry;

    private boolean exitGame;

 public Menu(Scanner scanner, List<MenuActionEntry> entry) {
     this.scanner = scanner;
     this.entry = entry;
     this.exitGame = false;
 }

    public boolean runMenu() {

        int max = this.entry.size();

        int userChoice;
        boolean valid;
        do {
            System.out.println("Menu navigation enter a number");

            for (int i = 0; i < this.entry.size(); i++) {
                    if (this.entry.get(i).isVisible()) {
                        System.out.println(i + " - " + this.entry.get(i).getLabel());
                    }
            }
            userChoice = this.scanner.nextInt();
            this.scanner.nextLine();

            try {
                this.entry.get(userChoice).apply(this);
                valid = true;
            } catch (IndexOutOfBoundsException e) {
                valid = false;
            }
        } while (!valid);

        return this.exitGame;
    }

    @Override
    public String toString() {
        return "MainMenu{" +
                "entry=" + entry +
                '}';
    }

    public boolean exitGame() {
     return this.exitGame = true;
    }
    public List<MenuActionEntry> getEntry() {
        return entry;
    }


}
