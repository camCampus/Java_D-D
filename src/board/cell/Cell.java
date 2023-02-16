package src.board.cell;

import src.board.Board;
import src.items.Item;
import src.perso.TypeCharacter;

import java.util.List;

public abstract class Cell {

    public void fillBoard(Board board) {
        List cell = board.getEntry();

    }
    public  abstract Cell getTypeCell();
    public abstract Item getAllItem();
}
