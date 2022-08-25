package com.rumahorbo.battleship.exception;

public class ShipException extends RuntimeException {
    public ShipException(String errorMessage) {
        super(errorMessage);
    }
}
