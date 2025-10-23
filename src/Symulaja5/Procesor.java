package Symulaja5;

import java.util.ArrayList;
import java.util.List;

public class Procesor {

    private int id;
    public double obciazenie;
    private ListaZadan listaZadan;
    private List<Zadanie> listaDoWykonania;

    public Procesor(int id, ListaZadan listaZadan) {
        this.id = id;
        this.obciazenie = 0.0;
        this.listaZadan = listaZadan;
        this.listaDoWykonania = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public double getObciazenie() {
        return this.obciazenie;
    }

    public void setObciazenie(double obciazenie) {
        this.obciazenie = obciazenie;
    }

    public void zwiekszObciazenie(double obciazenie) {
        this.obciazenie += obciazenie;
    }

    public void zmniejszObciazenie(double obciazenie) {
        this.obciazenie -= obciazenie;
    }

    public ListaZadan getListaZadan()
    {
        return this.listaZadan;
    }

    public List<Zadanie> getListaDoWykonania()
    {
        return this.listaDoWykonania;
    }

    public boolean czyMozeWykonac(Zadanie zadanie, double p) {
        if (obciazenie + zadanie.getIleObciaza() <= p) {
            return true;
        }
        return false;
    }

    public void dodajDoWykonania(Zadanie zadanie)
    {
        listaDoWykonania.add(zadanie);
    }


}
