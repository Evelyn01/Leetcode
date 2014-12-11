package com.java.language;

import java.io.Serializable;

/**
 * Created by titan-developer on 12/11/14.
 */
public class Singleton implements Serializable {

    private static Singleton INSTANCE = new Singleton();

    private Singleton() {

    }


}
