package opg4;

public class App {
    public static void main(String[] args) {
        Kunde k1 = new Kunde("Jens", 1, new NavnComparator());
        Kunde k2 = new Kunde("Frederik", 2, new NummerComparator());

        System.out.println(k1.compareTo(k2));
        System.out.println(k2.compareTo(k1));
    }
}
