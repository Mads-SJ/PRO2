package opg3.strategy;

public class FødevarePriceStrategy implements PriceStrategy {
    @Override
    public double getSalesPrice(double priceExclVAT, double VAT) {
        return priceExclVAT * VAT;
    }
}
