package opg3;

import java.util.ArrayList;

public class SammensatFigur extends Figur {
    private ArrayList<Figur> figurer = new ArrayList<>();

    @Override
    public void addFigur(Figur figur) {
        if (!figurer.contains(figur)) {
            figurer.add(figur);
        }
    }

    @Override
    public void removeFigur(Figur figur) {
        if (figurer.contains(figur)) {
            figurer.remove(figur);
        }
    }

    @Override
    public Figur getChild(int i) {
        if (i>=0 && i < figurer.size()) {
            return figurer.get(i);
        }
        else return null;
    }

    @Override
    public void tegn() {
        for (Figur f : figurer) {
            f.tegn();
        }
    }

    @Override
    public double getAreal() {
        double areal = 0;
        for (Figur f : figurer) {
            areal += f.getAreal();
        }
        return areal;
    }
}
