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

import fr.nicolasgille.chessmaster.model.board.ChessBoard;
import fr.nicolasgille.chessmaster.model.piece.PieceColor;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for Queen piece.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class QueenTest {

    @Before
    public void setUp() {
        // Instantiate BLACK queen on 3,0.
        ChessBoard.getInstance().getCell(3,0).setPiece(new Queen(3, 0, PieceColor.BLACK));
    }

    @Test
    public void queenTryToMoveOnValidCellLikeRook() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 3;
        int yToGo = 7;

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void queenTryToMoveOnValidCellLikeRook2() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 7;
        int yToGo = 0;

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void queenTryToMoveOnValidCellLikeBishop() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 5;
        int yToGo = 2;

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void queenTryToMoveOnValidCellLikeBishop2() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 1;
        int yToGo = 2;

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void queenTryToMoveOnInvalidCell() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 0;
        int yToGo = 1;

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void queenTryToMoveLikeRookOnCellOccupiedByWhitePiece() {
        // Given - @see setUp() & instantiate coordinate of arrival && place piece on last cell.
        int xToGo = 3;
        int yToGo = 7;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Queen(xToGo, yToGo, PieceColor.WHITE));

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void queenTryToMoveLikeRookOnCellOccupiedByBlackPiece() {
        // Given - @see setUp() & instantiate coordinate of arrival && place piece on last cell.
        int xToGo = 3;
        int yToGo = 7;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Queen(xToGo, yToGo, PieceColor.BLACK));

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void queenTryToMoveLikeBishopOnCellOccupiedByWhitePiece() {
        // Given - @see setUp() & instantiate coordinate of arrival && place piece on last cell.
        int xToGo = 5;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Queen(xToGo, yToGo, PieceColor.WHITE));

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void queenTryToMoveLikeBishopOnCellOccupiedByBlackPiece() {
        // Given - @see setUp() & instantiate coordinate of arrival && place piece on last cell.
        int xToGo = 5;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Queen(xToGo, yToGo, PieceColor.BLACK));

        // When - Get queen on 3,0
        Queen piece = (Queen) ChessBoard.getInstance().getCell(3, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }
}
