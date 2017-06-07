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
 * Representation of the Queen in chess.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class Queen extends AbstractPiece {

    /**
     * Constructor of the Queen.
     *
     * @param x
     *  Initial abscissa of the queen.
     * @param y
     *  Initial ordinate of the queen.
     * @param color
     *  Color of the queen.
     * @since 1.0
     * @version 1.0
     */
    public Queen(int x, int y, PieceColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Check if a piece can be moved in another cell of the board.
     *
     * @param cell The cell where the piece would move.
     *
     * @return A boolean to indicate if the piece can be moved or not in the new Cell.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public boolean isMoveable(ICell cell) {
        return rookMovement(cell) || bishopMovement(cell);
    }

    /**
     * Simulate the movement of the bishop.
     *
     * @param cell
     *  Arrival cell of the queen.
     * @return
     *  True if the movement is possible. False in other case.
     * @since 1.0
     * @version 1.0
     */
    private boolean bishopMovement(ICell cell) {
        // If the movement is equal in abscissa and in ordinate, so, the movement can be possible.
        if (Math.abs(cell.getX() - this.getX()) == Math.abs(cell.getY() - this.getY())) {

            // Check last cell : if occupied and the piece as the same color as the current piece, movement not authorized.
            if (ChessBoard.getInstance().getCell(cell.getX(), cell.getY()).isOccupied() &&
                    this.getColor() == ChessBoard.getInstance().getCell(cell.getX(), cell.getY()).getPiece().getColor()) {
                return false;
            }

            // If the ordinate of the piece is superior at the cell, the bishop move to the bottom.
            if (this.getY() > cell.getY()) {
                // If the abscissa of the piece is superior at the cell, the bishop move to the left.
                if (this.getX() > cell.getX()) {
                    // Loop on each cell present on the way of the bishop.
                    for (int x = this.getX(), y = this.getY(); (x > cell.getX() && y > cell.getY()); --x, --y) {
                        // If the cell is occupied by a piece, the movement is not authorized.
                        if (ChessBoard.getInstance().getCell(x, y).isOccupied() && this.getX() != x && this.getY() != y) {
                            return false;
                        }
                    }
                }
                // If the abscissa of the piece is inferior at the cell, the bishop move to the right.
                else {
                    // Loop on each cell present on the way of the bishop.
                    for (int x = this.getX(), y = this.getY(); (x > cell.getX() && y < cell.getY()); ++x, --y) {
                        // If the cell is occupied by a piece, the movement is not authorized.
                        if (ChessBoard.getInstance().getCell(x, y).isOccupied() && this.getX() != x && this.getY() != y) {
                            return false;
                        }
                    }
                }
            } else {
                // If the abscissa of the piece is superior at the cell, the bishop move to the left.
                if (this.getX() > cell.getX()) {
                    // Loop on each cell present on the way of the bishop.
                    for (int x = this.getX(), y = this.getY(); (x < cell.getX() && y > cell.getY()); --x, ++y) {
                        // If the cell is occupied by a piece, the movement is not authorized.
                        if (ChessBoard.getInstance().getCell(x, y).isOccupied() && this.getX() != x && this.getY() != y) {
                            return false;
                        }
                    }
                }
                // If the abscissa of the piece is inferior at the cell, the bishop move to the right.
                else {
                    // Loop on each cell present on the way of the bishop.
                    for (int x = this.getX(), y = this.getY(); (x < cell.getX() && y < cell.getY()); ++x, ++y) {
                        // If the cell is occupied by a piece, the movement is not authorized.
                        if (ChessBoard.getInstance().getCell(x, y).isOccupied() && this.getX() != x && this.getY() != y) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Simulate the movement of the rook.
     *
     * @param cell
     *  Arrival cell of the queen.
     * @return
     *  True if the movement is possible. False in other case.
     * @since 1.0
     * @version 1.0
     */
    private boolean rookMovement(ICell cell) {
        // If abscissa and ordinate are different is same time, movement not valid.
        if (this.getX() != cell.getX() && this.getY() != cell.getY()) {
            return false;
        }

        // If abscissa is the same as cell.
        if (this.getX() == cell.getX()) {
            // If the ordinate of the piece is superior at the cell, the rook move to the bottom.
            if (this.getY() > cell.getY()) {
                // Check each cell to see if is occupied and return false if the cell is occupied.
                for (int y = this.getY() - 1; y > cell.getY(); y--) {
                    if (ChessBoard.getInstance().getCell(this.getX(), y).isOccupied()) {
                        return false;
                    }
                }
            }
            // If the ordinate of the piece is inferior at the cell, the rook move to the bottom.
            else {
                // Check each cell to see if is occupied and return false if the cell is occupied.
                for (int y = this.getY() + 1; y < cell.getY(); y++) {
                    if (ChessBoard.getInstance().getCell(this.getX(), y).isOccupied()) {
                        return false;
                    }
                }
            }
        }

        // If Ordinate is the same as cell.
        if (this.getY() == cell.getY()) {
            // If the abscissa of the piece is superior at the cell, the rook move to the bottom.
            if (this.getX() > cell.getX()) {
                // Check each cell to see if is occupied and return false if the cell is occupied.
                for (int x = this.getX() - 1; x > cell.getX(); x--) {
                    if (ChessBoard.getInstance().getCell(x, this.getY()).isOccupied()) {
                        return false;
                    }
                }
            }
            // If the abscissa of the piece is inferior at the cell, the rook move to the bottom.
            else {
                // Check each cell to see if is occupied and return false if the cell is occupied.
                for (int x = this.getX() + 1; x < cell.getX(); x++) {
                    if (ChessBoard.getInstance().getCell(x, this.getY()).isOccupied()) {
                        return false;
                    }
                }
            }
        }

        // if cell is occupied and the color is different or cell is free, the movement is possible.
        return (!cell.isOccupied() || (cell.isOccupied() && cell.getPiece().getColor() != this.getColor()));
    }
}
