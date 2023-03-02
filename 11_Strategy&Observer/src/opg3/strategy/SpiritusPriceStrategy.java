package opg3.strategy;

public class SpiritusPriceStrategy implements PriceStrategy {
    @Override
    public double getSalesPrice(double priceExclVAT, double VAT) {
        if (priceExclVAT > 90) {
            VAT = 2.2;
        }
        return priceExclVAT * VAT;
    }
}
