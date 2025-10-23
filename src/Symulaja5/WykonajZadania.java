package Symulaja5;

import java.util.List;

public class WykonajZadania {

    public static void Wykonywanie(List<Procesor> listaProcesorow, int czas) {

        for(int i=0; i < listaProcesorow.size(); i++) {
            Procesor aktualnyProcesor = listaProcesorow.get(i);

            List<Zadanie> aktualnaLista = aktualnyProcesor.getListaDoWykonania();

            if(aktualnaLista.size() > 0) {
                for(int j=0; j < aktualnaLista.size(); j++) {
                    Zadanie aktualneZadanie = aktualnaLista.get(j);

                    if(aktualneZadanie.getCzasPojawienia() + aktualneZadanie.getDlugosc() <= czas) {
                        aktualnaLista.remove(j);
                    } else {
                        break;
                    }
                }
            }

        }
    }
}
