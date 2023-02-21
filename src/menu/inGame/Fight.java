package src.menu.inGame;

import src.board.cell.Cell;
import src.board.cell.MonsterCell;
import src.menu.Menu;
import src.menu.MenuActionEntry;

import java.util.Scanner;

public class Fight implements MenuActionEntry {


    @Override
    public void apply(Menu menu) {}
    @Override
    public String getLabel() {
        return "Fight";
    }
    @Override
    public boolean isVisible() {
        return true;
    }

    public boolean isFigth() {
        return true;
    }

}
