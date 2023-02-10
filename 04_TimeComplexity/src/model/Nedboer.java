package model;

public class Nedboer {
    private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
        19, 21, 32, 24, 13 };
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */
    
    public int bedsteTreFerieUger() {
        int mindstNedboer = Integer.MAX_VALUE;
        int bedsteUgeNr = -1;
        for (int i = 0; i < nedboerPrUge.length - 3; i++) {
            int nedboer = nedboerPrUge[i] + nedboerPrUge[i + 1] + nedboerPrUge[i + 2];
            if (nedboer < mindstNedboer) {
                mindstNedboer = nedboer;
                bedsteUgeNr = i + 1;
            }
        }
        return bedsteUgeNr;
    }
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */
    
    public int bedsteFerieUgerStart(int antal) {
        int mindstNedboer = Integer.MAX_VALUE;
        int bedsteUgeNr = -1;
        for (int i = 0; i < nedboerPrUge.length - antal; i++) {
            int nedboer = 0;
            for (int j = 0; j < antal; j++) {
                nedboer += nedboerPrUge[i + j];
            }
            if (nedboer < mindstNedboer) {
                mindstNedboer = nedboer;
                bedsteUgeNr = i + 1;
            }
        }
        return bedsteUgeNr;
    }
    
    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public int ensNedboer() {
        int flestEnsNedboer = 0;
        int antalEnsIStreg = 0;
        int ugeNr = -1;
        int nedboer = -1;
        for (int i = 0; i < nedboerPrUge.length; i++) {
            antalEnsIStreg++;
            if (nedboer != nedboerPrUge[i]) {
                if (flestEnsNedboer < antalEnsIStreg) {
                    flestEnsNedboer = antalEnsIStreg;
                    ugeNr = i;
                }
                antalEnsIStreg = 0;
                nedboer = nedboerPrUge[i];
            }
        }
        return ugeNr;
    }
}
