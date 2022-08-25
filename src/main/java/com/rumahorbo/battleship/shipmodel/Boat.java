package com.rumahorbo.battleship.shipmodel;

import com.rumahorbo.battleship.shipinterface.IShip;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Boat implements IShip {
    private final List<Coordinate> coordinates;

    @Override
    public boolean isCrash() {
        return this.coordinates.size() == 0;
    }

    @Override
    public void remove(Coordinate coordinate) {
        this.coordinates.remove(coordinate);
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return this.coordinates;
    }
}
