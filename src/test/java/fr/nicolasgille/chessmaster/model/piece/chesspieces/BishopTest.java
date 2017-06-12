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
 * Unit test for Bishop piece.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class BishopTest {

    @Before
    public void setUp() {
        // Instantiate BLACK pawn on x/1.
        ChessBoard.getInstance().getCell(2,0).setPiece(new Bishop(2, 0, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(5,0).setPiece(new Bishop(5, 0, PieceColor.BLACK));
    }

    @Test
    public void bishopTryToMoveOnValidCell() {
        // Given - @see setUp() && instantiate coordinate where to go.
        int xToGo = 4;
        int yToGo = 2;

        // When - Get bishop present on 2/0
        Bishop piece = (Bishop) ChessBoard.getInstance().getCell(2, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void bishopTryToMoveOnInvalidCell() {
        // Given - @see setUp() && instantiate coordinate where to go.
        int xToGo = 4;
        int yToGo = 0;

        // When - Get bishop present on 2/0
        Bishop piece = (Bishop) ChessBoard.getInstance().getCell(2, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void bishopTryToMoveOnOccupiedCellByWhitePiece() {
        // Given - @see setUp() && instantiate coordinate where to go && placed piece on way.
        int xToGo = 4;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo - 1, yToGo - 1).setPiece(new Bishop(xToGo - 1, yToGo - 1, PieceColor.WHITE));

        // When - Get bishop present on 2/0
        Bishop piece = (Bishop) ChessBoard.getInstance().getCell(2, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void bishopTryToMoveOnOccupiedLastCellByWhitePiece() {
        // Given - @see setUp() && instantiate coordinate where to go && placed piece on way.
        int xToGo = 4;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Bishop(xToGo, yToGo, PieceColor.WHITE));

        // When - Get bishop present on 2/0
        Bishop piece = (Bishop) ChessBoard.getInstance().getCell(2, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void bishopTryToMoveOnOccupiedLastCellByBlackPiece() {
        // Given - @see setUp() && instantiate coordinate where to go && placed piece on way.
        int xToGo = 4;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo - 1, yToGo - 1).setPiece(new Bishop(xToGo, yToGo, PieceColor.BLACK));

        // When - Get bishop present on 2/0
        Bishop piece = (Bishop) ChessBoard.getInstance().getCell(2, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }
}
