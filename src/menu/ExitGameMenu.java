package src.menu;

import java.util.Scanner;

public class ExitGameMenu implements MenuActionEntry{
    private String label;
    private Scanner scanner;

    public ExitGameMenu (Scanner scanner) {
        this.label = "Exit Game";
        this.scanner = scanner;

    }
    @Override
    public void apply(MainMenu menu) {
        menu.exitGame();
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
