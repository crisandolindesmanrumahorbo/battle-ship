package com.rumahorbo.battleship.exception;

public class BoardException extends RuntimeException {
    public BoardException(String errorMessage) {
        super(errorMessage);
    }
}
