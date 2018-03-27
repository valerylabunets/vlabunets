package ru.job4j.chessboard.board;

import org.junit.Test;
import ru.job4j.chessboard.figures.Bishop;
import ru.job4j.chessboard.figures.Figure;
import ru.job4j.chessboard.figures.King;

import javax.tools.Diagnostic;

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
//        try {
//            throw new Board.FigureNotFoundException("no figure in cell");
//        } catch (Board.FigureNotFoundException s) {
//            System.out.println("no figure in cell");
//        }
//        try {
//            throw new Figure.ImposibleMoveException;
//        } catch (Figure.ImposibleMoveException e) {
//            e.printStackTrace();
//        }
//        try {
//            throw new Board.OccupiedWayException("the path is occupied by figures");
//        } catch (Board.OccupiedWayException s) {
//            System.out.println("the path is occupied by figures");
//        }
//        try {
//            throw new Board.ImpossibleMoveException("the figure can not go there");
//        } catch (Board.ImpossibleMoveException s) {
//            System.out.println("the figure can not go there");
//        }
//        assertTrue(result);
        assertThat(result, is(expected));
    }
}