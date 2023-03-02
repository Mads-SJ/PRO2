package opg3.strategy;

public class ElArtikelPriceStrategy implements PriceStrategy {
    @Override
    public double getSalesPrice(double priceExclVAT, double VAT) {
        double priceInclVAT = priceExclVAT * VAT;

        if (priceInclVAT < 3) {
            priceInclVAT = 3;
        }
        return priceInclVAT;
    }
}
