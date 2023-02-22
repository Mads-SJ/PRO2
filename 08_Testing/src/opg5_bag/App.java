package opg5_bag;

public class App {
    public static void main(String[] args) {
        Bag bag = new BagImpl();
        bag.add("a");
        bag.add("a");
        System.out.println(bag.getCount("a"));
        System.out.println(bag.getCount("q"));

        bag.remove("a");
        System.out.println(bag.getCount("a"));
        bag.remove("a");
        System.out.println(bag.getCount("a"));
    }
}
