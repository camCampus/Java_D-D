package src.perso.inventory;

import src.App;
import src.menu.Menu;
import src.menu.MenuActionEntry;
import src.perso.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddItem implements MenuActionEntry {

    private Scanner scanner;
    private Character player;
    public AddItem(Scanner scanner) {
        this.scanner = scanner;
        this.player = App.getInstance().getPersonnage();
    }

    @Override
    public void apply(Menu menu) {

            System.out.println("Inventory full you have to drop something");
            List<MenuActionEntry> drop = new ArrayList<>();
            drop.add(new MenuActionEntry() {
                @Override
                public void apply(Menu menu) {
                    player.getInventory().remove(0);
                }

                @Override
                public String getLabel() {
                    return player.getInventory().get(0).getName();
                }

                @Override
                public boolean isVisible() {
                    return true;
                }
            });

            drop.add(new MenuActionEntry() {
                @Override
                public void apply(Menu menu) {
                    player.getInventory().remove(1);
                }

                @Override
                public String getLabel() {
                    return player.getInventory().get(1).getName();
                }

                @Override
                public boolean isVisible() {
                    return true;
                }
            });
            new Menu(this.scanner, drop).runMenu();
    }

    @Override
    public String getLabel() {
        return "Remove from inventory";
    }

    @Override
    public boolean isVisible() {
        return true;
    }
}
