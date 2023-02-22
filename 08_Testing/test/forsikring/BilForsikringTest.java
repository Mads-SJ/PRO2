package forsikring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilForsikringTest {
    BilForsikring bilForsikring;
    int alder;
    boolean isKvinde;
    int skadeFrieaar;

    @BeforeEach
    void setUp() {
        bilForsikring = new BilForsikring();
        bilForsikring.setGrundpaemie(1000);
        alder = 30;
        isKvinde = false;
        skadeFrieaar = 0;
    }

    @Test
    void beregnPraemieTC1SkadefrieÅr3() {
        skadeFrieaar = 3;
       assertEquals(850,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC2SkadefrieÅr5() {
        skadeFrieaar = 5;
        assertEquals(850,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC3SkadefrieÅr6() {
        skadeFrieaar = 6;
        assertEquals(750,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC4SkadefrieÅr8() {
        skadeFrieaar = 8;
        assertEquals(750,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC5SkadefrieÅr10() {
        skadeFrieaar = 10;
        assertEquals(650,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC6Kvinde() {
        isKvinde = true;
        assertEquals(950,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC7Alder24() {
        alder = 24;
        assertEquals(1250,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC8Alder25() {
        alder = 25;
        assertEquals(1000,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC9Alder18() {
        alder = 18;
        assertEquals(1250,bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar));
    }

    @Test
    void beregnPraemieTC10Grundpraemie0() {
        assertThrows(RuntimeException.class, () -> bilForsikring.setGrundpaemie(0));
    }

    @Test
    void beregnPraemieTC11Alder17() {
        alder = 17;
        assertThrows(RuntimeException.class, () -> {
            bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar);
        });
    }

    @Test
    void beregnPraemieTC12Alder18SkadesfrieÅr3() {
        alder = 18;
        skadeFrieaar = 3;
        assertThrows(RuntimeException.class, () -> {
            bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar);
        });
    }

    @Test
    void beregnPraemieTC13SkadefrieÅrMinus1() {
        skadeFrieaar = -1;
        assertThrows(RuntimeException.class, () -> {
            bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaar);
        });
    }
}