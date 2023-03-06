package opg5.classes;

public class App {
    public static void main(String[] args) {
        Saelger saelger = new Saelger("Hansen");
        Indkoeber indkoeber = new Indkoeber("Jensen");
        BogTitel b1 = new BogTitel("Anders And", 6);
        BogTitel b2 = new BogTitel("Java", 8);
        Kunde k1 = new Kunde("Læsehest1");
        Kunde k2 = new Kunde("Læsehest2");
        Kunde k3 = new Kunde("Læsehest3");

        b1.addObserver(saelger);
        b1.addObserver(indkoeber);
        b2.addObserver(indkoeber);

        b2.etKoeb(k1);
        b2.etKoeb(k2);
        b2.etKoeb(k3);

        b1.etKoeb(k1);
        b1.etKoeb(k2);
        b1.etKoeb(k3);
    }
}
