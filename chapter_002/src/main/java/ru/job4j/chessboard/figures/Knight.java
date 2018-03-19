package ru.job4j.chessboard.figures;

import ru.job4j.chessboard.board.Cell;

/**
 * Knight.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Knight extends Figure {
    public Knight(Cell position) {
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
    public Knight copy(Cell dest) {
        return new Knight(dest);
    }
}
