package Symulacja4;

import java.util.ArrayList;
import java.util.List;

public class Sterowanie {

    private static final double L = 0.1; //dolny próg
    private static final double U = 0.5; //górny próg
    private static final double H = 0.9; //próg wstrzymywania

    public static void przydzielRamki(int ileRamek, List<CiagStron> ciagi, int deltaT) {
        int licznikBledow = 0;

        int S = 0;
        for (CiagStron ciag : ciagi) {
            S += ciag.getRozmiar();
        }

        List<Pamiec> pamieciProcesow = new ArrayList<>();
        List<Integer> bledyStrony = new ArrayList<>(ciagi.size());


        for (int i = 0; i < ciagi.size(); i++) {
            int si = ciagi.get(i).getRozmiar();
            int fi = (si * ileRamek) / S;
            pamieciProcesow.add(new Pamiec(fi));
            bledyStrony.add(0);
        }

        boolean wTrakcie = true;
        int czas = 0;

        while (wTrakcie) {
            wTrakcie = false;

            for (int i = 0; i < ciagi.size(); i++) {
                if (!ciagi.get(i).czyPusty()) {
                    wTrakcie = true;
                    Pamiec pamiec = pamieciProcesow.get(i);
                    CiagStron ciagStron = ciagi.get(i);
                    int poczatkoweBledy = bledyStrony.get(i);

                    licznikBledow += LRU.start(pamiec, ciagStron);
                    int noweBledy = bledyStrony.get(i) + licznikBledow - poczatkoweBledy;
                    double ppf = (double) noweBledy / deltaT;

                    if (ppf > H) {
                        //System.out.println("Proces " + i + " wstrzymany z powodu PPF = " + ppf);
                    } else if (ppf > U) {
                        pamiec = new Pamiec(pamiec.getRozmiar() + 1);
                        pamieciProcesow.set(i, pamiec);
                    } else if (ppf < L && pamiec.getRozmiar() > 1) {
                        pamiec = new Pamiec(pamiec.getRozmiar() - 1);
                        pamieciProcesow.set(i, pamiec);
                    }

                    bledyStrony.set(i, noweBledy);
                }
            }

            czas += deltaT;
        }

        System.out.println("Sterowanie częstością błędów strony: " + licznikBledow);
    }
}
