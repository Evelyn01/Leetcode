package com.java.language.util.generic;

/**
 * Created by titan-developer on 1/2/15.
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}