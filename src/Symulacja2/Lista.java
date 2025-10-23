package Symulacja2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Lista {


    private LinkedList<Zadanie> lista;

    public Lista()
    {
        lista = new LinkedList<>();
    }



    public LinkedList<Zadanie> getLista() {
        return lista;
    }




    public void setLista(LinkedList<Zadanie> lista) {
        this.lista = lista;
    }



    public void dodajZadanie(Zadanie z)
    {
        lista.offer(z);
    }

    public Zadanie pobierzZadanie()
    {
        return lista.poll();
    }

    public Zadanie peekZadanie()
    {
        return lista.peek();
    }


    public boolean czyPusta()
    {
        return lista.isEmpty();
    }

    public int rozmiar()
    {
        return lista.size();
    }


    public void sortujCzasemPojawienia() {
        Collections.sort(lista, Comparator.comparingInt(Zadanie::getCzasPojawienia));
    }


    public Lista kopiuj() {
        Lista nowaLista = new Lista();
        nowaLista.lista = new LinkedList<>(this.lista);
        return nowaLista;
    }






}
