package src.menu;

import src.App;
import src.board.LevelSelection;
import src.items.attack.Bow;
import src.items.attack.Spell;
import src.items.attack.Stick;
import src.items.attack.Sword;
import src.perso.Character;
import src.perso.TypeCharacter;
import src.perso.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter implements MenuActionEntry{

    private Scanner scanner;
    private Character player;
    public Starter(Scanner scanner) {
        this.scanner = scanner;
        this.player = App.getInstance().getPersonnage();
    }

    @Override
    public void apply(Menu menu) {
        List<MenuActionEntry> selection = new ArrayList<>();

        if (player.getType() == TypeCharacter.Warrior) {
            selection.add(new MenuActionEntry() {
                @Override
                public void apply(Menu menu) {
                    player.getInventory().add(new Sword(LevelSelection.Easy));
                    player.setAttackItem(player.getInventory().get(0));
                    System.out.println(player.getInventory().get(0).toString());
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
                    player.getInventory().add(new Bow(LevelSelection.Easy));
                    player.setAttackItem(player.getInventory().get(0));
                    System.out.println(player.getInventory().get(0).toString());
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
        } else {
            selection.add(new MenuActionEntry() {
                @Override
                public void apply(Menu menu) {
                    player.getInventory().add(new Stick(LevelSelection.Easy));
                    player.setAttackItem(player.getInventory().get(0));
                    System.out.println(player.getInventory().get(0).toString());
                }

                @Override
                public String getLabel() {

                    return "Stick";
                }

                @Override
                public boolean isVisible() {
                    return true;
                }
            });

            selection.add(new MenuActionEntry() {
                @Override
                public void apply(Menu menu) {
                    player.getInventory().add(new Spell(LevelSelection.Easy));
                    player.setAttackItem(player.getInventory().get(0));
                    System.out.println(player.getInventory().get(0).toString());
                }

                @Override
                public String getLabel() {
                    return "Spell";
                }

                @Override
                public boolean isVisible() {
                    return true;
                }
            });
        }


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
