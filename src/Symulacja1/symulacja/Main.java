package Symulacja1.symulacja;

import Symulacja1.algorytmy.*;
import Symulacja1.dane.Proces;
import Symulacja1.generator.Generator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int liczbaSymulacji = 30;
        double sumaSredniaFCFS = 0, sumaSredniaSJF = 0, sumaSredniaRR = 0;
        int sumaMaksFCFS = 0, sumaMaksSJF = 0, sumaMaksRR = 0;
        int sumaRR = 0;
        int liczbaPrzejsc = 0;

        for (int symulacjaNr = 0; symulacjaNr < liczbaSymulacji; symulacjaNr++) {
            Kolejka kolejkaFCFS = new Kolejka();
            Generator generator = new Generator();

            for (int i = 0; i < 10000; i++) {
                Proces nowyProces = generator.startProces();
                kolejkaFCFS.dodajProces(nowyProces);
            }

            Kolejka kolejkaSJF = kolejkaFCFS.kopiuj();
            Kolejka kolejkaRR = kolejkaFCFS.kopiuj();

            kolejkaFCFS.sortujP();
            kolejkaSJF.sortujP();
            kolejkaRR.sortujP();
            
            kolejkaSJF.sortuj();

            Symulacja symulacja = new Symulacja();
            SymulatorCzasu symulatorFCFS = new SymulatorCzasu();
            SymulatorCzasu symulatorSJF = new SymulatorCzasu();
            SymulatorCzasu symulatorRR = new SymulatorCzasu();


            List<Integer> czasyOczekiwaniaFCFS = symulacja.symulujFCFS(kolejkaFCFS, symulatorFCFS);
            sumaSredniaFCFS += Obliczenia.Srednia(czasyOczekiwaniaFCFS);
            sumaMaksFCFS += Obliczenia.Najdluzszy(czasyOczekiwaniaFCFS);

            List<Integer> czasyOczekiwaniaSJF = symulacja.symulujSJF(kolejkaSJF, symulatorSJF);
            sumaSredniaSJF += Obliczenia.Srednia(czasyOczekiwaniaSJF);
            sumaMaksSJF += Obliczenia.Najdluzszy(czasyOczekiwaniaSJF);

            int kwantCzasu = 200000;
            List<Integer> czasyOczekiwaniaRR = symulacja.symulujRR(kolejkaRR, symulatorRR, kwantCzasu);
            sumaSredniaRR += Obliczenia.Srednia(czasyOczekiwaniaRR);
            //System.out.println(Obliczenia.Najdluzszy(czasyOczekiwaniaRR));
            sumaMaksRR += Obliczenia.Najdluzszy(czasyOczekiwaniaRR);
            sumaRR += Obliczenia.SredniaRR(Proces.getListaDoRozpoczecia());
            liczbaPrzejsc += RR.getPrzelaczenia();
            
            
            /*
            //System.out.println("Ile elementów na liście: " + Proces.getListaDoRozpoczecia().size());
            System.out.println(Obliczenia.Srednia(czasyOczekiwaniaFCFS));
            System.out.println(Obliczenia.Srednia(czasyOczekiwaniaSJF));
            System.out.println(Obliczenia.Srednia(czasyOczekiwaniaRR));
            */
            
        }

        double sredniaSrednichFCFS = sumaSredniaFCFS / liczbaSymulacji;
        double sredniaSrednichSJF = sumaSredniaSJF / liczbaSymulacji;
        double sredniaSrednichRR = sumaSredniaRR / liczbaSymulacji;
        double sredniaMaksFCFS = (double)sumaMaksFCFS / liczbaSymulacji;
        double sredniaMaksSJF = (double)sumaMaksSJF / liczbaSymulacji;
        double sredniaMaksRR = (double)sumaMaksRR / liczbaSymulacji;
        double sredniaSumaRR = sumaRR / liczbaSymulacji;
        double sredniaLiczbaPrzejsc = liczbaPrzejsc / liczbaSymulacji;

        System.out.println("Średnia średnich czasów oczekiwania dla FCFS: " + sredniaSrednichFCFS);
        System.out.println("Średnia najdłuższych czasów oczekiwania dla FCFS: " + sredniaMaksFCFS + "\n");

        System.out.println("Średnia średnich czasów oczekiwania dla SJF: " + sredniaSrednichSJF);
        System.out.println("Średnia najdłuższych czasów oczekiwania dla SJF: " + sredniaMaksSJF + "\n");

        System.out.println("Średnia średnich czasów oczekiwania dla RR: " + sredniaSrednichRR);
        System.out.println("Średnia najdłuższych czasów oczekiwania dla RR: " + sredniaMaksRR);
        System.out.println("Średnia czasów oczekiwania do rozpoczęcia dla RR: " + sredniaSumaRR);
        System.out.println("Średnia ilość przejść pomiędzy procesami dla RR: " + sredniaLiczbaPrzejsc);
    }
}
