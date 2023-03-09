package opg3;

public class App {
    public static void main(String[] args) {
        SammensatFigur root = new SammensatFigur();
        SammensatFigur layer1 = new SammensatFigur();
        root.addFigur(layer1);
        layer1.addFigur(new Trekant(10, 20));
        layer1.addFigur(new Rektangel(30, 50));
        SammensatFigur layer2 = new SammensatFigur();
        layer1.addFigur(layer2);
        layer2.addFigur(new Trekant(40, 60));

        root.tegn();
        System.out.println(root.getAreal());
        System.out.println(layer2.getAreal());
    }
}
