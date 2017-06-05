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
 * Interface at applied on a AbstractPiece to indicate the piece can be catch by another pieces.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public interface Catchable {

    /**
     * Check if a piece can catchable by another piece.
     *
     * @return
     *  True if the piece passed on parameter can be catch by the current piece.
     *  False in other case.
     * @since 1.0
     * @version 1.0
     */
    boolean isCatch();

    /**
     * Catch the object and remove it from the list of playable object.
     *
     * @since 1.0
     * @version 1.0
     */
    void catchObject();
}