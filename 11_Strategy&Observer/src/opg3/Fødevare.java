package opg3;

import opg3.strategy.FødevarePriceStrategy;

public class Fødevare extends Vare {
    private int holdbarhedsperiode;

    public Fødevare(double priceExclVAT, String name, String description, int holdbarhedsperiode) {
        super(priceExclVAT, name, description, 1.05);
        this.holdbarhedsperiode = holdbarhedsperiode;
        setPriceStrategy(new FødevarePriceStrategy());
    }
}
