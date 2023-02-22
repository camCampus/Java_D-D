package src.menu.inGame;

import src.board.cell.Cell;
import src.menu.Menu;
import src.menu.MenuActionEntry;

public class Inventory implements MenuActionEntry {

    private Cell cell;
    private boolean visible;

    public Inventory(Cell cell) {
        this.cell = cell;
        this.visible = true;
    }

    @Override
    public void apply(Menu menu) {

    }

    @Override
    public String getLabel() {
        return "Inventory";
    }

    @Override
    public boolean isVisible() {
//        if (this.cell instanceof LootCell) {
//            this.visible = true;
//        }
        return this.visible;
    }
}
