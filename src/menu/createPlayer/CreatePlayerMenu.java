package src.menu.createPlayer;

import src.App;
import src.menu.Menu;
import src.menu.MenuActionEntry;
import src.perso.Character;
import src.perso.TypeCharacter;
import src.perso.Warrior;
import src.perso.Wizard;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CreatePlayerMenu implements MenuActionEntry {

    private String label;
    private Scanner scanner;

    private Random random;
    private boolean visible;
    private String playerName;
    public CreatePlayerMenu (Scanner scanner, Random random) {
        this.label = "Create Player";
        this.scanner = scanner;
        this.random = random;
        this.visible = true;
        this.playerName = "Unnamed";
    }

    @Override
    public void apply(Menu menu) {

        List<MenuActionEntry> entries = new ArrayList<>();
        System.out.println("Enter the player name");
        CreatePlayerMenu.this.playerName = CreatePlayerMenu.this.scanner.nextLine();
        entries.add(new MenuActionEntry() {
            @Override
            public void apply(Menu menu) {
                Character character = new Warrior(playerName, TypeCharacter.Warrior);
                App.getInstance().setPersonnage(character, CreatePlayerMenu.this.random, CreatePlayerMenu.this.scanner);
            }

            @Override
            public String getLabel() {
                return TypeCharacter.Warrior.name();
            }

            @Override
            public boolean isVisible() {
                return true;
            }
        });

        entries.add(new MenuActionEntry() {
            @Override
            public void apply(Menu menu) {
                Character character = new Wizard(playerName, TypeCharacter.Wizard);
                App.getInstance().setPersonnage(character, CreatePlayerMenu.this.random, CreatePlayerMenu.this.scanner);
            }

            @Override
            public String getLabel() {
                return TypeCharacter.Wizard.name();
            }

            @Override
            public boolean isVisible() {
                return true;
            }
        });

        Menu subMenu = new Menu(this.scanner, entries);
        subMenu.runMenu();
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }
}
