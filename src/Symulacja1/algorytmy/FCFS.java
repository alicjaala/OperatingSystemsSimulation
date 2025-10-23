package Symulacja1.algorytmy;

import Symulacja1.dane.Proces;

public class FCFS {
	
	public void start(Kolejka k, SymulatorCzasu s)
	{
		while(!k.czyPusta())
		{
			Proces p = k.pobierzProces();
			s.wykonaj(p, p.getDlugosc());
		}
	}
	

}
