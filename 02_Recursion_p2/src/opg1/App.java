package opg1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(10);
        list.add(17);
        list.add(4);
        list.add(8);
        list.add(45);
        list.add(29);

        System.out.println(ligeTal(list));
        System.out.println(ligeTal1(list));

        System.out.println(palindrom("radar"));
        System.out.println(palindrom("abba"));
        System.out.println(palindrom("mads"));
        System.out.println(palindrom("madse"));

        int[] array = {1, 2, 3, 5, 6, 7};
        System.out.println(binaryRecursionFind(array, 2));
        System.out.println(binaryRecursionFind(array, 4));

        System.out.println();
        System.out.println(binomial(7, 4));

    }

    public static int ligeTal(ArrayList<Integer> list) {
        ArrayList<Integer> copy = new ArrayList<>(list);
        if (copy.size() == 0) {
            return 0;
        } else {
            int n = copy.get(0);
            copy.remove(0);
            if (n % 2 == 0) {
                return ligeTal(copy) + 1;
            } else {
                return ligeTal(copy);
            }
        }
    }

    public static int ligeTal1(ArrayList<Integer> list) {
        return ligeTal1(list, 0);
    }

    private static int ligeTal1(ArrayList<Integer> list, int i) {
        if (i == list.size()) {
            return 0;
        } else {
            int n = list.get(i);
            if (n % 2 == 0) {
                return ligeTal1(list, i + 1) + 1;
            } else {
                return ligeTal1(list, i + 1);
            }
        }
    }

    public static boolean palindrom(String s) {
        return palindrom(s, 0);
    }

    private static boolean palindrom(String s, int i) {
       if (i >= s.length() - i) {
          return true;
       } else {
           if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
               return palindrom(s, i + 1);
           } else {
               return false;
           }
       }
    }

    public static boolean binaryRecursionFind(int[] list, int n) {
        return binaryRecursionFind(list, n, 0, list.length - 1);
    }

    private static boolean binaryRecursionFind(int[] list, int n, int left, int right) {
        if (left > right) {
            return false;
        }
        int middle = (left + right) / 2;
        int k = list[middle];
        if (k == n) {
            return true;
        } else if (k > n) {
            return binaryRecursionFind(list, n, left, middle - 1);
        } else {
            return binaryRecursionFind(list, n, middle + 1, right);
        }
    }

    public static int binomial(int n, int m) {
       if (m == 0 || m == n) {
           return 1;
       } else {
           return binomial(n - 1, m) + binomial(n - 1, m - 1);
       }
    }
}
