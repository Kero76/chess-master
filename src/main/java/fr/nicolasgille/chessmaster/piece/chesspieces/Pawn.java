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
import fr.nicolasgille.chessmaster.piece.IPiece;
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
        this.isCatch = false;
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
        // If Abscissa is the same (this.getX == cell.getX), so pawn moves forward.
        if (this.getX() == cell.getX()) {
            // If the pawn try to move from twice cells,
            // it check previously if he don't move, and the arrival cell is at Y +/- 2
            if (!this.hasMoved() && this.getY() == cell.getY() + 2 || this.getY() == cell.getY() - 2) {
                // Moved on top of the chessboard.
                if (this.getY() == cell.getY() + 2) {
                    if (!ChessBoard.getInstance().getCell(this.getX() + 1, this.getY() + 1).isOccupied() && !cell.isOccupied()) {
                        return true;
                    }
                }
                // Moved on the bottom of the chessboard.
                else {
                    if (!ChessBoard.getInstance().getCell(this.getX() - 1, this.getY() - 1).isOccupied() && !cell.isOccupied()) {
                        return true;
                    }
                }
            }

            // Then, if pawn try to move once,
            // it check if the cell forward is free and the movement is to 1 cell.
            if (!cell.isOccupied() && this.getY() + 1 == cell.getY() || this.getY() - 1 == cell.getY()) {
                return true;
            }
        }

        // If Abscissa of the pawn is cell.getX +/- 1, so the pawn try to catch a piece.
        if (cell.getX() == this.getX() + 1 || cell.getX() == this.getX() - 1) {
            // Then, it check if the cell forward is occupied and the movement is to 1 cell.
            if (cell.isOccupied() && this.getY() + 1 == cell.getY() || this.getY() - 1 == cell.getY()) {
                // If the color of the piece on cell is different to the current color of the piece.
                if (cell.getPiece().getColor() != this.getColor()) {
                    return true;
                }
            }
        }

        // In other case, the movement not authorized.
        return false;
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
        if (!this.hasMoved()) {
            this.hasMoved = true;
        }
        super.move(cell);
    }
}
