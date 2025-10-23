package Symulacja2;

public class Zadanie {

    private int pozycja;
    private int czasPojawienia;

    private boolean czyWKolejce;
    private int odleglosc;
    private int priorytet;


    public Zadanie(int pozycja, int czasPojawienia, int priorytet)
    {
        this.pozycja = pozycja;
        this.czasPojawienia = czasPojawienia;
        this.priorytet = priorytet;

    }

    public int getPriorytet()
    {
        return priorytet;
    }

    public void setPriorytet(int priorytet)
    {
        this.priorytet = priorytet;
    }

    public int getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(int odleglosc) {
        this.odleglosc = odleglosc;
    }

    public boolean czyWKolejce() {
        return czyWKolejce;
    }

    public void ustawWKolejce(boolean czyWKolejce) {
        this.czyWKolejce = czyWKolejce;
    }





    public int getPozycja() {
        return pozycja;
    }

    public void setPozycja(int pozycja) {
        this.pozycja = pozycja;
    }

    public int getCzasPojawienia() {
        return czasPojawienia;
    }

    public void setCzasPojawienia(int czasPojawienia) {
        this.czasPojawienia = czasPojawienia;
    }




}
