package com.practise1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {
        TestPractise testPractise = new TestPractise();
        //outputList(testPractise.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        outputList(testPractise.findSubstring("abababab", new String[]{"a", "b", "a"}));
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new ArrayList<Integer>();
        if (S == null || S.length() == 0) return ret;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> curr = new HashMap<String, Integer>();
        int count = 0;

        for (String str : L) {
            int v = map.containsKey(str) ? map.get(str) : 0;
            map.put(str, v + 1);
        }
        int len = L[0].length();
        for (int i = 0; i < len; i ++) {
            for (int j = i; j < S.length(); j += len) {
                if (j + (L.length - count) * len > S.length()) break;
                String tmp = S.substring(j, j + len);
                if (map.containsKey(tmp) && (!curr.containsKey(tmp) || curr.get(tmp) < map.get(tmp))) {
                    int v = curr.containsKey(tmp) ? curr.get(tmp) : 0;
                    curr.put(tmp, v + 1);
                    count ++;
                    if (count == L.length) {
                        int index = j + len - L.length * len;
                        j = index;
                        ret.add(index);
                        count = 0;
                        curr.clear();
                    }
                } else {
                    j -= count * len;
                    count = 0;
                    curr.clear();
                }
            }
        }
        return ret;
    }
}
