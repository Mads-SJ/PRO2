package opg3;

import opg3.strategy.ElArtikelPriceStrategy;

public class ElArtikel extends Vare {
    private double avgEnergyConsumptionHr;

    public ElArtikel(double priceExclVAT, String name, String description, double avgEnergyConsumptionHr) {
        super(priceExclVAT, name, description, 1.3);
        this.avgEnergyConsumptionHr = avgEnergyConsumptionHr;
        setPriceStrategy(new ElArtikelPriceStrategy());
    }
}
