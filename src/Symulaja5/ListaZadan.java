package Symulaja5;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ListaZadan {


    private LinkedList<Zadanie> listaZadan;

    public ListaZadan()
    {
        listaZadan = new LinkedList<>();
    }



    public LinkedList<Zadanie> getListaZadan() {
        return listaZadan;
    }



    public void setLista(LinkedList<Zadanie> listaZadan) {
        this.listaZadan = listaZadan;
    }



    public void dodajZadanie(Zadanie zadanie)
    {
        listaZadan.offer(zadanie);
    }

    public Zadanie pobierzZadanie()
    {
        return listaZadan.poll();
    }

    public Zadanie peekZadanie()
    {
        return listaZadan.peek();
    }


    public boolean czyPusta()
    {
        return listaZadan.isEmpty();
    }

    public int rozmiar()
    {
        return listaZadan.size();
    }


    public void sortujCzasemPojawienia() {
        Collections.sort(listaZadan, Comparator.comparingInt(Zadanie::getCzasPojawienia));
    }


    public ListaZadan kopiuj() {
        ListaZadan nowaLista = new ListaZadan();
        nowaLista.listaZadan = new LinkedList<>(this.listaZadan);
        return nowaLista;
    }






}
