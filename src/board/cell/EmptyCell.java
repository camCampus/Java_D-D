package src.board.cell;

import src.items.Item;

public class EmptyCell extends Cell{

    @Override
    public Cell getTypeCell() {
        return this;
    }

    @Override
    public Item getAllItem() {
        return null;
    }

    @Override
    public void apply() {
        System.out.println("No effect empty cell");
    }
}
