package opg5.classes;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    private ArrayList<BogTitel> bogtitler;

    public Kunde(String navn) {
        this.navn = navn;
        bogtitler = new ArrayList<>();
    }

    public ArrayList<BogTitel> getBogtitler() {
        return new ArrayList<>(bogtitler);
    }

    public void addBogtitel(BogTitel bogTitel) {
        if (!bogtitler.contains(bogTitel)) {
            bogtitler.add(bogTitel);
            bogTitel.addKunde(this);
        }
    }
}
