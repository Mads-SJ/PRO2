package opg2;

public class AnvendCounter {
    public static void main(String[] args) {
        Counter c1 = Counter.getInstance();
        Counter c2 = Counter.getInstance();

        c1.count();
        System.out.println(c1.getValue());
        System.out.println(c2.getValue());
    }
}
