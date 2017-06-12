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
 * Implement of a player present on the game.
 *
 * It composed by a name used like an identifier, two list of pieces respectively used
 * as all pieces of the player and all caught pieces of the opponent.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class Player implements IPlayer {

    /**
     * The name of the player.
     * @since 1.0
     */
    private String name;

    /**
     * The pieces of the player.
     * @since 1.0
     */
    private List<IPiece> pieces;

    /**
     * The list of pieces caught by the player pieces.
     */
    private List<IPiece> jail;



    /**
     * Get the name of the player.
     *
     * @return The name of the player.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the player.
     *
     * @param name New name of the player.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get all pieces of the player.
     *
     * @return A list of all pieces of the player.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public List<IPiece> getPieces() {
        return this.pieces;
    }

    /**
     * Set all pieces of the player.
     *
     * @param pieces New list if pieces.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void setPieces(List<IPiece> pieces) {
        this.pieces = pieces;
    }

    /**
     * Return the piece present on coordinates x,y.
     *
     * @param x Abscissa of the piece to get.
     * @param y Ordinate of the piece to get.
     *
     * @return The piece present on x,y.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public IPiece getPiece(int x, int y) {
        for (IPiece p : this.pieces) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    /**
     * Get all pieces catch by the player.
     *
     * @return Get all pieces catch and throw in jail by the player.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public List<IPiece> getJail() {
        return this.jail;
    }

    /**
     * Add a piece catch by player's piece on jail.
     *
     * @param piece Piece catch by a player piece.
     *
     * @version 1.0
     * @since 1.0
     */
    @Override
    public void addPieceOnJail(IPiece piece) {
        this.jail.add(piece);
    }
}
