package Symulacja2;

import java.util.Random;

public class Generator {

    private Random random;

    public Generator()
    {
        random = new Random();
    }

    public int pozycja()
    {
        return random.nextInt(3000) ;
    }

    public int momentPojawienia()
    {
        return random.nextInt(100000);
    }

    public int czyPriorytet()
    {
        return random.nextInt(5);
    }

    public int losujPriorytet()
    {
        return random.nextInt(100)+20;
    }

    public Zadanie startZadanie()
    {
        int pozycja = pozycja();
        int czasPojawienia = momentPojawienia();
        int pomocnicze = czyPriorytet();
        int priorytet = -1;
        if(pomocnicze == 0)
        {
            priorytet = losujPriorytet();
        }

        return new Zadanie(pozycja, czasPojawienia, priorytet );
    }

}
