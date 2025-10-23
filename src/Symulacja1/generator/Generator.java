package Symulacja1.generator;
import Symulacja1.algorytmy.*;
import Symulacja1.dane.*;
import Symulacja1.generator.*;
import java.util.Random;


public class Generator {
	
	private Random random;
	
	public Generator()
	{
		random = new Random();
	}
	
	public int dlugosc()
	{
		return random.nextInt(60) + 10;
	}
	
	public int momentPojawienia()
	{
		return random.nextInt(1000);
	}
	
	public Proces startProces()
	{
		int dlugosc = dlugosc();
		int czasPojawienia = momentPojawienia();
		
		return new Proces(dlugosc, czasPojawienia);
	}

}
