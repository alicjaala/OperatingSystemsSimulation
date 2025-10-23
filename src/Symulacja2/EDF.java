package Symulacja2;

import java.util.*;

public class EDF {

    public static int start(Lista l)
    {
        int dystans = 0;
        int polozenie = 0;
        LinkedList<Zadanie> dostepneBez = new LinkedList<>();
        LinkedList<Zadanie> priorytetowe = new LinkedList<>();

        Zadanie pierwszeZ = l.pobierzZadanie();
        dystans += Math.abs((pierwszeZ.getPozycja() - polozenie));
        polozenie = pierwszeZ.getPozycja();

        while(!l.czyPusta())
        {
            while(!l.czyPusta() && l.peekZadanie().getCzasPojawienia() <= dystans || dostepneBez.isEmpty())
            {
                Zadanie z = l.pobierzZadanie();
                if(z.getPriorytet() == -1)
                {
                    dostepneBez.add(z);
                }
                else {
                    priorytetowe.add(z);
                    Collections.sort(priorytetowe, Comparator.comparingInt(Zadanie::getPriorytet).reversed());
                }
            }
            if(priorytetowe.isEmpty() && !dostepneBez.isEmpty())
            {
                Zadanie doWykonania = dostepneBez.poll();
                dystans += Math.abs((doWykonania.getPozycja() - polozenie));
                polozenie = doWykonania.getPozycja();
            }
            if(!priorytetowe.isEmpty())
            {
                Zadanie doWykonania = priorytetowe.poll();
                dystans += Math.abs(doWykonania.getPozycja() - polozenie);
                polozenie = doWykonania.getPozycja();
            }

        }
        return dystans;
    }




}



