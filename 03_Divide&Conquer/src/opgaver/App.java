package opgaver;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(0);

        System.out.println(sum(list));
        System.out.println(numberOfZeros(list));
    }

    public static int  sum(ArrayList<Integer> list) {
        return sum(list, 0, list.size() - 1);
    }

    private static int sum(ArrayList<Integer> list, int l, int h) {
        if (l == h) {
            return list.get(l);
        } else {
            int m = (l + h) / 2;
            int sum1 = sum(list, l, m);
            int sum2 = sum(list, m + 1, h);
            return sum1 + sum2;
        }
    }

    public static int numberOfZeros(ArrayList<Integer> list) {
        return numberOfZeros(list, 0, list.size() - 1);
    }

    private static int numberOfZeros(ArrayList<Integer> list, int l, int h) {
        if (l == h) {
            return list.get(l) == 0 ? 1 : 0;
        } else {
            int m = (l + h) / 2;
            int n1 = numberOfZeros(list, l, m);
            int n2 = numberOfZeros(list, m + 1, h);
            return n1 + n2;
        }
    }
}