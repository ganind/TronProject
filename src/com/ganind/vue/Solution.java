package com.ganind.vue;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Grille grille = new Grille(0, 0, 0, 0, 0); // création de la grille

        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).

            grille.setN(N);

            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)

                // peuplement de la grille
                Emplacement emplacement0 = new Emplacement(X0, Y0);
                Emplacement emplacement1 = new Emplacement(X1, Y1);
                Lumicycle lumiActuelle = grille.getLumicycle(i);
                lumiActuelle.addCaseToEmplacement(emplacement0);
                lumiActuelle.addCaseToEmplacement(emplacement1);
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("UP"); // A single line with UP, DOWN, LEFT or RIGHT
        }
    }
}

class Lumicycle {

    private int P; // n° du joueur
    private ArrayList<Emplacement> cases;
    private int X0; // queue
    private int X1; // tête
    private int Y0; // queue
    private int Y1; // tête

    public Lumicycle(int P, int X0, int Y0) {

        this.P = P;
        ArrayList<Emplacement> cases = new ArrayList<>();
        Emplacement emplacement = new Emplacement(X0, Y0);
        cases.add(emplacement);
        this.X0 = X0;
        this.X1 = X0;
        this.Y0 = Y0;
        this.Y1 = Y0;
    }

    public void addCaseToEmplacement(Emplacement emplacement) {

        cases.add(emplacement);
    }

    public String computeNextMovement(Lumicycle lumicycle) {

        Emplacement emplacement = cases.get(cases.size()-1);
        int X = emplacement.getX();
        int Y = emplacement.getY();

        Emplacement droite = new Emplacement(X+1, Y);
        if ( droite )

            return ;
    }
}

class Grille {

    private int largeur;
    private int longueur;
    private int N; // nbr de joueurs
    private ArrayList<Lumicycle> L; // liste de joueurs

    public Grille(int N, int X0, int X1, int Y0, int Y1){

        largeur = 20;
        longueur = 30;
        this.N = N;
        ArrayList<Lumicycle> L = new ArrayList<>();
        L.add(new Lumicycle(0, X0, Y0));
        L.add(new Lumicycle(1, X1, Y1));
    }
    public void setN(int N) {
        this.N = N;
    }

    public Lumicycle getLumicycle(int index) {
        return this.L.get(index);
    }
}

class Emplacement {

    private int X; // queue
    private int Y; // tête

    public Emplacement(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
