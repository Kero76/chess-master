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
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Unit test for the class BoardBuilder.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class BoardBuilderTest {

    /**
     * Instance of BoardBuilder.
     *
     * @since 1.0
     */
    private BoardBuilder boardBuilder;

    @Before
    public void setUp() {
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void buildChessBoard() throws Exception {
        // Given - @see setUp.

        // When - Instantiate chess board.
        this.boardBuilder.buildChessBoard();

        // Then - Check position of the piece on ChessBoard.
        // Pawn checker.
        for (int x = 0; x < ChessBoard.getInstance().getX(); ++x) {
            assertThat(ChessBoard.getInstance().getCell(x, 1).getPiece()).isInstanceOf(Pawn.class);
            assertThat(ChessBoard.getInstance().getCell(x, ChessBoard.getInstance().getY() - 2).getPiece()).isInstanceOf(Pawn.class);
        }

        // Rook Checker
        assertThat(ChessBoard.getInstance().getCell(0, 0).getPiece()).isInstanceOf(Rook.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, 0).getPiece()).isInstanceOf(Rook.class);
        assertThat(ChessBoard.getInstance().getCell(0, ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(Rook.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(Rook.class);

        // Knight Checker
        assertThat(ChessBoard.getInstance().getCell(1, 0).getPiece()).isInstanceOf(Knight.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 2, 0).getPiece()).isInstanceOf(Knight.class);
        assertThat(ChessBoard.getInstance().getCell(1, ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(Knight.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 2, ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(Knight.class);

        // Bishop Checker
        assertThat(ChessBoard.getInstance().getCell(2,0).getPiece()).isInstanceOf(Bishop.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 3, 0).getPiece()).isInstanceOf(Bishop.class);
        assertThat(ChessBoard.getInstance().getCell(2, ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(Bishop.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 3, ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(Bishop.class);

        // Queen Checker
        assertThat(ChessBoard.getInstance().getCell(3, 0).getPiece()).isInstanceOf(Queen.class);
        assertThat(ChessBoard.getInstance().getCell(3, ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(Queen.class);

        // King Checker
        assertThat(ChessBoard.getInstance().getCell(4, 0).getPiece()).isInstanceOf(King.class);
        assertThat(ChessBoard.getInstance().getCell(4,ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(King.class);
    }
}
