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
 * Representation of a Knight in the chess.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class Knight extends AbstractPiece {

    /**
     * Constructor of the Knight.
     *
     * @param x
     *  Initial abscissa of the knight.
     * @param y
     *  Initial ordinate of the knight.
     * @param color
     *  Color of the knight.
     * @since 1.0
     * @version 1.0
     */
    public Knight(int x, int y, PieceColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.symbol = ChessSymbol.KNIGHT.getSymbol();
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
        // Compute the length of the movement and if is equal 3 and call method checkArrivalCell(cell)
        return (Math.abs(cell.getY() - this.getY()) + Math.abs(cell.getX() - this.getX()) == 3 && super.checkArrivalCell(cell));
    }
}
