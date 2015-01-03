package com.java.language.util.generic;

/**
 * Created by titan-developer on 1/2/15.
 */
public class TestRawType {

    public static void main(String[] strings) {
        TestRawType testRawType = new TestRawType();
        testRawType.test1();
        testRawType.test2();
        testRawType.test3();
        testRawType.testGenericMethod("a");
    }

    void test1() {
        Box<String> stringBox = new Box<String>();
        Box rawBox = stringBox;               // OK
        System.out.println(rawBox);
    }

    void test2() {
        Box rawBox = new Box();           // rawBox is a raw type of Box<T>
        Box<Integer> intBox = rawBox;     // warning: unchecked conversion
        System.out.println(rawBox);
        System.out.println(intBox);
    }

    void test3() {
        Box<Integer> intBox = new Box<Integer>();
        Box rawBox = intBox;
        rawBox.set("abc");  // warning: unchecked invocation to set(T)
        System.out.println(intBox.get());
    }

    void warningDemo(){
        Box<Integer> bi;
        bi = createBox();
    }

    Box createBox(){
        return new Box();
    }

    <T> void testGenericMethod(T a) {
        System.out.println(a.getClass());
    }
}
