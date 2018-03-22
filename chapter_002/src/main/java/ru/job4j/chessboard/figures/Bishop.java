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
    /*
    * Метод должен работать так. dest - задает  ячейку, куда следует пойти. Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
    * Если фигура туда пойти не может. выбросить исключение ImposibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        int sx = source.getX();
        int dx = dest.getX();
        int sy = source.getY();
        int dy = dest.getY();
        int size = Math.abs(sx - dx);
        Cell[] cells = new Cell[size];
        int index = 0;
        Cell[] result = cells;
        if (Math.abs(sx - dx) == Math.abs(sy - dy)) {
            if (sx - dx > 0 && sy - dy > 0) {
                for (index = 0; index < size; index++) {
                    cells[index] = new Cell(position.getName(), sx - index, sy - index);
                }
            }
            if (sx - dx > 0 && dy - sy > 0) {
                 for (index = 0; index < size; index++) {
                     cells[index] = new Cell(position.getName(), sx - index, sy + index);
                    }
            }
            if (dx - sx > 0 && sy - dy > 0) {
                for (index = 0; index < size; index++) {
                    cells[index] = new Cell(position.getName(), sx + index, sy - index);
                }
            }
            if (dx - sx > 0 && dy - sy > 0) {
                for (index = 0; index < size; index++) {
                    cells[index] = new Cell(position.getName(), sx + index, sy + index);
                }
            }

        } else {
            new ImposibleMoveException();
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
