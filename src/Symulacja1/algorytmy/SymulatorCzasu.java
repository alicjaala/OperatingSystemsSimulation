package Symulacja1.algorytmy;

import java.util.ArrayList;
import java.util.List;

import Symulacja1.dane.Proces;

public class SymulatorCzasu {
    
    private int czas;
    private List<Integer> czasyOczekiwania = new ArrayList<>();
    
    public SymulatorCzasu()
    {
        this.czas = 0;
    }
    
    public List<Integer> getCzasyOczekiwania() {
		return czasyOczekiwania;
	}

	public void setCzasyOczekiwania(List<Integer> czasyOczekiwania) {
		this.czasyOczekiwania = czasyOczekiwania;
	}

	public int getCzas()
    {
        return czas;
    }
    
    public void setCzas(int czas)
    {
    	this.czas = czas;
    }
    
    public void wykonaj(Proces p, int czasWykonania) {
    	//System.out.println("Aktualny czas " + czas + " Dlugosc " + p.getDlugosc() + " czas pojawienia " + p.getCzasPojawienia());
        int czasOczekiwania = Math.max(0, czas - p.getCzasPojawienia());
        czas = czasWykonania + p.getCzasPojawienia() + czasOczekiwania;
        p.setCzasOczekiwania(czasOczekiwania);
        //System.out.println("Wykonywanie procesu: " + p + ", czas oczekiwania: " + p.getCzasOczekiwania());
        czasyOczekiwania.add(p.getCzasOczekiwania());
    }
    
       
    public void aktualizujCzasyOczekiwania(Kolejka k, int czasWykonania) {
        while (!k.czyPusta()) {
            Proces p = k.pobierzProces();
            p.setCzasOczekiwania(p.getCzasOczekiwania() + czasWykonania);
        }
    }
    
    public List<Integer> zbierzCzasyOczekiwania() {
        return new ArrayList<>(czasyOczekiwania);
    }



}
