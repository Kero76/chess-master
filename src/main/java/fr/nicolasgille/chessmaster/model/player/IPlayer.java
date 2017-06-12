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
package fr.nicolasgille.chessmaster.model.player;

import fr.nicolasgille.chessmaster.model.piece.IPiece;

import java.util.List;

/**
 * An interface used to represent a <em>player</em> during a party of chess.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public interface IPlayer {

    /**
     * Get the name of the player.
     *
     * @return
     *  The name of the player.
     * @since 1.0
     * @version 1.0
     */
    String getName();

    /**
     * Set the name of the player.
     *
     * @param name
     *  New name of the player.
     * @since 1.0
     * @version 1.0
     */
    void setName(String name);

    /**
     * Get all pieces of the player.
     *
     * @return
     *  A list of all pieces of the player.
     * @since 1.0
     * @version 1.0
     */
    List<IPiece> getPieces();

    /**
     * Set all pieces of the player.
     *
     * @param pieces
     *  New list if pieces.
     * @since 1.0
     * @version 1.0
     */
    void setPieces(List<IPiece> pieces);

    /**
     * Return the piece present on coordinates x,y.
     *
     * @param x
     *  Abscissa of the piece to get.
     * @param y
     *  Ordinate of the piece to get.
     * @return
     *  The piece present on x,y.
     * @since 1.0
     * @version 1.0
     */
    IPiece getPiece(int x, int y);

    /**
     * Get all pieces catch by the player.
     *
     * @return
     *  Get all pieces catch and throw in jail by the player.
     * @since 1.0
     * @version 1.0
     */
    List<IPiece> getJail();

    /**
     * Add a piece catch by player's piece on jail.
     *
     * @param piece
     *  Piece catch by a player piece.
     * @since 1.0
     * @version 1.0
     */
    void addPieceOnJail(IPiece piece);
}
