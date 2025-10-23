package Symulaja5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Strategia1 {

    //procesor x pyta losowo wybrany procesor y o jego obciążenie
    //jeśli jest ono mniejsze od progu p, wysyła tam zadanie
    //próbuje to zrobić co najwyżej z razy
    //jeśli nie znajdzie nikogo, sam wykonuje zadanie

    public static void start(List<Procesor> listaProcesorow, double p, double z) {
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
                if (!aktualnyProcesor.getListaZadan().czyPusta()) {
                    if (aktualnyProcesor.getListaZadan().peekZadanie().getCzasPojawienia() <= czas) {
                        aktualneZadanie = aktualnyProcesor.getListaZadan().pobierzZadanie();
                    }

                }
            }

            /*
            Zadanie aktualneZadanie = null;
            Procesor aktualnyProcesor = null;
            for(int i=0; i<listaProcesorow.size(); i++) {
                aktualnyProcesor = listaProcesorow.get(i);
                if(!aktualnyProcesor.getListaZadan().czyPusta()) {
                    if (aktualnyProcesor.getListaZadan().peekZadanie().getCzasPojawienia() <= czas) {
                        aktualneZadanie = aktualnyProcesor.getListaZadan().pobierzZadanie();
                        break;
                    }
                }
            }*/
            if(aktualneZadanie != null) {
                for(int i=0; i<=z; i++) {
                    Random random = new Random();
                    int indeks = random.nextInt(listaProcesorow.size());
                    Procesor drugiProcesor = listaProcesorow.get(indeks);

                    licznikZapytan += 1;

                    if(drugiProcesor.czyMozeWykonac(aktualneZadanie, p)) {
                        drugiProcesor.dodajDoWykonania(aktualneZadanie);
                        drugiProcesor.obciazenie += aktualneZadanie.getIleObciaza();
                        licznikMigracji += 1;

                    } else {
                        aktualnyProcesor.dodajDoWykonania(aktualneZadanie);
                        aktualnyProcesor.obciazenie += aktualneZadanie.getIleObciaza();
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
        System.out.println("\nSTRATEGIA 1 - LENIWY PROCESOR");
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
