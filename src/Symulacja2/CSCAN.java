package Symulacja2;

import java.util.Arrays;

public class CSCAN {



    public static int start(Lista l) {
        int[] dostepne = new int[3000];
        int dystans = 0;
        int polozenie = 0;


        Zadanie pierwszeZadanie = l.pobierzZadanie();
        dystans += Math.abs(polozenie - pierwszeZadanie.getPozycja());
        polozenie = pierwszeZadanie.getPozycja();

        while (!l.czyPusta() || czySaDostepne(dostepne)) {
            while (!l.czyPusta() && l.peekZadanie().getCzasPojawienia() <= dystans) {
                Zadanie z = l.pobierzZadanie();
                dostepne[z.getPozycja()] = 1;
            }

            int najblizsze = znajdzNajblizszePrawo(polozenie, dostepne);

            if (najblizsze != -1) {
                dystans += Math.abs(najblizsze - polozenie);
                polozenie = najblizsze;
                dostepne[polozenie] = 0;
            } else {
                dystans += polozenie;
                polozenie = 0;
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
}
