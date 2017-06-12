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
 * Unit test for King piece.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class KingTest {

    @Before
    public void setUp() {
        // Instantiate BLACK king on 4,0.
        ChessBoard.getInstance().getCell(4,0).setPiece(new King(4, 0, PieceColor.BLACK));
    }

    @Test
    public void kingTryToMoveOnValidCellLikeRook() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 5;
        int yToGo = 0;

        // When - Get king on 4,0
        King piece = (King) ChessBoard.getInstance().getCell(4, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void kingTryToMoveOnValidCellLikeRook2() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 4;
        int yToGo = 1;

        // When - Get king on 4,0
        King piece = (King) ChessBoard.getInstance().getCell(4, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void kingTryToMoveOnValidCellLikeBishop() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 5;
        int yToGo = 1;

        // When - Get king on 4,0
        King piece = (King) ChessBoard.getInstance().getCell(4, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void kingTryToMoveOnValidCellLikeBishop2() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 3;
        int yToGo = 1;

        // When - Get king on 4,0
        King piece = (King) ChessBoard.getInstance().getCell(4, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void kingTryToMoveOnInvalidCell() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 6;
        int yToGo = 0;

        // When - Get king on 4,0
        King piece = (King) ChessBoard.getInstance().getCell(4, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void kingTryToMoveOnInvalidCell2() {
        // Given - @see setUp() & instantiate coordinate of arrival.
        int xToGo = 6;
        int yToGo = 2;

        // When - Get king on 4,0
        King piece = (King) ChessBoard.getInstance().getCell(4, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void kingTryToMoveOnCellOccupiedByBlackPiece() {
        // Given - @see setUp() & instantiate coordinate of arrival & placed white king on arrival cell.
        int xToGo = 5;
        int yToGo = 1;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new King(xToGo, yToGo, PieceColor.BLACK));

        // When - Get king on 4,0
        King piece = (King) ChessBoard.getInstance().getCell(4, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void kingTryToMoveOnCellOccupiedByWhitePiece() {
        // Given - @see setUp() & instantiate coordinate of arrival & placed white king on arrival cell.
        int xToGo = 5;
        int yToGo = 1;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new King(xToGo, yToGo, PieceColor.WHITE));

        // When - Get king on 4,0
        King piece = (King) ChessBoard.getInstance().getCell(4, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }
}
