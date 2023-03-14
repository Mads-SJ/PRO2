package opg1;

import java.io.Serializable;
import java.util.ArrayList;

public class MyTime implements Serializable {
    private int time;
    private ArrayList<String> times = new ArrayList<>();

    public MyTime() {
        time = 0;
    }

    public void increase() {
        time++;
    }

    public void reset() {
        time = 0;
    }

    public int getTime() {
        return time;
    }

    public void saveTime() {
        times.add("" + time);
    }

    @Override
    public String toString() {
        return "MyTime{" +
                "time=" + time +
                '}';
    }
}
