package Symulacja4;

import java.util.ArrayList;
import java.util.Random;

public class CiagStron {

    private Random random;
    private int rozmiar;
    private ArrayList<Integer> ciag;
    private int poczatekZakresu;
    private int koniecZakresu;

    public CiagStron(int rozmiar, int poczatekZakresu, int koniecZakresu) {
        random = new Random();
        this.rozmiar = rozmiar;
        this.poczatekZakresu = poczatekZakresu;
        this.koniecZakresu = koniecZakresu;
        ciag = new ArrayList<>();
    }

    public ArrayList<Integer> generujCiag() {
        int liczbaSekcji = 100;
        int sekcjaRozmiar = rozmiar / liczbaSekcji;
        int liczbaStronWirtualnych = koniecZakresu - poczatekZakresu + 1;

        for (int i = 0; i < liczbaSekcji; i++) {
            int poczatekSekcji = poczatekZakresu + random.nextInt(Math.max(1, liczbaStronWirtualnych - sekcjaRozmiar));
            for (int j = 0; j < sekcjaRozmiar; j++) {
                ciag.add(poczatekSekcji + random.nextInt(Math.max(1, sekcjaRozmiar)));
            }
        }

        return ciag;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public ArrayList<Integer> getCiag() {
        return ciag;
    }

    public boolean czyPusty() {
        return ciag.isEmpty();
    }

    public int pobierzStrone() {
        int wyjscie = ciag.get(0);
        ciag.remove(0);
        return wyjscie;
    }

    public CiagStron kopiuj() {
        CiagStron kopia = new CiagStron(this.rozmiar, this.poczatekZakresu, this.koniecZakresu);
        kopia.ciag = new ArrayList<>(this.ciag);
        return kopia;
    }
}
