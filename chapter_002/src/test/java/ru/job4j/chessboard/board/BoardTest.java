package ru.job4j.chessboard.board;

import org.junit.Test;
import ru.job4j.chessboard.figures.Bishop;
import ru.job4j.chessboard.figures.Figure;
import ru.job4j.chessboard.figures.King;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Valeriy Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BoardTest {

    /**
     * Test add .
     */
    @Test
    public void whenAddFigure() {

    }
    /**
     * Test move .
     */
    @Test
    public void whenCellContainsFigure() throws Figure.ImposibleMoveException, Board.OccupiedWayException, Board.ImpossibleMoveException, Board.FigureNotFoundException {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell("C1", 3, 1));
        board.add(bishop);
        King king = new King(new Cell("D1", 4, 1));
        Cell sourseBishop = new Cell("C1", 3, 1);
        Cell destBishop = new Cell("F4", 6, 4);
        boolean result = board.move(sourseBishop, destBishop);
        boolean expected = false;
        assertThat(result, is(expected));
    }
}