package opg3;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array = {5, 10, 5, 6, 4, 9, 8};
        System.out.println(Arrays.toString(prefixAverage(array)));

    }

    public static double[] prefixAverage(int[] array) {
        double[] prefixAverage = new double[array.length];
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            prefixAverage[i] = sum / (i + 1);
        }
        return prefixAverage;
    }
}
