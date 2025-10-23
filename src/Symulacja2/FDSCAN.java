package Symulacja2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class FDSCAN {

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
            while(!l.czyPusta() && (l.peekZadanie().getCzasPojawienia() <= dystans || dostepneBez.isEmpty()))
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
                int glowicaWczesniej = polozenie;
                polozenie = doWykonania.getPozycja();

                while (!dostepneBez.isEmpty() && dostepneBez.peek().getCzasPojawienia() <= dystans) {
                    int pozycjaPoDrodze = dostepneBez.peek().getPozycja();
                    if ((glowicaWczesniej >= polozenie && pozycjaPoDrodze <= glowicaWczesniej && pozycjaPoDrodze >= polozenie) ||
                            (glowicaWczesniej < polozenie && pozycjaPoDrodze >= glowicaWczesniej && pozycjaPoDrodze <= polozenie)) {
                        dostepneBez.poll();
                    } else {
                        break;
                    }
                }

            }
            if(!priorytetowe.isEmpty())
            {
                Zadanie doWykonania = priorytetowe.poll();
                int droga = Math.abs(doWykonania.getPozycja() - polozenie);
                int glowicaWczesniej = polozenie;
                if(doWykonania.getPriorytet() >= droga)
                {
                    dystans += Math.abs(doWykonania.getPozycja() - polozenie);
                    polozenie = doWykonania.getPozycja();
                }

                while(!priorytetowe.isEmpty()  && priorytetowe.peek().getCzasPojawienia() <= dystans)
                {
                    int pozycjaPoDrodze = priorytetowe.peek().getPozycja();
                    if ((glowicaWczesniej >= polozenie && pozycjaPoDrodze <= glowicaWczesniej && pozycjaPoDrodze >= polozenie) ||
                            (glowicaWczesniej < polozenie && pozycjaPoDrodze >= glowicaWczesniej && pozycjaPoDrodze <= polozenie)) {
                        priorytetowe.poll();
                    } else {
                        break;
                    }
                }
                while(!dostepneBez.isEmpty()  && dostepneBez.peek().getCzasPojawienia() <= dystans) {
                    int pozycjaPoDrodze = dostepneBez.peek().getPozycja();
                    if ((glowicaWczesniej >= polozenie && pozycjaPoDrodze <= glowicaWczesniej && pozycjaPoDrodze >= polozenie) ||
                        (glowicaWczesniej < polozenie && pozycjaPoDrodze >= glowicaWczesniej && pozycjaPoDrodze <= polozenie)) {
                        dostepneBez.poll();
                    } else {
                        break;
                }
            }

            }

        }
        return dystans;
    }


}
