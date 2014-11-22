package com.leetcode.wordladder2;

import java.util.*;

/**
 * Created by bod on 11/21/2014.
 */
public class WordLadder2 {

    public static void main(String[] strings) {
        WordLadder2 wordLadder = new WordLadder2();

        String start = "hit";
        String end = "cog";

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("hot");
        hashSet.add("dot");
        hashSet.add("dog");
        hashSet.add("lot");
        hashSet.add("log");
        hashSet.add("cog");

        List<List<String>> result = wordLadder.findLadders(start, end, hashSet);

        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + ", ");
            }
            System.out.println();
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();

        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> distances = new LinkedList<Integer>();
        queue.add(start);
        distances.add(1);
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        map.put(start, new HashSet<String>());
        int miniDis = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            String str = queue.poll();
            int currentDis = distances.poll();

            if (str.equals(end)) {
                if (currentDis < miniDis) {
                    miniDis = currentDis;
                }
                continue;
            }

            if (currentDis >= miniDis) {
                break;
            }

            for (int i = 0; i < str.length(); i ++) {
                char[] chars = str.toCharArray();

                for (int j = 0; j < 26; j ++) {
                    char c = (char)('a' + j);
                    if (c != chars[i]) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (dict.contains(newStr)) {
                            queue.add(newStr);
                            distances.add(currentDis + 1);

                            if (map.containsKey(newStr)) {
                                HashSet<String> list = map.get(newStr);
                                list.add(str);
                            } else {
                                HashSet<String> list = new HashSet<String>();
                                list.add(str);
                                map.put(newStr, list);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
