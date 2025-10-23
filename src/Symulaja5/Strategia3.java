package Symulaja5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Strategia3 {

    //jesli procesor x jest poniżej p to szuka komu pomóc
    //najpierw tym najbardziej obciążonym



    public static void start(List<Procesor> listaProcesorow, double p) {
        int licznikZapytan = 0;
        int licznikMigracji = 0;

        double srednieObciazenieCalosci = 0;
        List<Double> srednieObciazenia = new ArrayList<>();

        for(int i=0; i<listaProcesorow.size(); i++) {
            srednieObciazenia.add(0.0);
        }

        int czas = 1;
        boolean czyKontynuowac = true;

        while(czyKontynuowac) {
            Zadanie aktualneZadanie = null;
            Procesor aktualnyProcesor = null;
            int aktualnyIndeks = -1;
            Random r = new Random();

            while(aktualneZadanie == null) {
                int aktualnyindeks = r.nextInt(listaProcesorow.size());
                aktualnyProcesor = listaProcesorow.get(aktualnyindeks);
                if(!aktualnyProcesor.getListaZadan().czyPusta()) {
                    if(aktualnyProcesor.getListaZadan().peekZadanie().getCzasPojawienia() <= czas) {
                        aktualneZadanie = aktualnyProcesor.getListaZadan().pobierzZadanie();
                    }

            }

            }
            if(aktualneZadanie != null) {
                aktualnyProcesor.dodajDoWykonania(aktualneZadanie);
                aktualnyProcesor.obciazenie += aktualneZadanie.ileObciaza;

                while(aktualnyProcesor.obciazenie <= p) {
                    licznikZapytan += 1;
                    Random random = new Random();
                    int k = random.nextInt(listaProcesorow.size());

                    Procesor drugiProcesor = listaProcesorow.get(k);
                    if(drugiProcesor.getListaDoWykonania().size() > 0) {

                        licznikMigracji += 1;
                        Zadanie doPrzerzucenia = drugiProcesor.getListaDoWykonania().get(0);
                        drugiProcesor.getListaDoWykonania().remove(0);
                        drugiProcesor.obciazenie -= doPrzerzucenia.ileObciaza;
                        aktualnyProcesor.getListaDoWykonania().add(doPrzerzucenia);
                        aktualnyProcesor.obciazenie += doPrzerzucenia.ileObciaza;
                    } else {
                        break;
                    }
                }

            }

            czyKontynuowac = false;

            for(int i=0; i< listaProcesorow.size(); i++) {
                Procesor pr = listaProcesorow.get(i);

                if(!pr.getListaZadan().czyPusta()) {
                    czyKontynuowac = true;
                }

                List<Zadanie> listaZastepcza = new ArrayList<>();
                listaZastepcza.clear();
                if(pr.getListaDoWykonania().size() > 0) {
                    for(int j=0; j<pr.getListaDoWykonania().size(); j++) {
                        Zadanie zad = pr.getListaDoWykonania().get(j);
                        if(zad.getCzasPojawienia() + zad.getIleObciaza() <= czas) {
                            pr.obciazenie -= zad.getIleObciaza();
                        } else {
                            listaZastepcza.add(zad);
                        }
                    }
                    pr.getListaDoWykonania().clear();
                    for(int k=0; k<listaZastepcza.size(); k++) {
                        pr.getListaDoWykonania().add(listaZastepcza.get(k));
                    }
                }
            }
            czas += 1;
            for(int i=0; i<listaProcesorow.size(); i++) {
                double dotychczasoweObciazenie = srednieObciazenia.get(i);
                srednieObciazenia.set(i, dotychczasoweObciazenie + listaProcesorow.get(i).obciazenie);
                srednieObciazenieCalosci += listaProcesorow.get(i).obciazenie;
            }

        }
        System.out.println("\nSTRATEGIA 3 - EMPATYCZNY PROCESOR");
        System.out.println("Ilość zapytań: " + licznikZapytan);
        System.out.println("Ilość migracji: " + licznikMigracji);
        System.out.println("Średnie obciążenie całego układu: " + srednieObciazenieCalosci / czas);
        System.out.println("Średnie obciążenia pojedyńczych węzłów:");
        for(int i=0; i<srednieObciazenia.size(); i++) {
            System.out.print(srednieObciazenia.get(i) / czas);
            System.out.println("; ");
        }
        System.out.println("Czas trwania symulacji: " + czas);



    }



    /*

    public static void start(List<Procesor> listaProcesorow, double p) {
        int licznikZapytan = 0;
        int licznikMigracji = 0;

        double srednieObciazenieCalosci = 0;
        List<Double> srednieObciazenia = new ArrayList<>();

        for(int i=0; i<listaProcesorow.size(); i++) {
            srednieObciazenia.add(0.0);
        }

        int czas = 1;
        boolean czyKontynuowac = true;

        while(czyKontynuowac) {
            Zadanie aktualneZadanie = null;
            Procesor aktualnyProcesor = null;
            int aktualnyIndeks = -1;
            for(int i=0; i<listaProcesorow.size(); i++) {
                aktualnyProcesor = listaProcesorow.get(i);
                aktualnyIndeks = i;
                if(!aktualnyProcesor.getListaZadan().czyPusta()) {
                    if (aktualnyProcesor.getListaZadan().peekZadanie().getCzasPojawienia() <= czas) {
                        aktualneZadanie = aktualnyProcesor.getListaZadan().pobierzZadanie();
                        break;
                    }
                }
            }
            if(aktualneZadanie != null) {
                aktualnyProcesor.dodajDoWykonania(aktualneZadanie);
                aktualnyProcesor.obciazenie += aktualneZadanie.ileObciaza;

                while(aktualnyProcesor.obciazenie <= p) {
                    int indeksMaksa = 0;
                    if(aktualnyIndeks == 0) {
                        indeksMaksa = 1;
                    }
                    for(int k=0; k< listaProcesorow.size(); k++) {
                        if(aktualnyIndeks != k) {
                            Procesor innyProcesor = listaProcesorow.get(k);
                            if(innyProcesor.obciazenie > listaProcesorow.get(indeksMaksa).obciazenie) {
                                licznikZapytan += 1;
                                indeksMaksa = k;
                            }
                        }
                    }
                    Procesor drugiProcesor = listaProcesorow.get(indeksMaksa);
                    if(drugiProcesor.getListaDoWykonania().size() > 0) {

                        licznikMigracji += 1;
                        Zadanie doPrzerzucenia = drugiProcesor.getListaDoWykonania().get(0);
                        drugiProcesor.getListaDoWykonania().remove(0);
                        drugiProcesor.obciazenie -= doPrzerzucenia.ileObciaza;
                        aktualnyProcesor.getListaDoWykonania().add(doPrzerzucenia);
                        aktualnyProcesor.obciazenie += doPrzerzucenia.ileObciaza;
                    } else {
                        break;
                    }
                }

            }

            czyKontynuowac = false;

            for(int i=0; i< listaProcesorow.size(); i++) {
                Procesor pr = listaProcesorow.get(i);

                if(!pr.getListaZadan().czyPusta()) {
                    czyKontynuowac = true;
                }

                List<Zadanie> listaZastepcza = new ArrayList<>();
                listaZastepcza.clear();
                if(pr.getListaDoWykonania().size() > 0) {
                    for(int j=0; j<pr.getListaDoWykonania().size(); j++) {
                        Zadanie zad = pr.getListaDoWykonania().get(j);
                        if(zad.getCzasPojawienia() + zad.getIleObciaza() <= czas) {
                            pr.obciazenie -= zad.getIleObciaza();
                        } else {
                            listaZastepcza.add(zad);
                        }
                    }
                    pr.getListaDoWykonania().clear();
                    for(int k=0; k<listaZastepcza.size(); k++) {
                        pr.getListaDoWykonania().add(listaZastepcza.get(k));
                    }
                }
            }
            czas += 1;
            for(int i=0; i<listaProcesorow.size(); i++) {
                double dotychczasoweObciazenie = srednieObciazenia.get(i);
                srednieObciazenia.set(i, dotychczasoweObciazenie + listaProcesorow.get(i).obciazenie);
                srednieObciazenieCalosci += listaProcesorow.get(i).obciazenie;
            }

        }
        System.out.println("\nSTRATEGIA 3 - EMPATYCZNY PROCESOR");
        System.out.println("Ilość zapytań: " + licznikZapytan);
        System.out.println("Ilość migracji: " + licznikMigracji);
        System.out.println("Średnie obciążenie całego układu: " + srednieObciazenieCalosci / czas);
        System.out.println("Średnie obciążenia pojedyńczych węzłów:");
        for(int i=0; i<srednieObciazenia.size(); i++) {
            System.out.print(srednieObciazenia.get(i) / czas);
            System.out.println("; ");
        }
        System.out.println("Czas trwania symulacji: " + czas);



    }
*/

}
