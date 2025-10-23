package Symulacja2;

public class FCFS {

    public static int start(Lista l)
    {
        int dystans = 0;
        int polozenie = 0;
        while(!l.czyPusta())
        {
            Zadanie z = l.pobierzZadanie();
            dystans += Math.abs(z.getPozycja() - polozenie);
            polozenie = z.getPozycja();
        }
        return dystans;


    }


}
