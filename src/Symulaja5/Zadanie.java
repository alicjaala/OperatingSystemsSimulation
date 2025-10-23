package Symulaja5;

public class Zadanie {

    public double ileObciaza;
    private int czasPojawienia;
    private int dlugosc;

    public Zadanie(double ileObciaza, int czasPojawienia, int dlugosc)
    {
        this.ileObciaza = ileObciaza;
        this.czasPojawienia = czasPojawienia;
        this.dlugosc = dlugosc;
    }

    public double getIleObciaza()
    {
        return this.ileObciaza;
    }

    public int  getCzasPojawienia()
    {
        return this.czasPojawienia;
    }

    public int getDlugosc()
    {
        return this.dlugosc;
    }

}
