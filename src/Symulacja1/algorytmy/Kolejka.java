package Symulacja1.algorytmy;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import Symulacja1.dane.Proces;

public class Kolejka {
	 
	private LinkedList<Proces> kolejka;
	
	public Kolejka()
	{
		kolejka = new LinkedList<>();
	}
	
	
	
	public LinkedList<Proces> getKolejka() {
		return kolejka;
	}



	public void setKolejka(LinkedList<Proces> kolejka) {
		this.kolejka = kolejka;
	}



	public void dodajProces(Proces p)
	{
		kolejka.offer(p);
	}
	
	public Proces pobierzProces()
	{
		return kolejka.poll();
	}
	
	public boolean czyPusta()
	{
		return kolejka.isEmpty();
	}
	
	public int rozmiar()
	{
		return kolejka.size();
	}
	
	 public void sortuj() {
	        Collections.sort(kolejka, Comparator.comparingInt(Proces::getDlugosc));
	    }
	 
	 public void sortujP() {
		    Collections.sort(kolejka, Comparator.comparingInt(Proces::getCzasPojawienia));
		}

	 /*
	   public Kolejka kopiuj() {
	        Kolejka nowaKolejka = new Kolejka();
	        for (Proces p : this.kolejka) {
	            Proces kopiaProcesu = new Proces(p.getDlugosc(), p.getCzasPojawienia()); // Użyj konstruktora kopiującego
	            nowaKolejka.dodajProces(kopiaProcesu);
	        }
	        return nowaKolejka;
	    }
	    */
	 public Kolejka kopiuj() {
		    Kolejka nowaKolejka = new Kolejka();
		    nowaKolejka.kolejka = new LinkedList<>(this.kolejka);
		    return nowaKolejka;
		}

	 




}
