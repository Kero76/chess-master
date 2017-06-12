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
 * Unit test for class Pawn.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class PawnTest {

    @Before
    public void setUp() {
        // Instantiate BLACK pawn on x/1.
        int y = 1;
        for (int x = 0; x < ChessBoard.getInstance().getX(); ++x) {
            ChessBoard.getInstance().getCell(x, y).setPiece(new Pawn(x, y, PieceColor.BLACK));
        }
    }

    @Test
    public void pawnTryToMoveOnFreeCell() {
        // Given - @see setUp() && instantiate coordinate where to go.
        int xToGo = 1;
        int yToGo = 2;

        // When - Get pawn present on 1/1
        Pawn piece = (Pawn) ChessBoard.getInstance().getCell(1, 1).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void pawnTryToMoveOnOccupiedCell() {
        // Given - @see setUp() && placed a piece in xToGo/yToGo.
        int xToGo = 1;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Pawn(xToGo, yToGo, PieceColor.WHITE));

        // When - Get pawn present on 1/1
        Pawn piece = (Pawn) ChessBoard.getInstance().getCell(1, 1).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void pawnTryToMoveOnTwiceCellsWithoutMoved() {
        // Given - @see setUp() & instantiate coordinate of arrival cell.
        int xToGo = 1;
        int yToGo = 3;

        // When - Get pawn present on 1/1.
        Pawn piece = (Pawn) ChessBoard.getInstance().getCell(1, 1).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void pawnTryToMoveOnTwiceCellsWithoutMovedAndAPieceOccupiedLastCells() {
        // Given - @see setUp() & instantiate coordinate of arrival cell & placed piece on the arrival cell.
        int xToGo = 1;
        int yToGo = 3;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Pawn(xToGo, yToGo, PieceColor.WHITE));

        // When - Get pawn present on 1/1.
        Pawn piece = (Pawn) ChessBoard.getInstance().getCell(1, 1).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void pawnTryToMoveOnTwiceCellsWithoutMovedAndAPieceOccupiedFirstCells() {
        // Given - @see setUp() & instantiate coordinate of arrival cell & placed piece on the arrival cell.
        int xToGo = 1;
        int yToGo = 3;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Pawn(xToGo, yToGo - 1, PieceColor.WHITE));

        // When - Get pawn present on 1/1.
        Pawn piece = (Pawn) ChessBoard.getInstance().getCell(1, 1).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void pawnTryToCatchPiecePresentOnDiagonal() {
        // Given - @see setUp() && placed piece on diagonal.
        int xToGo = 2;
        int yToGo = 2;
        ChessBoard.getInstance().getCell(xToGo, yToGo).setPiece(new Pawn(xToGo, yToGo, PieceColor.WHITE));

        // When - Get pawn present on 1/1
        Pawn piece = (Pawn) ChessBoard.getInstance().getCell(1, 1).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isTrue();
    }

    @Test
    public void pawnTryToCatchPieceNotFoundOnDiagonal() {
        // Given - @see setUp() && placed piece on diagonal.
        int xToGo = 2;
        int yToGo = 2;

        // When - Get pawn present on 1/1
        Pawn piece = (Pawn) ChessBoard.getInstance().getCell(1, 1).getPiece();

        // Then - Compare if the movement is possible.
        assertThat(piece.isMoveable(ChessBoard.getInstance().getCell(xToGo, yToGo))).isFalse();
    }

    @Test
    public void pawnMovedOnTopCell() {
        // Given - @see setUp() && placed piece on diagonal.
        int xToGo = 1;
        int yToGo = 2;
        Pawn piece = (Pawn) ChessBoard.getInstance().getCell(1, 1).getPiece();

        // When - Move piece on xToGo & yToGo.
        piece.move(ChessBoard.getInstance().getCell(xToGo, yToGo));

        // Then - Compare if the movement is possible.
        assertThat(piece.getX()).isEqualTo(xToGo);
        assertThat(piece.getY()).isEqualTo(yToGo);
        assertThat(piece.hasMoved()).isTrue();
    }
}
