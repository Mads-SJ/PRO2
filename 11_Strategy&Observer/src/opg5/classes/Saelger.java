package opg5.classes;

import opg5.interfaces.Observer;
import opg5.interfaces.Subject;

import java.util.ArrayList;

public class Saelger implements Observer {
    private String navn;

    public Saelger(String navn) {
        this.navn = navn;
    }

    @Override
    public void update(Subject s) {
        if (s instanceof BogTitel bogTitel) {
            ArrayList<BogTitel> andreBoeger = new ArrayList<>();

            for (Kunde k : bogTitel.getKunder()) {
                for (BogTitel b : k.getBogtitler()) {
                    if (!andreBoeger.contains(b) && !b.getTitel().equals(bogTitel.getTitel())) {
                        andreBoeger.add(b);
                    }
                }
            }

            System.out.println("Andre kunder køber også: ");
            for (BogTitel b : andreBoeger) {
                System.out.println("- " + b.getTitel());
            }
        }
    }
}
