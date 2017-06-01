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

import fr.nicolasgille.chessmaster.piece.IPiece;

/**
 * Interface present to define a cell for an <code>IBoard</code>.
 *
 * In fact, a board contains many cells to define the area of the chess board.
 * So, each cell can be define by this interface. So you can add your own cell, only if it implement this interface.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public interface ICell {

    /**
     * Return the abscissa of the current cell.
     *
     * @return
     *  The abscissa of the cell.
     * @since 1.0
     * @version 1.0
     */
    int getX();

    /**
     * Set the abscissa of the current cell.
     *
     * @param x
     *  New abscissa of the cell.
     * @since 1.0
     * @version 1.0
     */
    void setX(int x);

    /**
     * Return the ordinate of the cell.
     *
     * @return
     *  The ordinate of the cell.7
     * @since 1.0
     * @version 1.0
     */
    int getY();

    /**
     * Set the ordinate of the current cell.
     *
     * @param y
     *  New ordinate of the cell.
     * @since 1.0
     * @version 1.0
     */
    void setY(int y);

    /**
     * Return the piece present on the cell.
     *
     * @return
     *  The piece who occupied the cell.
     * @since 1.0
     * @version 1.0
     */
    IPiece getPiece();

    /**
     * Set the current piece who occupied the cell.
     *
     * @param piece
     *  New piece present on the cell, or null when no piece occupied the cell.
     * @since 1.0
     * @version 1.0
     */
    void setPiece(IPiece piece);

    /**
     * Check if the cell is free or occupied by a piece.
     *
     * @return
     *  True if the cell is occupied, false in other case.
     * @since 1.0
     * @version 1.0
     */
    boolean isOccupied();
}
