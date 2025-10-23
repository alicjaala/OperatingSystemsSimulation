package Symulacja4;

import java.util.ArrayList;
import java.util.List;

public class Proporcjonalny {

    public static void przydzielRamki(int ileRamek, List<CiagStron> ciagi) {
        int licznikBledow = 0;

        int S = 0;
        for (CiagStron ciag : ciagi) {
            S += ciag.getRozmiar();
        }

        List<Pamiec> pamieciProcesow = new ArrayList<>();
        int sumRamekPrzydzielonych = 0;

        for (CiagStron ciag : ciagi) {
            int si = ciag.getRozmiar();
            int fi = (si * ileRamek) / S;
            sumRamekPrzydzielonych += fi;
            pamieciProcesow.add(new Pamiec(fi));
        }

        int pozostaleRamki = ileRamek - sumRamekPrzydzielonych;
        int index = 0;
        while (pozostaleRamki > 0) {
            Pamiec pamiec = pamieciProcesow.get(index);
            pamiec = new Pamiec(pamiec.getRozmiar() + 1);
            pamieciProcesow.set(index, pamiec);
            pozostaleRamki--;
            index = (index + 1) % pamieciProcesow.size();
        }

        for (int i = 0; i < ciagi.size(); i++) {
            Pamiec pamiec = pamieciProcesow.get(i);
            CiagStron ciagStron = ciagi.get(i);
            licznikBledow += LRU.start(pamiec, ciagStron);
        }
        System.out.println("Przydział proporcjonalny: " + licznikBledow);
    }
}
