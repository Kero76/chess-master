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

import fr.nicolasgille.chessmaster.board.ICell;

/**
 * Interface used to specified if a piece can be moveable or not.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public interface Moveable {

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
    boolean isMoveable(ICell cell);

    /**
     * Move the piece on <em>cell</em>.
     *
     * @param cell
     *  Arrival cell of the piece.
     * @since 1.0
     * @version 1.0
     */
    void move(ICell cell);
}
