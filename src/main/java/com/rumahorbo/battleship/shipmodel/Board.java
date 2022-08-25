package com.rumahorbo.battleship.shipmodel;

import com.rumahorbo.battleship.exception.AngleException;
import com.rumahorbo.battleship.exception.CoordinateException;
import com.rumahorbo.battleship.exception.ShipException;
import com.rumahorbo.battleship.shipenum.Angle;
import com.rumahorbo.battleship.shipenum.Ship;
import com.rumahorbo.battleship.shipinterface.IShip;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<IShip> ships;

    public Board() {
        this.ships = new ArrayList<>();
    }

    public void hit(Coordinate coordinate) {
        for (IShip ship : this.ships) {
            ship.remove(coordinate);
        }
    }

    public boolean isLose() {
        boolean result = true;
        for (IShip ship : this.ships) {
            result = result && ship.isCrash();
        }
        return result;
    }

    public void put(Ship ship, Angle angle, Coordinate coordinate) {
        if (ship != null) {
            IShip boat = generateShip(ship, angle, coordinate);
            this.ships.add(boat);
            return;
        }
        throw new ShipException("ship error");
    }

    private IShip generateShip(Ship ship, Angle angle, Coordinate coordinate) {
        if (angle == Angle.HORIZONTAL) {
            return this.putHorizontal(ship, angle, coordinate);
        }
        if (angle == Angle.VERTICAL) {
            return this.putVertical(ship, angle, coordinate);
        }
        throw new AngleException("angle error");
    }

    private IShip putVertical(Ship ship, Angle angle, Coordinate coordinate) {
        if (coordinate.isValidVertical(ship)) {
            if (ship == Ship.BOAT) {
                return generateBoat(coordinate.generateNeighbor(ship, angle, coordinatesTaken()));
            }
            return generateTanker(coordinate.generateNeighbor(ship, angle, coordinatesTaken()));
        }
        throw new CoordinateException("vertical coordinate error");
    }

    private IShip putHorizontal(Ship ship, Angle angle, Coordinate coordinate) {
        if (coordinate.isValidHorizontal(ship)) {
            if (ship == Ship.BOAT) {
                return this.generateBoat(coordinate.generateNeighbor(ship, angle, coordinatesTaken()));
            }
            return this.generateTanker(coordinate.generateNeighbor(ship, angle, coordinatesTaken()));
        }
        throw new CoordinateException("horizontal coordinate error");
    }

    private IShip generateBoat(List<Coordinate> neighborCoordinates) {
        List<Coordinate> coordinates = new ArrayList<>(neighborCoordinates);
        return new Boat(coordinates);
    }

    private IShip generateTanker(List<Coordinate> neighborCoordinates) {
        List<Coordinate> coordinates = new ArrayList<>(neighborCoordinates);
        return new Tanker(coordinates);
    }

    private List<Coordinate> coordinatesTaken() {
        List<Coordinate> coordinatesTaken = new ArrayList<>();
        for (IShip ship : ships) {
            coordinatesTaken.addAll(ship.getCoordinates());
        }
        return coordinatesTaken;
    }

}
