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
package fr.nicolasgille.chessmaster.board.builder;

import fr.nicolasgille.chessmaster.board.ChessBoard;
import fr.nicolasgille.chessmaster.piece.PieceColor;
import fr.nicolasgille.chessmaster.piece.chesspieces.*;

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
        for (int x = 0; x < ChessBoard.getInstance().getX(); ++x) {
            ChessBoard.getInstance().getCell(x, 1).setPiece(new Pawn(x, 1, PieceColor.WHITE));
            ChessBoard.getInstance().getCell(x, ChessBoard.getInstance().getY() - 2).setPiece(new Pawn(x, ChessBoard.getInstance().getY() - 2, PieceColor.BLACK));
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
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, 0).setPiece(new Rook(ChessBoard.getInstance().getX() - 1, 0, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(0, ChessBoard.getInstance().getY() - 1).setPiece(new Rook(0, ChessBoard.getInstance().getY() - 1, PieceColor.BLACK));
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
        ChessBoard.getInstance().getCell(1, 0).setPiece(new Knight(1, 0, PieceColor.WHITE));
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 2, 0).setPiece(new Knight(ChessBoard.getInstance().getX() - 2, 0, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(1, ChessBoard.getInstance().getY() - 1).setPiece(new Knight(1, ChessBoard.getInstance().getY() - 1, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 2, ChessBoard.getInstance().getY() - 1).setPiece(new Knight(ChessBoard.getInstance().getX() - 2, ChessBoard.getInstance().getY() - 1, PieceColor.BLACK));
    }

    /**
     * Place Bishop on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placeBishop() {
        // White piece.
        ChessBoard.getInstance().getCell(2, 0).setPiece(new Bishop(2, 0, PieceColor.WHITE));
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 3, 0).setPiece(new Bishop(ChessBoard.getInstance().getX() - 23, 0, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(2, ChessBoard.getInstance().getY() - 1).setPiece(new Bishop(2, ChessBoard.getInstance().getY() - 1, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 3, ChessBoard.getInstance().getY() - 1).setPiece(new Bishop(ChessBoard.getInstance().getX() - 3, ChessBoard.getInstance().getY() - 1, PieceColor.BLACK));
    }

    /**
     * Place Queen on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placeQueen() {
        // White piece.
        ChessBoard.getInstance().getCell(3, 0).setPiece(new Queen(3, 0, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(3, ChessBoard.getInstance().getY() - 1).setPiece(new Queen(3, ChessBoard.getInstance().getY() - 1, PieceColor.BLACK));
    }

    /**
     * Place Ling on Board.
     *
     * @since 1.0
     * @version 1.0
     */
    private void placeKing() {
        // White piece.
        ChessBoard.getInstance().getCell(4, 0).setPiece(new King(4, 0, PieceColor.WHITE));
        // Black piece.
        ChessBoard.getInstance().getCell(4, ChessBoard.getInstance().getY() - 1).setPiece(new King(4, ChessBoard.getInstance().getY() - 1, PieceColor.BLACK));
    }
}
