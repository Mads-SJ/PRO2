package opg5;

import java.util.*;

public class ObservableBag implements Bag, Iterable<String> {
    private Set<Observer> observers = new HashSet<>();

    private final Map<String, Integer> map = new HashMap<>();

    @Override
    public void add(String s) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }

        notifyObservers(s);
    }

    @Override
    public void remove(String s) {
        if (map.containsKey(s)) {
            if (map.get(s) > 1) {
                map.put(s, map.get(s) - 1);
            } else {
                map.remove(s);
            }
        }
        notifyObservers(s);
    }

    @Override
    public int getCount(String s) {
        return map.getOrDefault(s, 0);
    }

    public void notifyObservers(String s) {
        for (Observer o : observers) {
            o.update(s, getCount(s));
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }
}
