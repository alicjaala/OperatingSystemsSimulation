package Symulaja5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Strategia2 {

    //procesor x najpierw chce wziąć na siebie
    //jeśli nie ma już miejsca, szuka kogoś innego
    //jesli nikt inny też nie może, to pętla od nowa

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
                boolean czyKtosPrzyjal = false;

                while (!czyKtosPrzyjal) {

                    //System.out.println("aktulne zadanie: " + aktualneZadanie.getCzasPojawienia());

                    if (aktualnyProcesor.czyMozeWykonac(aktualneZadanie, p)) {
                        aktualnyProcesor.dodajDoWykonania(aktualneZadanie);
                        aktualnyProcesor.obciazenie += aktualneZadanie.ileObciaza;
                        czyKtosPrzyjal = true;
                    } else {

                        Random ran = new Random();
                        int innyIndeks = ran.nextInt(listaProcesorow.size());
                        Procesor drugiProcesor = listaProcesorow.get(innyIndeks);
                        licznikZapytan += 1;
                        if(drugiProcesor.czyMozeWykonac(aktualneZadanie, p)) {
                            licznikMigracji += 1;
                            drugiProcesor.dodajDoWykonania(aktualneZadanie);
                            drugiProcesor.obciazenie += aktualneZadanie.ileObciaza;
                            czyKtosPrzyjal = true;
                        }

/*
                        for (int i = 0; i <= listaProcesorow.size(); i++) {
                            if (i != aktualnyIndeks) {
                                if (i != aktualnyIndeks) {
                                    Procesor drugiProcesor = listaProcesorow.get(i);
                                    licznikZapytan += 1;
                                    if (drugiProcesor.czyMozeWykonac(aktualneZadanie, p)) {
                                        licznikMigracji += 1;
                                        drugiProcesor.dodajDoWykonania(aktualneZadanie);
                                        drugiProcesor.obciazenie += aktualneZadanie.ileObciaza;
                                        czyKtosPrzyjal = true;
                                        break;
                                }
                            }
                        }
                    } */
                    }


                    for(int i=0; i< listaProcesorow.size(); i++) {
                        Procesor pr = listaProcesorow.get(i);


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
            }

            czyKontynuowac = false;

            for(int i=0; i< listaProcesorow.size(); i++) {
                Procesor pr = listaProcesorow.get(i);

                if (!pr.getListaZadan().czyPusta()) {
                    czyKontynuowac = true;
                }
            }

            czas += 1;
            for(int i=0; i<listaProcesorow.size(); i++) {
                double dotychczasoweObciazenie = srednieObciazenia.get(i);
                srednieObciazenia.set(i, dotychczasoweObciazenie + listaProcesorow.get(i).obciazenie);
                srednieObciazenieCalosci += listaProcesorow.get(i).obciazenie;
            }

        }
        System.out.println("\nSTRATEGIA 2 - AMBITNY PROCESOR");
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

}
