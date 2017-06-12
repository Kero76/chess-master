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
package fr.nicolasgille.chessmaster.model.board;

/**
 * Interface present to specified methods present on each board of the Chess Master.
 *
 * You can create you're own board if you like. So you must only implements the methods present on this interface,
 * and your board can be used in Chess Master.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public interface IBoard {

    /**
     * Get the width of the board.
     *
     * @return
     *  The width of the board.
     *
     * @since 1.0
     * @version 1.0
     */
    int getX();

    /**
     * Set the width of the board.
     *
     * @param x
     *  New width for the board.
     *
     * @since 1.0
     * @version 1.0
     */
    void setX(int x);

    /**
     * Get the height of the board.
     *
     * @return
     *  The height of the board.
     *
     * @since 1.0
     * @version 1.0
     */
    int getY();

    /**
     * Set the height of the board.
     *
     * @param y
     *  New height of the board.
     *
     * @since 1.0
     * @version 1.0
     */
    void setY(int y);

    /**
     * Get the cell present on coordinate x/y.
     *
     * @param x
     *  The abscissa of the cell at get.
     * @param y
     *  The coordinate of the cell at get.
     * @return
     *  The cell present on x/y.
     * @throws IllegalArgumentException
     *  Argument passed on parameter are not between right value.
     * @since 1.0
     * @version 1.0
     */
    ICell getCell(int x, int y) throws IllegalArgumentException ;
}
