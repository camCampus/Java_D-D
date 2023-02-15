package src.board;
import src.board.cell.EmptyCell;
import java.util.ArrayList;
import java.util.List;
public class Board {
    private int boardLengt;
    private List<CellEntry> entry;
    public Board(List<CellEntry> entry) {
        this.boardLengt = 64;
        this.entry = entry;
    }

    public List<CellEntry> fillBoard() {
        List<CellEntry> allCell = new ArrayList<>();

        for (int i = 1; i < boardLengt + 1; i++) {
            allCell.add(new EmptyCell());
            }
        return allCell;
        }
    }

