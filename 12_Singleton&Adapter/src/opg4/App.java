package opg4;

public class App {
    public static void main(String[] args) {
        Spiritus spiritus = new Spiritus(11, "Morgan");
        SpiritusToVareAdapter spiritusToVareAdapter = new SpiritusToVareAdapter(spiritus);

        System.out.println(spiritusToVareAdapter.beregnMoms());
    }
}
