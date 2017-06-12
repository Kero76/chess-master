/*
 * This file is part of Chess Master.
 *
 * Chess Master is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Chess Master is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Chess Master. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.nicolasgille.chessmaster.board;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation of a chess board.
 *
 * To create a chess board instance, you must call the method <code>getInstance()</code> to get the unique instance of
 * the chess board. If you would change the size of the chess board, you must call the methods
 * <code>setX(int)</code> and <code>setY(int)</code> before start the game.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class ChessBoard implements IBoard {

    /**
     * Default width of the chess board.
     *
     * @since 1.0
     */
    private final static int DEFAULT_X = 8;

    /**
     * Default height of the chess board.
     *
     * @since 1.0
     */
    private final static int DEFAULT_Y = 8;

    /**
     * Unique instance of ChessBoard.
     *
     * @since 1.0
     */
    private static ChessBoard instance = null;

    /**
     * A representation of the board as a Map.
     * The key representation the coordinate of the cell, and the value represent the cell.
     *
     * @since 1.0
     */
    private Map<String, ICell> boards;

    /**
     * Custom width of the chess board.
     *
     * @since 1.0
     */
    private int x;

    /**
     * Custom height of the chess board.
     *
     * @since 1.0
      */
    private int y;

    /**
     * Default constructor used to generate classic chess board.
     *
     * @since 1.0
     * @version 1.0
     */
    private ChessBoard() {
        this.x = DEFAULT_X;
        this.y = DEFAULT_Y;

        this.boards = new HashMap<>();
        for (int x = 0; x < DEFAULT_X; ++x) {
            for (int y = 0; y < DEFAULT_X; ++y) {
                this.boards.put(x + "" + y, new Cell(x, y));
            }
        }
    }

    /**
     * Return the unique instance of ChessBoard.
     *
     * Before returning the instance of ChessBoard, it check if the instance already instantiate.
     * If this instance not instantiate before, it instantiate it and return the instance with classical size.
     * You can change the size of the chess board to set the width and the height with the method <code>setX(int)</code>
     * and <code>setY(int)</code>.
     *
     * @return
     *  The unique instance of ChessBoard.
     * @since 1.0
     * @version 1.0
     */
    public static ChessBoard getInstance() {
        if (ChessBoard.instance == null) {
            ChessBoard.instance = new ChessBoard();
        }
        return ChessBoard.instance;
    }

    /**
     * Get the width of the board.
     *
     * @return The width of the board.
     *
     * @since 1.0
     * @version 1.0
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Set the width of the board.
     *
     * @param x New width for the board.
     *
     * @since 1.0
     * @version 1.0
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the height of the board.
     *
     * @return The height of the board.
     *
     * @since 1.0
     * @version 1.0
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Set the height of the board.
     *
     * @param y New height of the board.
     *
     * @since 1.0
     * @version 1.0
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the cell present on coordinate x/y.
     *
     * @param x The abscissa of the cell at get.
     * @param y The coordinate of the cell at get.
     * @return The cell present on x/y.
     *
     * @throws IllegalArgumentException
     *  Argument passed on parameter are not between right value.
     *
     * @since 1.0
     * @version 1.0
     */
    @Override
    public ICell getCell(int x, int y) throws IllegalArgumentException {
        // Error occurred with x argument.
        if (x > this.getX() || x < 0) {
            throw new IllegalArgumentException("0 <= x <= getX()");
        }

        // Error occurred with y argument.
        if (y > this.getY() || y < 0) {
            throw new IllegalArgumentException("0 <= y <= getY()");
        }

        return this.boards.get(x + "" + y);
    }
}
