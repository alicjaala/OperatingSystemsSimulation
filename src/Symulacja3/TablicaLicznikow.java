package Symulacja3;

import java.util.ArrayList;

public class TablicaLicznikow {

    private ArrayList<Integer> liczniki;
    int rozmiar;

    public TablicaLicznikow(int rozmiar)
    {
        liczniki = new ArrayList<>();
        this.rozmiar = rozmiar;

        for(int i=0; i<rozmiar; i++)
        {
            liczniki.add(0);
        }
    }

    public ArrayList<Integer> getLiczniki()
    {
        return liczniki;
    }

    public void wyzeruj(int n)
    {
        liczniki.set(n, 0);
    }

    public void zwiekszPozostalym(int n)
    {
        for(int i=0; i<rozmiar; i++) {
            if(i != n) {
                liczniki.set(i, liczniki.get(i) + 1);
            }
        }
    }

    public int szukajMaksa()
    {
        int maks = Integer.MIN_VALUE;
        int wyjscie = -1;
        for(int i=0; i<rozmiar; i++) {
            if(liczniki.get(i) > maks) {
                maks = liczniki.get(i);
                wyjscie = i;
            }
        }
        return wyjscie;
    }

    public int szukajMinimum()
    {
        int mini = Integer.MAX_VALUE;
        int wyjscie = -1;
        for(int i=0; i<rozmiar; i++) {
            if(liczniki.get(i) < mini) {
                mini = liczniki.get(i);
                wyjscie = i;
            }
        }
        return wyjscie;
    }
}
