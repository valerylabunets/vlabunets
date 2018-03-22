package ru.job4j.chessboard.figures;


import ru.job4j.chessboard.board.Cell;

/**
 * Figure.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public abstract class Figure {

    public final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }
   /**
    * abstract method way.
    *
    */
    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;
    /**
     * abstract method isFigureOnThisCell.
     *
     */
    public abstract boolean isFigureOnThisCell(Figure figure, Cell source);
    /**
     * abstract method copy.
     *
     */
    public abstract Figure copy(Cell dest);

    public class ImposibleMoveException extends Exception {
        public ImposibleMoveException() {
            System.out.println("the figure can not go there");
        }
    }
}
