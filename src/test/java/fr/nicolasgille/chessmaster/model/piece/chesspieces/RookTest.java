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

import fr.nicolasgille.chessmaster.model.board.Cell;
import fr.nicolasgille.chessmaster.model.board.ChessBoard;
import fr.nicolasgille.chessmaster.model.piece.PieceColor;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for class Rook.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class RookTest {

    @Before
    public void setUp() {
        // Instantiate BLACK pawn on x/1.
        ChessBoard.getInstance().getCell(0, 0).setPiece(new Rook(0, 0, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(7, 0).setPiece(new Rook(ChessBoard.getInstance().getX(), 0, PieceColor.BLACK));
    }

    @Test
    public void rookTryToMoveOnFreeCellOnTop() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 0;
        int yToGo = 7;

        // When - Get rook on 0,0
        Rook piece = (Rook) ChessBoard.getInstance().getCell(0, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void rookTryToMoveOnFreeCellOnDiagonal() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 7;
        int yToGo = 7;

        // When - Get rook on 0,0
        Rook piece = (Rook) ChessBoard.getInstance().getCell(0, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(new Cell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void rookTryToMoveOnFreeCellOnRight() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 5;
        int yToGo = 0;

        // When - Get rook on 0,0
        Rook piece = (Rook) ChessBoard.getInstance().getCell(0, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void rookTryToMoveOnTopAndPieceBlockMovement() {
        // Given - @see setUp() & instantiate coordinate of arrival & place Piece on 0/4.
        int xToGo = 0;
        int yToGo = 7;
        ChessBoard.getInstance().getCell(0, 4).setPiece(new Pawn(0, 4, PieceColor.WHITE));

        // When - Get rook on 0,0
        Rook piece = (Rook) ChessBoard.getInstance().getCell(0, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void rookTryToMoveOnRightAndPieceBlockMovement() {
        // Given - @see setUp() & instantiate coordinate of arrival & place Piece on 2/0.
        int xToGo = 5;
        int yToGo = 0;
        ChessBoard.getInstance().getCell(2, 0).setPiece(new Pawn(2, 0, PieceColor.WHITE));

        // When - Get rook on 0,0
        Rook piece = (Rook) ChessBoard.getInstance().getCell(0, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void rookTryToMoveOnCellOccupiedByWhitePiece() {
        // Given - @see setUp() & instantiate coordinate of arrival & place Piece on 0/4.
        int xToGo = 0;
        int yToGo = 7;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Pawn(xToGo, yToGo, PieceColor.WHITE));

        // When - Get rook on 0,0
        Rook piece = (Rook) ChessBoard.getInstance().getCell(0, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void rookTryToMoveOnCellOccupiedByBlackPiece() {
        // Given - @see setUp() & instantiate coordinate of arrival & place Piece on 0/4.
        int xToGo = 0;
        int yToGo = 7;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Pawn(xToGo, yToGo, PieceColor.BLACK));

        // When - Get rook on 0,0
        Rook piece = (Rook) ChessBoard.getInstance().getCell(0, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }
}
