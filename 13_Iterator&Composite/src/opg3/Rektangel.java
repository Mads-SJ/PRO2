package opg3;

public class Rektangel extends Figur {
    private int l;
    private int b;

    public Rektangel(int l, int b) {
        this.l = l;
        this.b = b;
    }

    @Override
    public void tegn() {
        System.out.println("Rektangel");
    }

    @Override
    public double getAreal() {
        return l * b;
    }
}
