package ru.job4j.chessboard.figures;

import ru.job4j.chessboard.board.Cell;

/**
 * Bishop.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    /**
     * method way.
     *
     * @return result.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        int sx = source.getX();
        int dx = dest.getX();
        int sy = source.getY();
        int dy = dest.getY();
        int size = Math.abs(sx - dx);
        Cell[] cells = new Cell[size];
        int index;
        Cell[] result = cells;
        int deltax = Integer.compare(sx, dx);
        int deltay = Integer.compare(sy, dy);
        if (Math.abs(sx - dx) == Math.abs(sy - dy)) {
                for (index = 0; index < size; index = size) {
                    cells[index] = new Cell(position.getName(), sx + deltax, sy + deltay);
                }

            } else {
               try {
                   throw  new ImposibleMoveException();
               }  catch (ImposibleMoveException e) {
                   e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    @Override
    public boolean isFigureOnThisCell(Figure figure, Cell source) {
        return true;
    }
}

