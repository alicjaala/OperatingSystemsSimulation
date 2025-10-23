package Symulaja5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    private Random random;

    public Generator()
    {
        random = new Random();
    }

    public double generujObciazenie()
    {
        return (random.nextInt(15) + 5);
    }

    public int generujCzasPojawienia()
    {
        return random.nextInt(1000);
    }

    public int generujDlugosc()
    {
        return random.nextInt(200) + 100;
    }

    public Zadanie generujZadanie()
    {
        double ileObciaza = generujObciazenie();
        int czasPojawienia = generujCzasPojawienia();
        int dlugosc = generujDlugosc();

        return new Zadanie(ileObciaza, czasPojawienia, dlugosc);
    }

    public ListaZadan generujListe()
    {
        ListaZadan lista = new ListaZadan();
        int dlugoscListy = random.nextInt(400) + 100;


        for(int i=0; i<dlugoscListy; i++)
        {
            Zadanie noweZadanie = generujZadanie();
            lista.dodajZadanie(noweZadanie);
        }

        lista.sortujCzasemPojawienia();

        return lista;
    }

}
