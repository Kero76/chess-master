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
package fr.nicolasgille.chessmaster.model.piece;

import fr.nicolasgille.chessmaster.model.board.ICell;

/**
 * Abstract class used to implements same methods from each subclass of piece.
 *
 * You can inherit this class to create your own piece type, for another game.
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
     * Indicate the color of the piece.
     *
     * @see PieceColor
     * @since 1.0
     */
    protected PieceColor color;

    /**
     * Symbol used to represent the piece.
     *
     * @since 1.0
     */
    protected char symbol;

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
     * Return the symbol of the piece to represent it on terminal display.
     *
     * @return The symbol of the piece for the terminal display.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public char getSymbol() {
        return this.symbol;
    }

    /**
     * Set the symbol used for represented on piece on terminal display.
     *
     * @param symbol New symbol for the piece.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Move the piece on <em>cell</em>.
     *
     * @param cell Arrival cell of the piece.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void move(ICell cell) {
        this.setX(cell.getX());
        this.setY(cell.getY());
    }

    /**
     * Check the cell of arrival of a movement.
     *
     * To check if the movement can be possible and valid.
     * It check if the cell is free, or if the cell is occupied and the color of the piece is different from this.
     * In that case, it return <code>true</code>. Otherwise, the method return <code>false</code>.
     *
     * @param cell
     *  Cell where the king try to move.
     * @return
     *  True if the movement can be accepted, false in other case.
     * @since 1.0
     * @version 1.0
     */
    protected boolean checkArrivalCell(ICell cell) {
        return (!cell.isOccupied() || (cell.isOccupied() && cell.getPiece().getColor() != this.getColor()));
    }
}
