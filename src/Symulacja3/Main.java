package Symulacja3;

public class Main {


    public static void main(String[] args) {

        int ileOdwolan = 15000;
        CiagStron ciagFIFO = new CiagStron(ileOdwolan);
        ciagFIFO.generujCiag();

        CiagStron ciagOPT = ciagFIFO.kopiuj();
        CiagStron ciagRAND = ciagFIFO.kopiuj();
        CiagStron ciagLRU = ciagFIFO.kopiuj();
        CiagStron ciagALRU = ciagFIFO.kopiuj();

        int frameSize = 200;

        Pamiec pamiec = new Pamiec(frameSize);
        System.out.println("FIFO: " + FIFO.start(ciagFIFO, pamiec));
        System.out.println("OPT: " + OPT.start(ciagOPT, pamiec));
        System.out.println("LRU: " + LRU.start(pamiec, ciagLRU));
        System.out.println("A-LRU: " + ALRU.start(pamiec, ciagALRU));
        System.out.println("RAND: " + RAND.start(ciagRAND, pamiec));
    }

    }

