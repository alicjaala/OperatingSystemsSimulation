package Symulacja1.symulacja;

import java.util.ArrayList;
import java.util.List;

import Symulacja1.algorytmy.Kolejka;
import Symulacja1.dane.Proces;

public class Obliczenia {
	
	public static double Srednia(List<Integer> lista)
	{
		if(lista.isEmpty())
		{
			return -1;
		}
		
		double suma = 0;
		
		for (int liczba : lista) {
            suma += liczba;
        }
		
		return suma / lista.size();
		
	}
	
	public static int Najdluzszy(List<Integer> lista)
	{
		int maksi = Integer.MIN_VALUE;
		
		for(int liczba : lista) {
			if (liczba > maksi) {
				maksi = liczba;
			}
		}
		return maksi;
	}
	
	public static double SredniaRR(ArrayList<Integer> lista)
	{

		double suma = 0;
		
		for (int liczba : lista) {
            suma += liczba;
        }
		
		return suma / lista.size();
		
	}
	/*
	public static double SredniaRR(Kolejka k)
	{
		double suma = 0;
		System.out.println("liczę średnią");
		
		for (Proces p : k.getKolejka()) {
			suma += p.getDoRozpoczecia();
			System.out.println("Czas do rozpoczecia: " + p.getDoRozpoczecia());
        }
		return suma / k.rozmiar();
	}
*/
}
