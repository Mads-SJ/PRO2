package opg3.strategy;

public class FĂ¸devarePriceStrategy implements PriceStrategy {
    @Override
    public double getSalesPrice(double priceExclVAT, double VAT) {
        return priceExclVAT * VAT;
    }
}
