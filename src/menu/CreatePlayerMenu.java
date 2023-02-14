package src.menu;

import src.App;
import src.game.Game;
import src.perso.Personnage;
import src.perso.TypePersonage;
import src.perso.Warrior;
import src.perso.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CreatePlayerMenu implements MenuActionEntry{

    private String label;
    private Scanner scanner;

    private Random random;


    public CreatePlayerMenu (Scanner scanner, Random random) {
        this.label = "Create Player";
        this.scanner = scanner;
        this.random = random;
    }

    @Override
    public void apply(MainMenu menu) {
        System.out.println("CreatePlayerMenu TODO");

        List<MenuActionEntry> entries = new ArrayList<>();


        //Création d'une classe anonyme qui implemente l'interface MenuActionEntry
        entries.add(new MenuActionEntry() {

            @Override
            public void apply(MainMenu menu) {
                System.out.println("Enter the player name");
                String playerName = CreatePlayerMenu.this.scanner.nextLine();

                int playerType;
                boolean valid;
                do {
                    System.out.println("Select player type");
                    System.out.println(0 + " - " + TypePersonage.Warrior.name());
                    System.out.println(1 + " - " + TypePersonage.Wizard.name());
                     playerType = CreatePlayerMenu.this.scanner.nextInt();
                    CreatePlayerMenu.this.scanner.nextLine();

                    switch (playerType) {
                        case 0 -> {
                            Personnage personnage = new Warrior(playerName, TypePersonage.Warrior);
                            App.getInstance().setPersonnage(personnage, CreatePlayerMenu.this.random);
                            valid = true;

                        }
                        case 1 -> {
                            Personnage personnage = new Wizard(playerName, TypePersonage.Wizard);
                            App.getInstance().setPersonnage(personnage, CreatePlayerMenu.this.random);
                            valid = true;

                        }
                        default -> valid = false;
                    }

                } while (!valid);

            }

            @Override
            public String getLabel() {
                return null;
            }
        });
        MainMenu subMenu = new MainMenu(this.scanner, entries);
        for (int i=0; i< entries.size(); i++) {
            entries.get(i).apply(subMenu);
        }
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
