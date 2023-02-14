package src.menu;

import java.util.Scanner;

public class LunchGame implements MenuActionEntry {

    private String label;
    private Scanner scanner;


    public LunchGame(Scanner scanner) {
        this.label = "Lunch Game";
        this.scanner = scanner;
    }

    @Override
    public void apply(MainMenu menu) {

    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
