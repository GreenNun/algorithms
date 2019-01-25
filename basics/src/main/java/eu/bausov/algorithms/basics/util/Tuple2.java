package eu.bausov.algorithms.basics.util;

/**
 * Created by GreenNun on 2019-01-24.
 */
public class Tuple2<T, T1> {
    private T first;
    private T1 second;

    public Tuple2(T first, T1 second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T1 getSecond() {
        return second;
    }

    public void setSecond(T1 second) {
        this.second = second;
    }
}
