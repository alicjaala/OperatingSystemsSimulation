package Symulacja2;

public class SSTF {



    public static int start(Lista l) {
        int[] dostepne = new int[3000];
        int dystans = 0;
        int polozenie = 0;

        Zadanie z = l.pobierzZadanie();
        dystans += Math.abs(z.getPozycja() - polozenie);
        polozenie = z.getPozycja();

        while(!l.czyPusta())
        {
            while(!l.czyPusta() && l.peekZadanie().getCzasPojawienia() <= dystans)
            {
                Zadanie z2 = l.pobierzZadanie();
                dostepne[z2.getPozycja()] = 1;
            }

            int najblizsze = znajdzNajblizsze(polozenie, dostepne);
            if(najblizsze != -1)
            {
                dystans += Math.abs(najblizsze - polozenie);
                polozenie = najblizsze;
                dostepne[polozenie] = 0;
            }
            else {
                Zadanie z3 = l.pobierzZadanie();

                dystans += Math.abs(z3.getPozycja() - polozenie);
                polozenie = z3.getPozycja();
            }
        }

        while (czySaDostepne(dostepne)) {
            int najblizsze = znajdzNajblizsze(polozenie, dostepne);
            if(najblizsze != -1) {
                dystans += Math.abs(najblizsze - polozenie);
                polozenie = najblizsze;
                dostepne[polozenie] = 0;
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


    private static int znajdzNajblizsze(int obecnaPozycja, int[] dostepne) {
        int lewyIndeks = -1;
        int prawyIndeks = -1;
        int lewaOdleglosc = Integer.MAX_VALUE;
        int prawaOdleglosc = Integer.MAX_VALUE;

        for (int i = obecnaPozycja; i >= 0; i--) {
            if (dostepne[i] == 1) {
                lewyIndeks = i;
                lewaOdleglosc = obecnaPozycja - i;
                break;
            }
        }

        for (int i = obecnaPozycja; i < dostepne.length; i++) {
            if (dostepne[i] == 1) {
                prawyIndeks = i;
                prawaOdleglosc = i - obecnaPozycja;
                break;
            }
        }

        if (lewaOdleglosc <= prawaOdleglosc) {
            return lewyIndeks;
        } else {
            return prawyIndeks;
        }
    }



}

