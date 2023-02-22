package biblo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BibliotekTest {
    Bibliotek bibliotek;
    LocalDate beregnetDato;
    LocalDate faktiskDato;

    @BeforeEach
    void setUp() {
        bibliotek = new Bibliotek();
        beregnetDato = LocalDate.of(2023, 2, 10);
    }

    @Test
    void beregnBøde1DagBarn() {
        faktiskDato = LocalDate.of(2023, 2, 11);
        assertEquals(10, bibliotek.beregnBøde(beregnetDato, faktiskDato, false));
    }

    @Test
    void beregnBøde7DagBarn() {
        faktiskDato = LocalDate.of(2023, 2, 17);
        assertEquals(10, bibliotek.beregnBøde(beregnetDato, faktiskDato, false));
    }

    @Test
    void beregnBøde8DagBarn() {
        faktiskDato = LocalDate.of(2023, 2, 18);
        assertEquals(30, bibliotek.beregnBøde(beregnetDato, faktiskDato, false));
    }

    @Test
    void beregnBøde14DagBarn() {
        faktiskDato = LocalDate.of(2023, 2, 24);
        assertEquals(30, bibliotek.beregnBøde(beregnetDato, faktiskDato, false));
    }

    @Test
    void beregnBøde15DagBarn() {
        faktiskDato = LocalDate.of(2023, 2, 25);
        assertEquals(45, bibliotek.beregnBøde(beregnetDato, faktiskDato, false));
    }

    @Test
    void beregnBøde1DagVoksen() {
        faktiskDato = LocalDate.of(2023, 2, 11);
        assertEquals(20, bibliotek.beregnBøde(beregnetDato, faktiskDato, true));
    }

    @Test
    void beregnBøde7DagVoksen() {
        faktiskDato = LocalDate.of(2023, 2, 17);
        assertEquals(20, bibliotek.beregnBøde(beregnetDato, faktiskDato, true));
    }

    @Test
    void beregnBøde8DagVoksen() {
        faktiskDato = LocalDate.of(2023, 2, 18);
        assertEquals(60, bibliotek.beregnBøde(beregnetDato, faktiskDato, true));
    }
}