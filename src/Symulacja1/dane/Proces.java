package Symulacja1.dane;

import java.util.ArrayList;

public class Proces {
	
	private int dlugosc;
	private int czasPojawienia;
	private int czasOczekiwania;
	private Integer doRozpoczecia;
	private static ArrayList<Integer> listaDoRozpoczecia = new ArrayList<>();
	
	private boolean czyWKolejce;
	
	public static final int poczatkowyCzas = 0;
	
	public Proces(int dlugosc, int czasPojawienia)
	{
		this.dlugosc = dlugosc;
		this.czasPojawienia = czasPojawienia;
		this.czasOczekiwania = poczatkowyCzas;
		this.doRozpoczecia = null;
		
	}
	
	public boolean czyWKolejce() {
        return czyWKolejce;
    }

    public void ustawWKolejce(boolean czyWKolejce) {
        this.czyWKolejce = czyWKolejce;
    }

	
	public static ArrayList<Integer> getListaDoRozpoczecia()
	{
		return listaDoRozpoczecia;
	}

	public Integer getDoRozpoczecia() {
        return doRozpoczecia;
    }
	
	public void setDoRozpoczecia(int doRozpoczecia) {
		//System.out.println("Jaki ma teraz czas do rozpoczęcia: " + this.doRozpoczecia);
        if (this.doRozpoczecia == null) {
            this.doRozpoczecia = doRozpoczecia;
            //System.out.println(this.doRozpoczecia);
            listaDoRozpoczecia.add(doRozpoczecia);
            
        }
    }

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public int getCzasPojawienia() {
		return czasPojawienia;
	}

	public void setCzasPojawienia(int czasPojawienia) {
		this.czasPojawienia = czasPojawienia;
	}

	public int getCzasOczekiwania() {
		return czasOczekiwania;
	}

	public void setCzasOczekiwania(int czasOczekiwania) {
		this.czasOczekiwania = czasOczekiwania;
	}
	
	

}
