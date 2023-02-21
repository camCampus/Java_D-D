package src.menu.inGame;

import src.board.cell.Cell;
import src.board.cell.LootCell;
import src.menu.Menu;
import src.menu.MenuActionEntry;

public class Loot implements MenuActionEntry {

    private Cell cell;
    private boolean visible;

    public Loot(Cell cell) {
        this.cell = cell;
        this.visible = false;
    }

    @Override
    public void apply(Menu menu) {

    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public boolean isVisible() {
        if (this.cell instanceof LootCell) {
            this.visible = true;
        }
        return this.visible;
    }
}
