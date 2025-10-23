package Symulacja3;

public class ALRU {

    public static int start(Pamiec pamiec, CiagStron ciagStron) {
        int licznikBledow = 0;
        //int rozmiarPamieci = pamiec.getRozmiar();

        while (!ciagStron.czyPusty()) {
            int strona = ciagStron.pobierzStrone();
            int pozycja = pamiec.naKtorejPozycji(strona);

            if (pozycja == -1) {
                licznikBledow++;
                int pustaPozycja = pamiec.szukajPustejPozycji();

                if (pustaPozycja != -1) {
                    pamiec.dodajNaPozycje(pustaPozycja, strona);
                } else {
                    boolean znaleziono = false;
                    while (!znaleziono) {
                        int pierwszy = 0;
                        if (pamiec.getBitOdwołania(pierwszy)) {
                            pamiec.ustawBitOdwołania(pierwszy, false);
                            pamiec.przesunNaKoniec(pierwszy);
                        } else {
                            pamiec.dodajNaPozycje(pierwszy, strona);
                            znaleziono = true;
                        }
                    }
                }
            } else {
                pamiec.ustawBitOdwołania(pozycja, true);
            }
        }

        return licznikBledow;
    }
}
