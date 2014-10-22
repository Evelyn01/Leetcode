package com.leetcode.minimumwindow;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by titan-developer on 10/21/14.
 */
public class MinimumWindowSubstring {

    public static void main(String[] strings) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";

//        String s = "aa";
//        String t = "aa";

        String s = "ADOBECODEBANC";
        String t = "AABC";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        String subStr = "";
        if (s == null || t == null)
            return subStr;

        HashMap<Character, PointerList> hashMap = new HashMap<Character, PointerList>();
        LinkedList<Pointer> linkedList = new LinkedList<Pointer>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.get(c).count ++;
            } else {
                hashMap.put(t.charAt(i), new PointerList());
            }
        }

        int min = Integer.MAX_VALUE;
        int left = -1, right = -1;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (hashMap.containsKey(c)) {
                PointerList pointerlist = hashMap.get(c);
                if (pointerlist.list.size() < pointerlist.count) {
                    Pointer pointer = new Pointer();
                    pointer.character = c;
                    pointer.index = j;
                    pointerlist.list.add(pointer);
                    linkedList.add(pointer);
                } else {
                    Pointer pointer = pointerlist.list.get(0);
                    pointer.index = j;
                    linkedList.remove(pointer);
                    linkedList.add(pointer);
                    pointerlist.list.add(pointer);
                }

                if (linkedList.size() == t.length()) {

                    int l = linkedList.peekFirst().index;
                    int r = linkedList.peekLast().index;
                    if (r - l < min) {
                        min = r - l;
                        left = l;
                        right = r;
                    }
                }
            }
        }

        if (left >= 0 && right >= 0) {
            subStr = s.substring(left, right + 1);
        }

        return subStr;
    }

    class PointerList {
        ArrayList<Pointer> list = new ArrayList<Pointer>();
        int count;

        PointerList() {
            count = 1;
        }
    }

    class Pointer {
        Character character;
        int index;
    }
}
