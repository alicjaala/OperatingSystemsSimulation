package Symulacja3;

import java.util.LinkedList;
import java.util.Queue;

public class FIFO {


    public static int start(CiagStron s, Pamiec p) {
        int licznikBledow = 0;
        Queue<Integer> kolejka = new LinkedList<>();

        while (!s.czyPusty()) {
            int strona = s.pobierzStrone();
            if (p.naKtorejPozycji(strona) == -1) {
                licznikBledow++;
                int puste = p.szukajPustejPozycji();
                if (puste != -1) {
                    p.dodajNaPozycje(puste, strona);
                    kolejka.add(puste);
                } else {
                    int doZamiany = kolejka.poll();
                    p.dodajNaPozycje(doZamiany, strona);
                    kolejka.add(doZamiany);
                }
            }
        }
        return licznikBledow;
    }



    /*
    public static int start(CiagStron s, Pamiec p, TablicaLicznikow t)
    {
        int licznikBledow = 0;

        while(!s.czyPusty()) {
            int strona = s.pobierzStrone();
            int pom = p.naKtorejPozycji(strona);
            if(pom == -1) {
                licznikBledow++;
                int puste = p.szukajPustejPozycji();
                if(puste != -1) {
                    p.dodajNaPozycje(puste, strona);
                    t.zwiekszPozostalym(puste);
                } else {
                    int doZamiany = t.szukajMaksa();
                    p.dodajNaPozycje(doZamiany, strona);
                    t.wyzeruj(doZamiany);
                    t.zwiekszPozostalym(doZamiany);
                }
            }
        }
        return licznikBledow;
    }
*/

}