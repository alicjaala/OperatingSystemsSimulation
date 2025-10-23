package Symulacja2;

import java.util.Arrays;

public class SCAN {

    public static int start(Lista l) {
        int[] dostepne = new int[3000];
        int dystans = 0;
        int polozenie = 0;
        boolean wPrawo = true;

        Zadanie pierwszeZadanie = l.pobierzZadanie();
        dystans += Math.abs(polozenie - pierwszeZadanie.getPozycja());
        polozenie = pierwszeZadanie.getPozycja();
        while (!l.czyPusta() || czySaDostepne(dostepne)) {
            while (!l.czyPusta() && l.peekZadanie().getCzasPojawienia() <= dystans) {
                Zadanie z = l.pobierzZadanie();
                dostepne[z.getPozycja()] = 1;
            }

            int najblizsze;
            if (wPrawo) {
                najblizsze = znajdzNajblizszePrawo(polozenie, dostepne);
            } else {
                najblizsze = znajdzNajblizszeLewo(polozenie, dostepne);
            }

            if (najblizsze != -1) {
                dystans += Math.abs(najblizsze - polozenie);
                polozenie = najblizsze;
                dostepne[polozenie] = 0;
            } else {
                if (!l.czyPusta()) {
                    Zadanie z = l.pobierzZadanie();
                    dystans += Math.abs(z.getPozycja() - polozenie);
                    polozenie = z.getPozycja();
                }
                if (czySaDostepne(dostepne)) {
                    wPrawo = !wPrawo;
                }
            }
        }

        return dystans;
    }

    private static boolean czySaDostepne(int[] dostepne) {
        for (int i = 0; i < dostepne.length; i++) {
            if (dostepne[i] == 1) {
                return true;
            }
        }
        return false;
    }

    private static int znajdzNajblizszePrawo(int obecnaPozycja, int[] dostepne) {
        for (int i = obecnaPozycja; i < dostepne.length; i++) {
            if (dostepne[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int znajdzNajblizszeLewo(int obecnaPozycja, int[] dostepne) {
        for (int i = obecnaPozycja; i >= 0; i--) {
            if (dostepne[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
