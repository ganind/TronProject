import java.util.*;

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
                Emplacement emplacement1 = new Emplacement(X1, Y1);
                Lumicycle lumiActuelle = grille.getLumicycle(i);
                lumiActuelle.addCaseToEmplacement(emplacement1);
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            Lumicycle lumiAdversaire = getAdversaire(P, grille);
            String mouvement = grille.getLumicycle(P).computeNextMovement(lumiAdversaire);
            System.out.println(mouvement); // A single line with UP, DOWN, LEFT or RIGHT
        }
    }

    public static Lumicycle getAdversaire(int P, Grille grille) {

        Lumicycle lumiAdversaire;

        if (P == 0) {
            lumiAdversaire = grille.getLumicycle(1);
        } else {
            lumiAdversaire = grille.getLumicycle(0);
        }
        return lumiAdversaire;
    }
}

class Lumicycle {

    private int P; // n° du joueur/mumicycle
    private ArrayList<Emplacement> cases; // liste de cases ocupées par le lumicycle

    public Lumicycle(int P, int X0, int Y0) {

        this.P = P;
        this.cases = new ArrayList<>();
    }

    public void addCaseToEmplacement(Emplacement emplacement) {

        cases.add(emplacement);
    }

    public boolean caseIsFree(Emplacement emplacement) {

        System.err.println("P = " + P);
        System.err.println("emplacement.getX() = " + emplacement.getX());
        System.err.println("emplacement.getY() = " + emplacement.getY());

        for (int i = 0; i < cases.size(); i++) {
            if (cases.get(i).equals(emplacement)) { // appel à la function equals()
                return false;
            }
        }
        return true;
    }

    public String computeNextMovement(Lumicycle lumicycle) {

        Emplacement monEmplacement = cases.get(cases.size() - 1);
        int X = monEmplacement.getX();
        int Y = monEmplacement.getY();

        if (goRight(lumicycle, X, Y))
            return "RIGHT";

        if (goLeft(lumicycle, X, Y))
            return "LEFT";

        if (goUp(lumicycle, X, Y))
            return "UP";

        if (goDown(lumicycle, X, Y))
            return "DOWN";

        return "DEAD END";
    }

    private boolean testCase(Lumicycle lumicycle, Emplacement bas) {
        if (this.caseIsFree(bas) && lumicycle.caseIsFree(bas)) {
            if (bas.getX() < 30 && bas.getY() < 20) {
                if (bas.getX() >= 0 && bas.getY() >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean goRight(Lumicycle lumicycle, int x, int y) {
        Emplacement droite = new Emplacement(x + 1, y); // verification de la case à droite
        return testCase(lumicycle, droite);
    }

    private boolean goLeft(Lumicycle lumicycle, int x, int y) {
        Emplacement gauche = new Emplacement(x - 1, y); // verification de la case à gauche
        return testCase(lumicycle, gauche);
    }

    private boolean goUp(Lumicycle lumicycle, int x, int y) {
        Emplacement haut = new Emplacement(x, y - 1); // verification de la case en haut
        return testCase(lumicycle, haut);
    }

    private boolean goDown(Lumicycle lumicycle, int x, int y) {
        Emplacement bas = new Emplacement(x, y + 1); // verification de la case en bas
        return testCase(lumicycle, bas);
    }
}

class Grille {

    private int N; // nbr de joueurs
    private ArrayList<Lumicycle> L; // liste de joueurs/lumicycles

    public Grille(int N, int X0, int X1, int Y0, int Y1) {

        this.N = N;
        this.L = new ArrayList<>();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Emplacement emplacement = (Emplacement) obj;
        if (emplacement.getX() == this.X) {
            if (emplacement.getY() == this.Y) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
