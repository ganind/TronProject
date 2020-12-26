package com.ganind.model;

public class Mouvement {

    private Lumicycle P;
    private int origineX;
    private int origineY;
    private int destinationX;
    private int destinationY;

    public Mouvement(Lumicycle P, int origineX, int origineY, int destinationX, int destinationY) {

        this.P = P;
        this.origineX = origineX;
        this.origineY = origineY;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }
}
