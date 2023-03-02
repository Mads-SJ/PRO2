package opg3;

import opg3.strategy.SpiritusPriceStrategy;

public class Spiritus extends Vare {
    private double alcoholPercent;

    public Spiritus(double priceExclVAT, String name, String description, double alcoholPercent) {
        super(priceExclVAT, name, description, 1.8);
        this.alcoholPercent = alcoholPercent;
        setPriceStrategy(new SpiritusPriceStrategy());
    }
}
