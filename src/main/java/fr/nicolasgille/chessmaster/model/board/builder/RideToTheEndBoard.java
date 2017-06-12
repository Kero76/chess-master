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
package fr.nicolasgille.chessmaster.model.board.builder;

import fr.nicolasgille.chessmaster.model.board.ChessBoard;
import fr.nicolasgille.chessmaster.model.piece.PieceColor;
import fr.nicolasgille.chessmaster.model.piece.chesspieces.Knight;
import fr.nicolasgille.chessmaster.utils.Randomizer;

import java.util.Random;

/**
 * Build a board for the game Ride to the End.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class RideToTheEndBoard {

    /**
     * Constructor of the class used to instantiate a RideToTheEndBoard with all pieces needed to play at the game.
     *
     * @since 1.0
     * @version 1.0
     */
    public RideToTheEndBoard() {
        int xBlack = Randomizer.random(0, ChessBoard.getInstance().getX());
        int yBlack = Randomizer.random(0, ChessBoard.getInstance().getY());
        int xWhite = Randomizer.random(0, ChessBoard.getInstance().getX());
        int yWhite = Randomizer.random(0, ChessBoard.getInstance().getY());

        while (xWhite == xBlack && yBlack == yWhite) {
            xWhite = Randomizer.random(0, ChessBoard.getInstance().getX());
            yWhite = Randomizer.random(0, ChessBoard.getInstance().getY());
        }

        ChessBoard.getInstance().getCell(xBlack, yBlack).setPiece(new Knight(xBlack, yBlack, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(xWhite, yWhite).setPiece(new Knight(xWhite, yWhite, PieceColor.WHITE));
    }
}
