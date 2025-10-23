package Symulacja1.algorytmy;

import Symulacja1.dane.Proces;

public class RR {
	
	private static int przelaczenia;
	
	public static int getPrzelaczenia() {
		return przelaczenia;
	}
	

	public static void start(Kolejka k, int kwantCzasu, SymulatorCzasu s) {
		przelaczenia = 0;
		int d = 0;
        while (!k.czyPusta()) {
            Proces p = k.pobierzProces();
            if(p.getDoRozpoczecia() == null)
            {
            	d = p.getDlugosc();
            }
            //System.out.println("Aktualny czas: " + s.getCzas());
            //p.setDoRozpoczecia(s.getCzas() - p.getCzasPojawienia());
            przelaczenia++;
            int czasDoWykonania = Math.min(p.getDlugosc(), kwantCzasu);
            p.setDoRozpoczecia(p.getCzasPojawienia() + czasDoWykonania);
            p.setDlugosc(p.getDlugosc() - czasDoWykonania);
        	//System.out.println("Aktualny czas " + s.getCzas() + " Dlugosc " + d + " czas pojawienia " + p.getCzasPojawienia());            
        	int czasOczekiwania = Math.max(0, s.getCzas() - p.getCzasPojawienia());
            s.setCzas( p.getCzasPojawienia() + czasOczekiwania + czasDoWykonania);
            int poprzedniCzas = p.getCzasOczekiwania();
            p.setCzasOczekiwania(poprzedniCzas + czasOczekiwania);

            if (p.getDlugosc() > 0) {
                k.dodajProces(p);
            }
            else {
                //System.out.println("Wykonywanie procesu: " + p + ", czas oczekiwania: " + p.getCzasOczekiwania());
            	(s.getCzasyOczekiwania()).add(p.getCzasOczekiwania());
        }
    }
	}

} 



