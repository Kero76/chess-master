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
import fr.nicolasgille.chessmaster.model.piece.chesspieces.*;
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
        for (int y= 0; y < ChessBoard.getInstance().getY(); ++y) {
            assertThat(ChessBoard.getInstance().getCell(1, y).getPiece()).isInstanceOf(Pawn.class);
            assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 2, y).getPiece()).isInstanceOf(Pawn.class);
        }

        // Display ChessBoard.
        System.out.println(ChessBoard.getInstance().toString());

        // Rook Checker
        assertThat(ChessBoard.getInstance().getCell(0, 0).getPiece()).isInstanceOf(Rook.class);
        assertThat(ChessBoard.getInstance().getCell(0, ChessBoard.getInstance().getX() - 1).getPiece()).isInstanceOf(Rook.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 0).getPiece()).isInstanceOf(Rook.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 1).getPiece()).isInstanceOf(Rook.class);

        // Knight Checker
        assertThat(ChessBoard.getInstance().getCell(0, 1).getPiece()).isInstanceOf(Knight.class);
        assertThat(ChessBoard.getInstance().getCell(0, ChessBoard.getInstance().getX() - 2).getPiece()).isInstanceOf(Knight.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 1).getPiece()).isInstanceOf(Knight.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 2).getPiece()).isInstanceOf(Knight.class);

        // Bishop Checker
        assertThat(ChessBoard.getInstance().getCell(0,2).getPiece()).isInstanceOf(Bishop.class);
        assertThat(ChessBoard.getInstance().getCell(0, ChessBoard.getInstance().getX() - 3).getPiece()).isInstanceOf(Bishop.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 2).getPiece()).isInstanceOf(Bishop.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getX() - 1, ChessBoard.getInstance().getY() - 3).getPiece()).isInstanceOf(Bishop.class);

        // Queen Checker
        assertThat(ChessBoard.getInstance().getCell(0, 3).getPiece()).isInstanceOf(Queen.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 3).getPiece()).isInstanceOf(Queen.class);

        // King Checker
        assertThat(ChessBoard.getInstance().getCell(0, 4).getPiece()).isInstanceOf(King.class);
        assertThat(ChessBoard.getInstance().getCell(ChessBoard.getInstance().getY() - 1, 4).getPiece()).isInstanceOf(King.class);
    }

    @Test
    public void testRideToTheEndBuilder() {
        // Given - @see setUp.

        // When - Instantiate chess board.
        this.boardBuilder.buildRideToTheEndBoard();

        // Then - display chessboard
        System.out.println(ChessBoard.getInstance().toString());
    }
}
