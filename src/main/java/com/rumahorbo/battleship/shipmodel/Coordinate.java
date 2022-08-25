package com.rumahorbo.battleship.shipmodel;

import com.rumahorbo.battleship.exception.BoardException;
import com.rumahorbo.battleship.shipenum.Angle;
import com.rumahorbo.battleship.shipenum.Ship;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Coordinate {
    private final int x;
    private final int y;
    private final int MAX_X = 10;
    private final int MAX_Y = 10;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public boolean isValidHorizontal(Ship ship) {
        if (isLessThanZero()) return false;
        if (this.y > MAX_Y - ship.getHeight()) {
            return false;
        }
        return this.x <= MAX_X - ship.getWidth();
    }

    public boolean isValidVertical(Ship ship) {
        if (isLessThanZero()) {
            return false;
        }
        if (this.x > MAX_X - ship.getHeight()) {
            return false;
        }
        return this.y <= MAX_Y - ship.getWidth();
    }

    private boolean isLessThanZero() {
        if (this.x < 0) {
            return true;
        }
        return this.y < 0;
    }

    public List<Coordinate> generateNeighbor(Ship ship, Angle angle, List<Coordinate> coordinatesTaken) {
        List<Coordinate> coordinates = new ArrayList<>();
        if (angle == Angle.HORIZONTAL) {
            return getCoordinates(coordinatesTaken, coordinates, ship.getWidth(), ship.getHeight());
        }
        return getCoordinates(coordinatesTaken, coordinates, ship.getHeight(), ship.getWidth());
    }

    private List<Coordinate> getCoordinates(List<Coordinate> coordinatesTaken, List<Coordinate> coordinates, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Coordinate coordinate = new Coordinate(this.x + i, this.y + j);
                if (coordinatesTaken.contains(coordinate)) {
                    throw new BoardException("overlap ship");
                }
                coordinates.add(coordinate);
            }
        }
        return coordinates;
    }

}
