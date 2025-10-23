package Symulacja4;

import java.util.*;

public class Strefowy {
    private static class Proces {
        CiagStron ciagStron;
        Pamiec pamiec;
        int WSS;
        boolean wstrzymany;

        Proces(CiagStron ciagStron, int ramkiPocztkowe) {
            this.ciagStron = ciagStron;
            this.pamiec = new Pamiec(ramkiPocztkowe);
            this.WSS = 0;
            this.wstrzymany = false;
        }
    }

    public static void przydzielRamki(int ileRamek, List<CiagStron> ciagi, int deltaT) {
        List<Proces> procesy = new ArrayList<>();
        int liczbaProcesow = ciagi.size();
        int poczatkoweRamki = ileRamek / liczbaProcesow;

        for (CiagStron ciag : ciagi) {
            procesy.add(new Proces(ciag, poczatkoweRamki));
        }

        int licznikBledow = 0;
        int czas = 0;

        while (true) {
            boolean wszystkieProcesyWstrzymane = true;
            for (Proces proces : procesy) {
                if (!proces.ciagStron.czyPusty()) {
                    wszystkieProcesyWstrzymane = false;
                    break;
                }
            }
            if (wszystkieProcesyWstrzymane) {
                break;
            }

            for (Proces proces : procesy) {
                if (!proces.wstrzymany) {
                    licznikBledow += LRU.start(proces.pamiec, proces.ciagStron);
                }
            }

            czas += deltaT;

            int D = 0;
            for (Proces proces : procesy) {
                proces.WSS = obliczWSS(proces, deltaT);
                D += proces.WSS;
            }

            if (D > ileRamek) {
                wstrzymajProces(procesy);
            } else {
                przydzielRamkiProcesom(procesy, ileRamek, D);
            }
        }
        System.out.println("Model strefowy: " + licznikBledow);
    }


    private static int obliczWSS(Proces proces, int deltaT) {
        List<Integer> ostatnieStrony = new ArrayList<>();
        List<Integer> ciag = proces.ciagStron.getCiag();
        int startIndex = Math.max(0, ciag.size() - deltaT);

        for (int i = startIndex; i < ciag.size(); i++) {
            int strona = ciag.get(i);
            if (!ostatnieStrony.contains(strona)) {
                ostatnieStrony.add(strona);
            }
        }

        return ostatnieStrony.size();
    }

    private static void wstrzymajProces(List<Proces> procesy) {
        Proces doWstrzymania = Collections.min(procesy, new Comparator<Proces>() {
            @Override
            public int compare(Proces proces1, Proces proces2) {
                return Integer.compare(proces1.WSS, proces2.WSS);
            }
        });
        doWstrzymania.wstrzymany = true;
        doWstrzymania.pamiec = new Pamiec(0);
    }


    private static void przydzielRamkiProcesom(List<Proces> procesy, int ileRamek, int D) {
        for (Proces proces : procesy) {
            if (!proces.wstrzymany) {
                proces.pamiec = new Pamiec(proces.WSS);
            }
        }
    }
}