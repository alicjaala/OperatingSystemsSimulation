package Symulacja1.symulacja;

import java.util.List;

import Symulacja1.algorytmy.*;

public class Symulacja {
    
	public List<Integer> symulujFCFS(Kolejka k, SymulatorCzasu s) {
        FCFS fcfs = new FCFS();
        fcfs.start(k, s);
        return s.zbierzCzasyOczekiwania();
    }
    
    public List<Integer> symulujSJF(Kolejka k, SymulatorCzasu s) {
        SJF sjf = new SJF();
        sjf.start(k, s);
        return s.zbierzCzasyOczekiwania();
    }
    
    public List<Integer> symulujRR(Kolejka k, SymulatorCzasu s, int kwantCzasu) {
        RR.start(k, kwantCzasu, s);
        return s.zbierzCzasyOczekiwania();
    }
}
