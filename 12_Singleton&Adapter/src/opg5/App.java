package opg5;

public class App {
    public static void main(String[] args) {
        ObservableBag bag = new ObservableBag();
        bag.add("a");
        bag.add("a");
        System.out.println(bag.getCount("a"));
        System.out.println(bag.getCount("q"));

        bag.remove("a");
        System.out.println(bag.getCount("a"));
        bag.remove("a");
        System.out.println(bag.getCount("a"));
        bag.add("a");

        for (String s : bag) {
            System.out.println(s);
        }
    }
}
