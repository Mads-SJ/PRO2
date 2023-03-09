package opg3;

public class Trekant extends Figur {
    private int h;
    private int g;

    public Trekant(int h, int g) {
        this.h = h;
        this.g = g;
    }

    @Override
    public void tegn() {
        System.out.println("Trekant");
    }

    @Override
    public double getAreal() {
        return h * g;
    }
}
