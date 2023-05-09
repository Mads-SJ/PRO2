package opg1;

import java.util.HashSet;
import java.util.Set;

public class BilApp {
    public static void main(String[] args) {
        Set<Bil> biler = new HashSet<>();
        Bil b1 = new Bil("AB12345", "Ford", "Focus", "Rød");
        Bil b2 = new Bil("AB12345", "Ford", "Focus", "Rød");
        Bil b3 = new Bil("CD67891", "Mercedes", "A", "Sølv");
        biler.add(b1);
        biler.add(b2);
        biler.add(b3);

        System.out.println(biler.size());
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
    }
}
