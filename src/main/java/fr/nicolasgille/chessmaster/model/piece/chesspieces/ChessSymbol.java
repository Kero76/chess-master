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

/**
 * An enum used to represent the piece of chess when you save a party, reload a game, ...
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public enum ChessSymbol {
    KING('K'),
    QUEEN('Q'),
    KNIGHT('N'),
    BISHOP('B'),
    ROOK('R'),
    PAWN('P');

    /**
     * Representation of a chess piece.
     */
    private char symbol;

    /**
     * Constructor of the enum object.
     *
     * @param symbol
     *  Symbol used to represent the piece.
     * @since 1.0
     * @version 1.0
     */
    ChessSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Return the symbol for each piece of chess.
     *
     * @return
     *  Symbol used to represent the piece.
     * @since 1.0
     * @version 1.0
     */
    public char getSymbol() {
        return this.symbol;
    }
}
