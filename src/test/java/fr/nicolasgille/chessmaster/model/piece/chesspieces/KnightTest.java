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
 * Unit test for Knight.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class KnightTest {

    @Before
    public void setUp() {
        // Instantiate BLACK pawn on x/1.
        ChessBoard.getInstance().getCell(1,0).setPiece(new Knight(1, 0, PieceColor.BLACK));
        ChessBoard.getInstance().getCell(6,0).setPiece(new Knight(6, 0, PieceColor.BLACK));
    }

    @Test
    public void knightTryToMoveOnValidCell() {
        // Given - @see setUp() && instantiate coordinate where to go.
        int xToGo = 3;
        int yToGo = 1;

        // When - Get knight present on 3/1
        Knight piece = (Knight) ChessBoard.getInstance().getCell(1, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void knightTryToMoveOnValidCell2() {
        // Given - @see setUp() && instantiate coordinate where to go.
        int xToGo = 2;
        int yToGo = 2;

        // When - Get knight present on 3/1
        Knight piece = (Knight) ChessBoard.getInstance().getCell(1, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void knightTryToMoveOnInvalidCell() {
        // Given - @see setUp() && instantiate coordinate where to go.
        int xToGo = 4;
        int yToGo = 1;

        // When - Get knight present on 4/1
        Knight piece = (Knight) ChessBoard.getInstance().getCell(1, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void knightTryToMoveOnCellOccupiedByBlackPiece() {
        // Given - @see setUp() && instantiate coordinate where to go && placed piece on xToGo/yToGo.
        int xToGo = 2;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Knight(xToGo, yToGo, PieceColor.BLACK));

        // When - Get knight present on 4/1
        Knight piece = (Knight) ChessBoard.getInstance().getCell(1, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void knightTryToMoveOnCellOccupiedByWhitePiece() {
        // Given - @see setUp() && instantiate coordinate where to go && placed piece on xToGo/yToGo.
        int xToGo = 2;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Knight(xToGo, yToGo, PieceColor.WHITE));

        // When - Get knight present on 4/1
        Knight piece = (Knight) ChessBoard.getInstance().getCell(1, 0).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }
}
