package com.java.language.serialization;

import java.io.*;

/**
 * Created by titan-developer on 12/12/14.
 */
public class TestSingleton implements Serializable {

    private static final TestSingleton INSTANCE = new TestSingleton();

    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
        oos.writeObject(INSTANCE);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
        TestSingleton test = (TestSingleton) ois.readObject();
        ois.close();
        System.out.println(test == INSTANCE);
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
