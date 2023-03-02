package opg4;

import java.util.Comparator;

public class Kunde implements Comparable<Kunde> {
    private String navn;
    private int nummer;
    private Comparator<Kunde> comparator;

    public Kunde(String navn, int nummer, Comparator<Kunde> comparator) {
        this.navn = navn;
        this.nummer = nummer;
        this.comparator = comparator;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "navn='" + navn + '\'' +
                ", nummer='" + nummer + '\'' +
                '}';
    }

    @Override
    public int compareTo(Kunde o) {
        return comparator.compare(this, o);
    }
}
