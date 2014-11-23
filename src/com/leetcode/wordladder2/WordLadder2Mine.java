package com.leetcode.wordladder2;

import java.util.*;

/**
 * Created by titan-developer on 11/23/14.
 * https://oj.leetcode.com/problems/word-ladder-ii/
 */
public class WordLadder2Mine {

    public static void main(String[] strings) {
        WordLadder2Mine wordLadder = new WordLadder2Mine();

        String start = "hit";
        String end = "cog";

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("hot");
        hashSet.add("dot");
        hashSet.add("dog");
        hashSet.add("lot");
        hashSet.add("log");

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

        Queue<String> queue = new ArrayDeque<String>();
        queue.add(start);
        int currentLevel = 1; //the start word.
        int nextLevel = 0;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        HashSet<String> visted = new HashSet<String>();
        HashSet<String> vistingInLevel = new HashSet<String>();
        boolean isFound = false;

        while (!queue.isEmpty()) {
            String ladder = queue.poll();

            currentLevel --;

            for (int i = 0; i < ladder.length(); i ++) {
                StringBuffer buffer = new StringBuffer(ladder);
                for (char c = 'a'; c <= 'z'; c ++) {
                    buffer.setCharAt(i, c);

                    String newWord = buffer.toString();

                    if (visted.contains(newWord)) {
                        continue;
                    }

                    if (newWord.equals(end)) {
                        isFound = true;
                    } else if (dict.contains(newWord)) {
                        nextLevel ++;
                    } else {
                        continue;
                    }

                    vistingInLevel.add(newWord);
                    queue.add(newWord);

                    if (map.containsKey(newWord)) {
                        List<String> list = map.get(newWord);
                        list.add(ladder);
                        map.put(newWord, list);
                    } else {
                        List<String> list = new ArrayList<String>();
                        list.add(ladder);
                        map.put(newWord, list);
                    }
                }
            }

            if (currentLevel == 0) {
                if (isFound) {
                    break;
                }

                visted.addAll(vistingInLevel);
                vistingInLevel.clear();

                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }

        visted.clear();
        vistingInLevel.clear();

        List<String> current = new ArrayList<String>();

        backtrace(map, start, end, current, result);

        return result;
    }

    private void backtrace(HashMap<String, List<String>> map, String start, String ladder, List<String> current, List<List<String>> result) {
        if (ladder.equals(start)) {
            current.add(0, ladder);
            result.add(new ArrayList<String>(current));
            current.remove(0);
            return;
        }

        current.add(0, ladder);
        List<String> list = map.get(ladder);
        for (String str : list) {
            backtrace(map, start, str, current, result);
        }
        current.remove(0);
    }
}
