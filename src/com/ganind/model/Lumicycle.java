package com.ganind.model;

public class Lumicycle {

    private int P; // n° du joueur
    private int X0; // queue
    private int X1; // tête
    private int Y0; // queue
    private int Y1; // tête

    public Lumicycle(int P, int X0, int Y0) {

        this.P = P;
        this.X0 = X0;
        this.X1 = X0;
        this.Y0 = Y0;
        this.Y1 = Y0;
    }
}
