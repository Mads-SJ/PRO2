package opg5.classes;

import opg5.interfaces.Observer;
import opg5.interfaces.Subject;

public class Indkoeber implements Observer {
    private String navn;

    public Indkoeber(String navn) {
        this.navn = navn;
    }

    @Override
    public void update(Subject s) {
        BogTitel bogTitel = (BogTitel) s;
        if (bogTitel.getAntal() < 6) {
            int antal = 10;
            System.out.println("Der skal købes " + antal + " eksemplarer af " + bogTitel.getTitel());
            bogTitel.indkoebTilLager(antal);
        }
    }
}
