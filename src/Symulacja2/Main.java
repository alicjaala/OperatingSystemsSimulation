package Symulacja2;

public class Main {

    public static void main(String[] args) {

        Generator generator = new Generator();
        Lista listaFCFS = new Lista();

        for (int i = 0; i < 1000; i++) {
            Zadanie noweZadanie = generator.startZadanie();
            listaFCFS.dodajZadanie(noweZadanie);
            //System.out.println("czas pojawienia: " + noweZadanie.getCzasPojawienia() + " pozycja: " + noweZadanie.getPozycja() + " priorytet: " + noweZadanie.getPriorytet());
        }

        listaFCFS.sortujCzasemPojawienia();
        Lista listaSSTF = listaFCFS.kopiuj();
        Lista listaSCAN = listaFCFS.kopiuj();
        Lista listaCSCAN = listaFCFS.kopiuj();
        Lista listaEDF = listaFCFS.kopiuj();
        Lista listaFDSCAN = listaFCFS.kopiuj();


        int wynikFCFS = FCFS.start(listaFCFS);
        int wynikSSTF = SSTF.start(listaSSTF);
        int wynikSCAN = SCAN.start(listaSCAN);
        int wynikCSCAN = CSCAN.start(listaCSCAN);
        int wynikEDF = EDF.start(listaEDF);
        int wynikFDSCAN = FDSCAN.start(listaFDSCAN);

        System.out.println("FCFS: " + wynikFCFS);
        System.out.println("SSTF: " + wynikSSTF);
        System.out.println("SCAN: " + wynikSCAN);
        System.out.println("C-SCAN: " + wynikCSCAN);
        System.out.println("EDF: " + wynikEDF);
        System.out.println("FDSCAN: " + wynikFDSCAN);
    }




}
