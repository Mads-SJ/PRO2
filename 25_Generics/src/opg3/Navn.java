package opg3;

public class Navn implements Comparable<Navn> {
    private String fornavn;
    private String efternavn;

    public Navn(String fornavn, String efternavn) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    @Override
    public String toString() {
        return fornavn + " " + efternavn;
    }

    @Override
    public int compareTo(Navn o) {
        int comp = fornavn.compareTo(o.fornavn);
        if (comp == 0) {
            comp = efternavn.compareTo(o.efternavn);
        }
        return comp;
    }
}
