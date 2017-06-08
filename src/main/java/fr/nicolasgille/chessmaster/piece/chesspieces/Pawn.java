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
package fr.nicolasgille.chessmaster.piece.chesspieces;

import fr.nicolasgille.chessmaster.board.ChessBoard;
import fr.nicolasgille.chessmaster.board.ICell;
import fr.nicolasgille.chessmaster.piece.AbstractPiece;
import fr.nicolasgille.chessmaster.piece.PieceColor;

/**
 * Representation of a Pawn present in Chess.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class Pawn extends AbstractPiece {

    /**
     * Indicate if the pawn has moved during the game or not.
     *
     * @since 1.0
     */
    private boolean hasMoved;

    /**
     * Constructor of a Pawn.
     *
     * @param x
     *  Initial abscissa of the pawn.
     * @param y
     *  Initial ordinate of the pawn.
     * @param color
     *  Color of the pawn.
     * @since 1.0
     * @version 1.0
     */
    public Pawn(int x, int y, PieceColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Return if the piece have already moved or not.
     *
     * In fact, in the chess game, the pawn can moved two cells only if not moved before.
     * So, this method can indicate if the pawn don't move or has already moved before.
     *
     * @return
     *  True if the piece have already moved. False in other case.
     * @since 1.0
     * @version 1.0
     */
    public boolean hasMoved() {
        return this.hasMoved;
    }

    /**
     * Check if a piece can be moved in another cell of the board.
     *
     * @param cell The cell where the piece would move.
     *
     * @return A boolean to indicate if the piece can be moved or not in the new Cell.
     * @since 1.0
     * @version 1.0
     */
    @Override
    public boolean isMoveable(ICell cell) {
        // If movement length equal 2, the pawn can try to catch another piece, or moved two cells from initial cell.
        if (Math.abs(cell.getX() - this.getX()) + Math.abs(cell.getY() - this.getY()) == 2) {
            // Pawn moved from initial cell.
            if (!this.hasMoved() && this.getX() == cell.getX()) {
                // Moved on top and check the way of the piece. Same work for bottom way.
                if (this.getY() == cell.getY() + 2) {
                    return !ChessBoard.getInstance().getCell(this.getX() - 1, this.getY() - 1).isOccupied() && !cell.isOccupied();
                } else {
                    return !ChessBoard.getInstance().getCell(this.getX() + 1, this.getY() + 1).isOccupied() && !cell.isOccupied();
                }
            }

            // Pawn try to catch piece from diagonal cell.
            if (cell.getY() != this.getY() && cell.getX() != this.getX()) {
                return cell.isOccupied() && cell.getPiece().getColor() != this.getColor();
            }
        }

        // If movement length equal 1, the pawn move on forward/backward of the current position.
        if (Math.abs(cell.getX() - this.getX()) + Math.abs(cell.getY() - this.getY()) == 1) {
            return !cell.isOccupied();
        }
        return false;
    }

    /**
     * Move the piece on <em>cell</em>.
     *
     * @param cell
     *  Arrival cell of the piece.
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void move(ICell cell) {
        if (!this.hasMoved()) {
            this.hasMoved = true;
        }
        super.move(cell);
    }
}
