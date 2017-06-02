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
public interface IPiece {

    /**
     * Return the abscissa of the current piece.
     *
     * @return
     *  The abscissa of the piece.
     * @since 1.0
     * @version 1.0
     */
    int getX();

    /**
     * Set the abscissa of the current piece.
     *
     * @param x
     *  New abscissa of the piece.
     * @since 1.0
     * @version 1.0
     */
    void setX(int x);

    /**
     * Return the ordinate of the piece.
     *
     * @return
     *  The ordinate of the piece.
     * @since 1.0
     * @version 1.0
     */
    int getY();

    /**
     * Set the ordinate of the current piece.
     *
     * @param y
     *  New ordinate of the piece.
     * @since 1.0
     * @version 1.0
     */
    void setY(int y);

    /**
     * Return the color of the piece.
     *
     * @return
     *  The color of the piece.
     * @since 1.0
     * @version 1.0
     */
    PieceColor getColor();

    /**
     * Set the color of the piece.
     *
     * @param color
     *  New color of the piece.
     * @since 1.0
     * @version 1.0
     */
    void setColor(PieceColor color);
}
