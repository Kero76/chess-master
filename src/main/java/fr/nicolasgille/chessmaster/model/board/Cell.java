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
 * Implement of <code>ICell</code> interface for the <code>ChessBoard</code>.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class Cell implements ICell {

    /**
     * Piece present on the cell.
     * If the cell is empty, piece must be null.
     *
     * @since 1.0
     */
    private IPiece piece;

    /**
     * Abscissa of the cell.
     *
     * @since 1.0
     */
    private int x;

    /**
     * Ordinate of the cell.
     *
     * @since 1.0
     */
    private int y;

    /**
     * Constructor of an empty cell.
     *
     * @param x
     *  Abscissa of the cell.
     * @param y
     *  Ordinate of the cell.
     * @since 1.0
     * @version 1.0
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor of a cell who contains initially a piece.
     *
     * @param x
     *  Abscissa of the cell.
     * @param y
     *  Ordinate of the cell.
     * @param piece
     *  Piece present on the cell.
     * @since 1.0
     * @version 1.0
     */
    public Cell(int x, int y, IPiece piece) {
        this(x, y);
        this.piece = piece;
    }

    /**
     * Return the abscissa of the current cell.
     *
     * @return The abscissa of the cell.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Set the abscissa of the current cell.
     *
     * @param x New abscissa of the cell.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Return the ordinate of the cell.
     *
     * @return The ordinate of the cell.7
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Set the ordinate of the current cell.
     *
     * @param y New ordinate of the cell.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Return the piece present on the cell.
     *
     * @return The piece who occupied the cell.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public IPiece getPiece() {
        return this.piece;
    }

    /**
     * Set the current piece who occupied the cell.
     *
     * @param piece New piece present on the cell, or null when no piece occupied the cell.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void setPiece(IPiece piece) {
        this.piece = piece;
    }

    /**
     * Check if the cell is free or occupied by a piece.
     *
     * @return True if the cell is occupied, false in other case.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public boolean isOccupied() {
        return !(this.piece == null);
    }
}
