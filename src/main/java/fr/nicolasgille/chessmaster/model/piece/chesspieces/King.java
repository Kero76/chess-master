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
package fr.nicolasgille.chessmaster.model.piece.chesspieces;

import fr.nicolasgille.chessmaster.model.board.ICell;
import fr.nicolasgille.chessmaster.model.piece.AbstractPiece;
import fr.nicolasgille.chessmaster.model.piece.PieceColor;

/**
 * Representation of the King in chess.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class King extends AbstractPiece {

    /**
     * Constructor of the King.
     *
     * @param x
     *  Initial abscissa of the king.
     * @param y
     *  Initial ordinate of the king.
     * @param color
     *  Color of the king.
     * @since 1.0
     * @version 1.0
     */
    public King(int x, int y, PieceColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.symbol = ChessSymbol.KING.getSymbol();
    }

    /**
     * Check if a piece can be moved in another cell of the board.
     *
     * @param cell
     *  The cell where the piece would move.
     * @return
     *  A boolean to indicate if the piece can be moved or not in the new Cell.
     * @since 1.0
     * @version 1.0
     */
    @Override
    public boolean isMoveable(ICell cell) {
        // If movement length equal 1, king move like rook.
        if (Math.abs(cell.getX() - this.getX()) + Math.abs(cell.getY() - this.getY()) == 1) {
            return super.checkArrivalCell(cell);
        }

        // If movement length equal 2, king move like bishop.
        if (Math.abs(cell.getX() - this.getX()) + Math.abs(cell.getY() - this.getY()) == 2) {
            return this.bishopMovement(cell) && super.checkArrivalCell(cell);
        }

        return false;
    }

    /**
     * Check the movement of the king when it moved like a bishop.
     *
     * To check the movement, it check only if the abscissa and the ordinate are different.
     *
     * @param cell
     *  Cell of arrival for the king.
     * @return
     *  True of the movement can be possible, false in other case.
     * @since 1.0
     * @version 1.0
     */
    private boolean bishopMovement(ICell cell) {
        return cell.getX() != this.getX() && cell.getY() != this.getY();
    }
}
