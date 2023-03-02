package opg3;

import opg3.strategy.PriceStrategy;

public abstract class Vare {
    private double priceExclVAT;
    private String name;
    private String description;
    private double VAT;
    private PriceStrategy priceStrategy;

    public Vare(double priceExclVAT, String name, String description, double VAT) {
        this.priceExclVAT = priceExclVAT;
        this.name = name;
        this.description = description;
        this.VAT = VAT;
    }

    public double getPriceExclVAT() {
        return priceExclVAT;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getVAT() {
        return VAT;
    }

    public double getSalesPrice() {
        return priceStrategy.getSalesPrice(priceExclVAT, VAT);
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    @Override
    public String toString() {
        return "Vare{" +
                "priceExclVAT=" + priceExclVAT +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", VAT=" + VAT +
                '}';
    }
}
