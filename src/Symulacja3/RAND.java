package Symulacja3;

import java.util.Random;

public class RAND {

    public static int start(CiagStron s, Pamiec p) {
        int licznikBledow = 0;
        Random random = new Random();

        while (!s.czyPusty()) {
            int strona = s.pobierzStrone();

            if (p.naKtorejPozycji(strona) == -1) {
                licznikBledow++;
                int puste = p.szukajPustejPozycji();
                if (puste != -1) {
                    p.dodajNaPozycje(puste, strona);
                } else {
                    int doZamiany = random.nextInt(p.getRozmiar());
                    p.dodajNaPozycje(doZamiany, strona);
                }
            }
        }

        return licznikBledow;
    }
}
