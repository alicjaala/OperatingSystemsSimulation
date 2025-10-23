package Symulacja4;

public class LRU {

    public static int start(Pamiec pamiec, CiagStron ciagStron) {
        int licznikBledow = 0;
        TablicaLicznikow tablicaLicznikow = new TablicaLicznikow(pamiec.getRozmiar());

        while (!ciagStron.czyPusty()) {
            int strona = ciagStron.pobierzStrone();
            int pozycja = pamiec.naKtorejPozycji(strona);

            if (pozycja == -1) {
                licznikBledow++;
                int pustaPozycja = pamiec.szukajPustejPozycji();

                if (pustaPozycja != -1) {
                    pamiec.dodajNaPozycje(pustaPozycja, strona);
                    tablicaLicznikow.wyzeruj(pustaPozycja);
                } else {
                    int pozycjaDoZamiany = tablicaLicznikow.szukajMaksa();
                    pamiec.dodajNaPozycje(pozycjaDoZamiany, strona);
                    tablicaLicznikow.wyzeruj(pozycjaDoZamiany);
                }
            } else {
                tablicaLicznikow.wyzeruj(pozycja);
            }

            tablicaLicznikow.zwiekszPozostalym(pozycja);
        }

        return licznikBledow;
    }
}
