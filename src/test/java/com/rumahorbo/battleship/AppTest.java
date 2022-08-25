package com.rumahorbo.battleship;

import com.rumahorbo.battleship.exception.AngleException;
import com.rumahorbo.battleship.exception.BoardException;
import com.rumahorbo.battleship.exception.CoordinateException;
import com.rumahorbo.battleship.exception.ShipException;
import com.rumahorbo.battleship.shipenum.Angle;
import com.rumahorbo.battleship.shipenum.Ship;
import com.rumahorbo.battleship.shipmodel.Board;
import com.rumahorbo.battleship.shipmodel.Coordinate;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void test() {
        assertTrue(true);
    }

    @Test
    public void board_horizontal() {
        Board board = new Board();
        Coordinate coordinateBoat = new Coordinate(0, 0);
        Coordinate coordinateTanker = new Coordinate(0, 1);
        board.put(Ship.BOAT, Angle.HORIZONTAL, coordinateBoat);
        board.put(Ship.TANKER, Angle.HORIZONTAL, coordinateTanker);
        Coordinate hit1 = new Coordinate(0, 0);
        Coordinate hit2 = new Coordinate(1, 0);

        Coordinate hit3 = new Coordinate(0, 1);
        Coordinate hit4 = new Coordinate(0, 2);
        Coordinate hit5 = new Coordinate(0, 3);
        Coordinate hit6 = new Coordinate(1, 1);
        Coordinate hit7 = new Coordinate(1, 2);
        Coordinate hit8 = new Coordinate(1, 3);
        Coordinate hit9 = new Coordinate(2, 1);
        Coordinate hit10 = new Coordinate(2, 2);
        Coordinate hit11 = new Coordinate(2, 3);
        Coordinate hit12 = new Coordinate(3, 1);
        Coordinate hit13 = new Coordinate(3, 2);
        Coordinate hit14 = new Coordinate(3, 3);

        board.hit(hit1);
        board.hit(hit2);

        board.hit(hit3);
        board.hit(hit4);
        board.hit(hit5);
        board.hit(hit6);
        board.hit(hit7);
        board.hit(hit8);
        board.hit(hit9);
        board.hit(hit10);
        board.hit(hit11);
        board.hit(hit12);
        board.hit(hit13);
        board.hit(hit14);

        assertTrue(board.isLose());
    }

    @Test
    public void board_vertical() {
        Board board = new Board();
        Coordinate coordinateBoat = new Coordinate(0, 0);
        Coordinate coordinateTanker = new Coordinate(1, 0);
        board.put(Ship.BOAT, Angle.VERTICAL, coordinateBoat);
        board.put(Ship.TANKER, Angle.VERTICAL, coordinateTanker);
        //boat
        Coordinate hit1 = new Coordinate(0, 0);
        Coordinate hit2 = new Coordinate(0, 1);
        //tanker
        Coordinate hit3 = new Coordinate(1, 0);
        Coordinate hit4 = new Coordinate(1, 1);
        Coordinate hit5 = new Coordinate(1, 2);
        Coordinate hit6 = new Coordinate(1, 3);
        Coordinate hit7 = new Coordinate(2, 0);
        Coordinate hit8 = new Coordinate(2, 1);
        Coordinate hit9 = new Coordinate(2, 2);
        Coordinate hit10 = new Coordinate(2, 3);
        Coordinate hit11 = new Coordinate(3, 0);
        Coordinate hit12 = new Coordinate(3, 1);
        Coordinate hit13 = new Coordinate(3, 2);
        Coordinate hit14 = new Coordinate(3, 3);

        //hit boat
        board.hit(hit1);
        board.hit(hit2);
        //hit tanker
        board.hit(hit3);
        board.hit(hit4);
        board.hit(hit5);
        board.hit(hit6);
        board.hit(hit7);
        board.hit(hit8);
        board.hit(hit9);
        board.hit(hit10);
        board.hit(hit11);
        board.hit(hit12);
        board.hit(hit13);
        board.hit(hit14);

        assertTrue(board.isLose());
    }

    @Test
    public void ship_exception() {
        Board board = new Board();
        Coordinate coordinateBoat = new Coordinate(0, 0);

        assertThrows(ShipException.class, () -> board.put(null, Angle.VERTICAL, coordinateBoat));
    }

    @Test
    public void angle_exception() {
        Board board = new Board();
        Coordinate coordinateBoat = new Coordinate(0, 0);

        assertThrows(AngleException.class, () -> board.put(Ship.TANKER, null, coordinateBoat));
    }

    @Test
    public void coordinate_exception() {
        Board board = new Board();
        Coordinate coordinateBoat = new Coordinate(-1, 0);

        assertThrows(CoordinateException.class, () -> board.put(Ship.TANKER, Angle.VERTICAL, coordinateBoat));
    }

    @Test
    public void board_exception() {
        Board board = new Board();
        Coordinate coordinateBoat = new Coordinate(0, 0);
        board.put(Ship.TANKER, Angle.VERTICAL, coordinateBoat);

        assertThrows(BoardException.class, () -> board.put(Ship.TANKER, Angle.VERTICAL, new Coordinate(0, 3)));
    }
}
