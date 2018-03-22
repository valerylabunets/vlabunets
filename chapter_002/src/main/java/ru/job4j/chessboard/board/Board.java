package ru.job4j.chessboard.board;
import java.util.Optional;

import ru.job4j.chessboard.figures.Figure;
import ru.job4j.chessboard.board.Cell;
import ru.job4j.chessboard.figures.King;

/**
 * Board.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Board {
    private Figure figure;
    private Cell sourse;
    private Cell dest;
    Figure[] figures = new Figure[32];
    private int figureIndex = 0;
    public Board() {
    }
    public Figure add(Figure figure) {
        this.figures[figureIndex++] = figure;
        return figure;
    }
    /**
    * methode move.
    * @return result.
    */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException, Figure.ImposibleMoveException {
        boolean result = false;
        for (Figure figure : figures) {
            if (figure != null && !figure.isFigureOnThisCell(figure, source)) {
                throw new FigureNotFoundException("no figure in cell");
            }
            if (figure != null && figure.isFigureOnThisCell(figure, source)) {
                Cell[] way = new Cell[0];
                try {
                    way = figure.way(source, dest);
                } catch (Figure.ImposibleMoveException e) {
                    e.printStackTrace();
                }
                for (Cell cell: way) {
                    if (cell.equals(figure)) {
                        throw new OccupiedWayException("the path is occupied by figures");
                    } else {
                         figure.copy(dest);
                    }
                }
            } else {
                throw new ImpossibleMoveException("the figure can not go there");
                }
                break;
        }
        return result;
    }

    public static class ImpossibleMoveException extends Exception {
        public ImpossibleMoveException(String s) {

        }
    }

    public static class OccupiedWayException extends Exception {
        public OccupiedWayException(String s) {

        }
    }

    public static class FigureNotFoundException extends Exception {
        public FigureNotFoundException(String s) {

        }
    }
}
