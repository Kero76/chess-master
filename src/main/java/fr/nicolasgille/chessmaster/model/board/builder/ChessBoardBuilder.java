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
import fr.nicolasgille.chessmaster.model.piece.chesspieces.*;

/**
 * Build a chess board with all pieces.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class ChessBoardBuilder {

    /**
     * Constructor of the class used to instantiate a ChessBoard with all pieces.
     *
     * @since 1.0
     * @version 1.0
     */
    public ChessBoardBuilder() {
        this.placePawn();
        this.placeRook();
        this.placeKnight();
        this.placeBishop();
        this.placeQueen();
        this.placeKing();
    }

    /**
     * Place pawns on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placePawn() {
        for (int y = 0; y < ChessBoard.getInstance().getY(); ++y) {
            ChessBoard.getInstance().getCell(1, y).setPiece(new Pawn(1, y, PieceColor.WHITE));
            ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 2, y).setPiece(new Pawn(ChessBoard.getInstance().getY() - 2, y, PieceColor.BLACK));
        }
    }

    /**
     * Place rooks on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placeRook() {
        // White piece.
        ChessBoard.getInstance().getCell(0, 0).setPiece(new Rook(0, 0, PieceColor.WHITE));
        ChessBoard.getInstance().getCell(0, ChessBoard.getInstance().getX() - 1).setPiece(new Rook(0, ChessBoard.getInstance().getX() - 1, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 0).setPiece(new Rook(ChessBoard.getInstance().getY() - 1, 0, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 1).setPiece(new Rook(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 1, PieceColor.BLACK));
    }

    /**
     * Place knights on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placeKnight() {
        // White piece.
        ChessBoard.getInstance().getCell(0, 1).setPiece(new Knight(0, 1, PieceColor.WHITE));
        ChessBoard.getInstance().getCell(0, ChessBoard.getInstance().getX() - 2).setPiece(new Knight(0, ChessBoard.getInstance().getX() - 2, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 1).setPiece(new Knight(ChessBoard.getInstance().getY() - 1, 1, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 2).setPiece(new Knight(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 2, PieceColor.BLACK));
    }

    /**
     * Place Bishop on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placeBishop() {
        // White piece.
        ChessBoard.getInstance().getCell(0, 2).setPiece(new Bishop(0, 2, PieceColor.WHITE));
        ChessBoard.getInstance().getCell(0, ChessBoard.getInstance().getX() - 3).setPiece(new Bishop(0,ChessBoard.getInstance().getX() - 3, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 2).setPiece(new Bishop(ChessBoard.getInstance().getY() - 1, 2, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 3).setPiece(new Bishop(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 3, PieceColor.BLACK));
    }

    /**
     * Place Queen on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placeQueen() {
        // White piece.
        ChessBoard.getInstance().getCell(0, 3).setPiece(new Queen(0, 3, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 3).setPiece(new Queen(ChessBoard.getInstance().getY() - 1,3 , PieceColor.BLACK));
    }

    /**
     * Place Ling on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placeKing() {
        // White piece.
        ChessBoard.getInstance().getCell(0, 4).setPiece(new King(0, 4,  PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 4).setPiece(new King(ChessBoard.getInstance().getY() - 1, 4, PieceColor.BLACK));
    }
}
