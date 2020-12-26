package com.ganind.model;

import java.util.ArrayList;

public class Grille {

    private int largeur;
    private int longueur;
    private int N; // nbr de joueurs
    private ArrayList<Lumicycle> L; // liste de joueurs

    public Grille(int N, int X0, int X1, int Y0, int Y1){

        largeur = 20;
        longueur = 30;
        this.N = N;
        ArrayList<Lumicycle> L = new ArrayList();
        L.add(new Lumicycle(0, X0, Y0));
        L.add(new Lumicycle(1, X1, Y1));
    }
}
