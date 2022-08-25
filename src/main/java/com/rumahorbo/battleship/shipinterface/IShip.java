package com.rumahorbo.battleship.shipinterface;

import com.rumahorbo.battleship.shipmodel.Coordinate;

import java.util.List;

public interface IShip {
    boolean isCrash();
    void remove(Coordinate coordinate);

    List<Coordinate> getCoordinates();
}
