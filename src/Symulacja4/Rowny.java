package Symulacja4;

import java.util.ArrayList;
import java.util.List;

public class Rowny {

    public static void przydzielRamki(int ileRamek, List<CiagStron> ciagi) {
        int licznikBledow = 0;

        int ileProcesow = ciagi.size();
        int przydzieloneRamki = ileRamek / ileProcesow;
        int pozostaleRamki = ileRamek % ileProcesow;

        List<Pamiec> pamieciProcesow = new ArrayList<>();
        for (int i = 0; i < ileProcesow; i++) {
            int ramkiDlaProcesu = przydzieloneRamki;
            if (pozostaleRamki > 0) {
                ramkiDlaProcesu++;
                pozostaleRamki--;
            }
            pamieciProcesow.add(new Pamiec(ramkiDlaProcesu));
        }

        for (int i = 0; i < ileProcesow; i++) {
            Pamiec pamiec = pamieciProcesow.get(i);
            CiagStron ciagStron = ciagi.get(i);
            licznikBledow += LRU.start(pamiec, ciagStron);
        }
        System.out.println("Przydział równy: " + licznikBledow);
    }
}
