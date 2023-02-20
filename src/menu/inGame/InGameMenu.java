package src.menu.inGame;

import src.menu.Menu;
import src.menu.MenuActionEntry;

import java.util.Scanner;

public class InGameMenu implements MenuActionEntry {

    private String label;
    private Scanner scanner;

    InGameMenu (Scanner scanner) {
        this.label = "Game Round";
        this.scanner = scanner;
    }
    @Override
    public void apply(Menu menu) {

    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public boolean isVisible() {
        return true;
    }
}
