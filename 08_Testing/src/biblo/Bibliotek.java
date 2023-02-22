package biblo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bibliotek {
    /*
     * Returnerer størrelsen af bøden beregnet i henhold til skemaet
     * ovenfor
     * krav: beregnetDato og faktiskDato indeholder lovlige datoer og
     *       beregnetDato < faktiskDato
     *      (beregnetDato er forventet afleveringsdato og
     *       faktiskDato er den dag bogen blev afleveret; voksen er
     *       sand, hvis det er en voksen og falsk ellers)
     */
    public int beregnBøde(LocalDate beregnetDato,
                          LocalDate faktiskDato, boolean voksen) {
        long days = ChronoUnit.DAYS.between(beregnetDato, faktiskDato);
        int bøde = 0;
        if (1 <= days && days <= 7) {
            bøde = 10;
        } else if (8 <= days && days <= 14) {
            bøde = 30;
        } else if (days >= 15) {
            bøde = 45;
        }

        if (voksen) {
            bøde *= 2;
        }
        return bøde;
    }
}
