package ru.job4j.chessboard.figures;

import ru.job4j.chessboard.board.Cell;

/**
 * Pawn.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Pawn extends Figure {
    public Pawn(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[0];
    }

    @Override
    public boolean isFigureOnThisCell(Figure figure, Cell source) {
        return false;
    }

   @Override
    public Pawn copy(Cell dest) {
        return new Pawn(dest);
    }
}
