package ru.job4j.chessboard.board;

import ru.job4j.chessboard.figures.Figure;

/**
 * Cell.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Cell {
    /** Cell's name*/
    private String name;
    private int x;
    private int y;

    /**
     * Constructor.
     * Create Cell with name and coordinats on board.
     * @param name Cell's name
     * @param x    х-coordinate on board
     * @param y    у-coordinate on board
     */
    public Cell(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * Give Cell's name
     * @return String name
     */
    public String getName(){
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
//        @Override
//    public boolean equals(Object obj) {
//            if (obj instanceof Cell) {
//                return obj != null && this.getX().equals(((Cell) obj).getX()) && this.getY().equals(((Cell) obj).getY());
//            }
//            return false;
//        }

}
