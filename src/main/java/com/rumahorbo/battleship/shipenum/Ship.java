package com.rumahorbo.battleship.shipenum;

public enum Ship {
    BOAT(1, 2),
    TANKER(3, 4);

    final int height;
    final int width;

    Ship(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
