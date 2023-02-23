package src.menu.inGame;

import src.board.cell.Cell;
import src.board.cell.LootCell;
import src.board.cell.MonsterCell;
import src.menu.Menu;
import src.menu.MenuActionEntry;

import java.util.Scanner;

public class Fight implements MenuActionEntry {

    private  Cell cell;

    public Fight (Cell cell){
        this.cell = cell;
    }
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
        boolean v = true;
        if (cell instanceof LootCell) {
            v = false;
        }
        return false;
    }

}
