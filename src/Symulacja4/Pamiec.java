package Symulacja4;

import java.util.ArrayList;

public class Pamiec {

    private ArrayList<Integer> lista;
    private ArrayList<Boolean> bityOdwołania;
    private int rozmiar;

    public Pamiec(int rozmiar) {
        this.rozmiar = rozmiar;
        lista = new ArrayList<>(rozmiar);
        bityOdwołania = new ArrayList<>(rozmiar);
        for (int i = 0; i < rozmiar; i++) {
            lista.add(-1);
            bityOdwołania.add(false);
        }
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public int naKtorejPozycji(int strona) {
        return lista.indexOf(strona);
    }

    public void dodajNaPozycje(int pozycja, int strona) {
        lista.set(pozycja, strona);
        bityOdwołania.set(pozycja, true);
    }

    public int szukajPustejPozycji() {
        return lista.indexOf(-1);
    }

    public boolean getBitOdwołania(int pozycja) {
        return bityOdwołania.get(pozycja);
    }

    public void ustawBitOdwołania(int pozycja, boolean wartosc) {
        bityOdwołania.set(pozycja, wartosc);
    }

    public void przesunNaKoniec(int pozycja) {
        int strona = lista.remove(pozycja);
        boolean bit = bityOdwołania.remove(pozycja);
        lista.add(strona);
        bityOdwołania.add(bit);
    }
}
