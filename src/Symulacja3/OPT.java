package Symulacja3;

import java.util.ArrayList;
import java.util.List;

public class OPT {

    public static int start(CiagStron s, Pamiec p) {
        int licznikBledow = 0;
        List<Integer> ciagStron = new ArrayList<>(s.getCiag());
        int ciagIndex = 0;

        while (ciagIndex < ciagStron.size()) {
            int strona = ciagStron.get(ciagIndex);
            if (p.naKtorejPozycji(strona) == -1) {
                licznikBledow++;
                int puste = p.szukajPustejPozycji();
                if (puste != -1) {
                    p.dodajNaPozycje(puste, strona);
                } else {
                    int doZamiany = znajdzStroneDoZamiany(ciagStron, ciagIndex, p);
                    if (doZamiany != -1) {
                        p.dodajNaPozycje(doZamiany, strona);
                    }
                }
            }
            ciagIndex++;
        }
        return licznikBledow;
    }

    private static int znajdzStroneDoZamiany(List<Integer> ciagStron, int ciagIndex, Pamiec p) {
        int najdalszaOdleglosc = -1;
        int stronaDoZamiany = -1;

        for (int i = 0; i < p.getRozmiar(); i++) {
            int strona = p.getLista().get(i);
            int odleglosc = Integer.MAX_VALUE;

            for (int j = ciagIndex + 1; j < ciagStron.size(); j++) {
                if (ciagStron.get(j) == strona) {
                    odleglosc = j;
                    break;
                }
            }

            if (odleglosc > najdalszaOdleglosc) {
                najdalszaOdleglosc = odleglosc;
                stronaDoZamiany = i;
            }
        }
        return stronaDoZamiany;
    }


}
