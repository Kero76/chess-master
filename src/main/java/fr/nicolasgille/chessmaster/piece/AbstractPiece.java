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
package fr.nicolasgille.chessmaster.piece;

/**
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public abstract class AbstractPiece implements IPiece, Catchable, Moveable {

    /**
     * Indicate the abscissa of the piece.
     *
     * @since 1.0
     */
    protected int x;

    /**
     * Indicate the ordinate of the piece.
     *
     * @since 1.0
     */
    protected int y;

    /**
     * Indicate if the piece is catch or already present on the board.
     *
     * @since 1.0
     */
    protected boolean isCatch;

    /**
     * Indicate the color of the piece.
     *
     * @see PieceColor
     * @since 1.0
     * @version 1.0
     */
    protected PieceColor color;

    /**
     * Return the abscissa of the current piece.
     *
     * @return The abscissa of the piece.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Set the abscissa of the current piece.
     *
     * @param x New abscissa of the piece.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Return the ordinate of the piece.
     *
     * @return The ordinate of the piece.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Set the ordinate of the current piece.
     *
     * @param y New ordinate of the piece.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Return the color of the piece.
     *
     * @return
     *  The color of the piece.
     * @since 1.0
     * @version 1.0
     */
    public PieceColor getColor() {
        return this.color;
    }

    /**
     * Set the color of the piece.
     *
     * @param color
     *  New color of the piece.
     * @since 1.0
     * @version 1.0
     */
    public void setColor(PieceColor color) {
        this.color = color;
    }

    /**
     * Check if a piece can catchable by another piece.
     *
     * @return
     *  True if the piece passed on parameter can be catch by the current piece.
     *  False in other case.
     * @since 1.0
     * @version 1.0
     */
    public boolean isCatch() {
        return this.isCatch;
    }

    /**
     * change the state of the piece as <em>catch</em>.
     *
     * @since 1.0
     * @version 1.0
     */
    public void catchObject() {
        this.isCatch = true;
    }
}
