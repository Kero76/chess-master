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
package fr.nicolasgille.chessmaster.board;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test about <code>ChessBoard</code> class.
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class ChessBoardTest {
    @Test
    public void getInstanceAsTheSame() throws Exception {
        // Given - Stored instance of ChessBoard on a variable.
        IBoard chessBoard = ChessBoard.getInstance();

        // When - Call another instance of ChessBoard.
        IBoard chessBoard2 = ChessBoard.getInstance();

        // Then - Compare instances.
        assertThat(chessBoard).isSameAs(chessBoard2);
        assertThat(chessBoard).isSameAs(ChessBoard.getInstance());
        assertThat(chessBoard2).isSameAs(ChessBoard.getInstance());

    }

    @Test
    public void getCellWithoutPieceOnIt() throws Exception {
        // Given - Instantiate x and y value.
        int xExpected = 5;
        int yExpected = 2;

        // When - Get the cell 5 / 2
        ICell cell = ChessBoard.getInstance().getCell(xExpected, yExpected);

        // Then - Compare value of the cell with x and y and check if the cell is empty and isOccupied is false.
        assertThat(xExpected).isEqualTo(cell.getX());
        assertThat(yExpected).isEqualTo(cell.getY());
        assertThat(cell.getPiece()).isNull();
        assertThat(cell.isOccupied()).isFalse();
    }

    @Test
    public void getCellWithXNegative() throws Exception {
        // Given - Instantiate x and y value.
        int xExpected = -5;
        int yExpected = 2;
        String messageExpected = "0 <= x <= getX()";

        // When - Get the cell -5 / 2
        try {
            ICell cell = ChessBoard.getInstance().getCell(xExpected, yExpected);
        } catch (IllegalArgumentException iae) {
            // Then - Compare message get from the exception.
            assertThat(iae.getMessage()).isEqualTo(messageExpected);
        }
    }

    @Test
    public void getCellWithXAt0() throws Exception {
        // Given - Instantiate x and y value.
        int xExpected = 0;
        int yExpected = 2;

        // When - Get the cell 0 / 2
        ICell cell = ChessBoard.getInstance().getCell(xExpected, yExpected);

        // Then - Compare value of the cell with x and y and check if the cell is empty and isOccupied is false.
        assertThat(xExpected).isEqualTo(cell.getX());
        assertThat(yExpected).isEqualTo(cell.getY());
        assertThat(cell.getPiece()).isNull();
        assertThat(cell.isOccupied()).isFalse();
    }

    @Test
    public void getCellWithXAtDefaultXValue() throws Exception {
        // Given - Instantiate x and y value.
        int xExpected = 8;
        int yExpected = 2;
        String messageExpected = "0 <= x <= getX()";

        // When - Get the cell 8 / 2
        try {
            ICell cell = ChessBoard.getInstance().getCell(xExpected, yExpected);
        } catch (IllegalArgumentException iae) {
            // Then - Compare message get from the exception.
            assertThat(iae.getMessage()).isEqualTo(messageExpected);
            assertThat(iae.getMessage()).isEqualTo(messageExpected);
        }
    }
}
