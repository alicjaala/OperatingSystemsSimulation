package Symulacja4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int ileRamek = 200;
        int ileProcesow = 10;

        int[] odwolaniaDlaProcesow = new int[ileProcesow];

        for(int i=0; i<ileProcesow; i++)
        {
            odwolaniaDlaProcesow[i] = random.nextInt(10000) + 1000;
        }

        // Definiujemy różne liczby odwołań dla każdego procesu
        //int[] odwolaniaDlaProcesow = {200, 1500, 5000};

        List<CiagStron> ciagi1 = new ArrayList<>();
        List<CiagStron> ciagi2 = new ArrayList<>();
        List<CiagStron> ciagi3 = new ArrayList<>();
        List<CiagStron> ciagi4 = new ArrayList<>();
        int liczbaStronWirtualnych = 5000;
        int zakresNaProces = liczbaStronWirtualnych / ileProcesow;

        for (int i = 0; i < ileProcesow; i++) {
            int poczatekZakresu = i * zakresNaProces;
            int koniecZakresu = (i + 1) * zakresNaProces - 1;
            CiagStron ciag = new CiagStron(odwolaniaDlaProcesow[i], poczatekZakresu, koniecZakresu);
            ciag.generujCiag();
            ciagi1.add(ciag);
            ciagi2.add(ciag.kopiuj());
            ciagi3.add(ciag.kopiuj());
            ciagi4.add(ciag.kopiuj());
        }

        //List<CiagStron> ciagi3 = new ArrayList<>();
        //List<CiagStron> ciagi4 = new ArrayList<>();


        Rowny.przydzielRamki(ileRamek, ciagi1);

        Proporcjonalny.przydzielRamki(ileRamek, ciagi2);

        int deltaT = 30;
        Sterowanie.przydzielRamki(ileRamek, ciagi3, deltaT);

        int deltaTStrefowy = 30;
        Strefowy.przydzielRamki(ileRamek, ciagi4, deltaTStrefowy);
    }
}
