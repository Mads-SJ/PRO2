package opg5.classes;

import opg5.interfaces.Observer;
import opg5.interfaces.Subject;

import java.util.ArrayList;

public class BogTitel implements Subject {
    private String titel;
    private int antal;
    private ArrayList<Observer> observers;
    private ArrayList<Kunde> kunder;

    public BogTitel(String titel, int antal) {
        this.titel = titel;
        this.antal = antal;
        observers = new ArrayList<>();
        kunder = new ArrayList<>();
    }

    public String getTitel() {
        return titel;
    }

    public int getAntal() {
        return antal;
    }

    public void indkoebTilLager(int antal) {
        this.antal += antal;
    }

    public void etKoeb(Kunde kunde) {
        antal--;
        addKunde(kunde);
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public void addKunde(Kunde kunde) {
        if (!kunder.contains(kunde)) {
            kunder.add(kunde);
            kunde.addBogtitel(this);
        }
    }
}
