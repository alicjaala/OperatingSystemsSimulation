package Symulacja1.algorytmy;

import Symulacja1.dane.Proces;

public class SJF {
    
	public void start(Kolejka k, SymulatorCzasu s) {  
        while (!k.czyPusta()) {
            Proces minp = znajdzNajkrotszyProces(k, s);
            if (minp == null) {
                break;
            }
            s.wykonaj(minp, minp.getDlugosc());
        }
    }
    
	private Proces znajdzNajkrotszyProces(Kolejka k, SymulatorCzasu s) {
	    int czas = s.getCzas();
	    Proces minP = null;
	    int minD = Integer.MAX_VALUE;
	    boolean znalezionoProces = false;

	    while (!znalezionoProces) {
	        minD = Integer.MAX_VALUE; 

	        for (Proces p : k.getKolejka()) {
	            if (p.getCzasPojawienia() <= czas && p.getDlugosc() < minD) {
	                minP = p;
	                minD = p.getDlugosc();
	                znalezionoProces = true;
	            }
	        }

	        if (!znalezionoProces) {
	            int minCzasPojawienia = Integer.MAX_VALUE;
	            for (Proces p : k.getKolejka()) {
	                if (p.getCzasPojawienia() < minCzasPojawienia) {
	                    minCzasPojawienia = p.getCzasPojawienia();
	                }
	            }
	            czas = minCzasPojawienia;
	        }
	    }

	    k.getKolejka().remove(minP); 
	    return minP;
	}



}
