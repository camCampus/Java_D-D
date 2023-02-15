package src.factory;

import src.App;
import src.board.Board;
import src.board.CellEntry;
import src.board.cell.EmptyCell;
import src.board.cell.LootCell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FactoryBoard {
    private List<CellEntry> emptyCells;
    private int boardLength;

    public FactoryBoard() {
        this.boardLength = App.getInstance().getBoardSize();
        this.emptyCells = new ArrayList<>();
    }

    public Board createBoard() {
        Board emptyBoard = new Board(emptyCellList());


        return new Board(this.emptyCells);

    }

    private List<CellEntry> emptyCellList() {
        for (int i = 1; i < boardLength + 1; i++) {
            emptyCells.add(new EmptyCell());
        }
        return this.emptyCells;
    }

    private void Fill() {

        //Empty 12
        //Loot 10
        //Monster 10

    }

    private List<CellEntry> easyList() {

        List<CellEntry> easyList = new ArrayList<>();
        int emptyCell = 12;
        int lootCell = 10;
        int monsterCell = 10;

        for (int i = 1; i < boardLength / 2 + 1; i++) {
            easyList.add(new LootCell(FillLevel.Easy));
        }
        return List;
    }

}