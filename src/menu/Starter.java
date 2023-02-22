package src.menu;

import src.App;
import src.board.LevelSelection;
import src.items.attack.Bow;
import src.items.attack.Sword;
import src.perso.Character;
import src.perso.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter implements MenuActionEntry{

    private Scanner scanner;

    public Starter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void apply(Menu menu) {
        List<MenuActionEntry> selection = new ArrayList<>();
        selection.add(new MenuActionEntry() {
            @Override
            public void apply(Menu menu) {
                Character player = App.getInstance().getPersonnage();
                player.getInventory().addInventoryItem(new Sword(LevelSelection.Easy));
            }

            @Override
            public String getLabel() {
                return "Sword";
            }

            @Override
            public boolean isVisible() {
                return true;
            }
        });

        selection.add(new MenuActionEntry() {
            @Override
            public void apply(Menu menu) {
                Character player = App.getInstance().getPersonnage();
                player.getInventory().addInventoryItem(new Bow(LevelSelection.Easy));
            }

            @Override
            public String getLabel() {
                return "Bow";
            }

            @Override
            public boolean isVisible() {
                return true;
            }
        });

        new Menu(this.scanner, selection).runMenu();
    }

    @Override
    public String getLabel() {
        return "Select weapon";
    }

    @Override
    public boolean isVisible() {
        return true;
    }
}
