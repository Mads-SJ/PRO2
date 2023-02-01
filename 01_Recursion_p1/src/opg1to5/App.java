package opg1to5;

public class App {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(2));

        System.out.println(power(2, 3));
        System.out.println(power2(2, 3));

        System.out.println(reverse("JENS"));

        System.out.println(sfd(10, 5));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int power(int n, int p) {
        if (p == 0) {
            return 1;
        } else {
            return n * power(n, p - 1);
        }
    }

    public static int power2(int n, int p) {
        if (p == 0) {
            return 1;
        } else if (p % 2 != 0) {
            return power2(n, p - 1) * n;
        } else {
            return power2(n * n, p / 2);
        }
    }

    public static int product(int a, int b) {
        if (a == 0) {
            return 0;
        } else {
            return product(a - 1, b) + b;
        }
    }

    public static int productRus(int a, int b) {
        if (a == 0) {
            return 0;
        } else if (a % 2 == 1) {
            return productRus(a - 1, b) + b;
        } else {
            return productRus(a / 2, 2 * b);
        }
    }

    /*
    reverse(s) = s, s = 1
    reverse(s) = reverse(s - 1) + c
    reverse(JENS) = reverse(ENS) + J = reverse(NS) + E + J = reverse(S) + N + E + J = SNEJ
     */
    public static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        } else {
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }

    public static int sfd(int a, int b) {
        if (b <= a && a % b == 0) {
            return b;
        } else if (a < b) {
            return sfd(b, a);
        } else {
            return sfd(b, a % b);
        }
    }
}
