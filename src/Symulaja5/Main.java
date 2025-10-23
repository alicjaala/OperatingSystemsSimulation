package Symulaja5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int N = 5;

        List<Procesor> listaProcesorow1 = new ArrayList<>();
        List<Procesor> listaProcesorow2 = new ArrayList<>();
        List<Procesor> listaProcesorow3 = new ArrayList<>();

        Generator generator = new Generator();

        for(int i=0; i<=N; i++)
        {
            ListaZadan lista = generator.generujListe();
            lista.sortujCzasemPojawienia();
            Procesor p1 = new Procesor(i, lista);
            Procesor p2 = new Procesor(i, lista.kopiuj());
            Procesor p3 = new Procesor(i, lista.kopiuj());
            listaProcesorow1.add(p1);
            listaProcesorow2.add(p2);
            listaProcesorow3.add(p3);
        }


        Strategia1.start(listaProcesorow1, 80, 10);
        Strategia2.start(listaProcesorow2, 80);
        Strategia3.start(listaProcesorow3, 80);


    }
}
