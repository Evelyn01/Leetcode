package com.leetcode.findconcatenation;

import java.util.*;

/**
 * Created by titan-developer on 10/23/14.
 */
public class FindConcatenation {

    public static void main(String[] strings) {

//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar"};
//
        String s = "aaa";
        String[] words = {"a", "a"};

        FindConcatenation concatenation = new FindConcatenation();
        System.out.println(concatenation.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<Integer>();

        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return results;
        }

        int wordsListSize = words.length;
        int wordLength = words[0].length();

        if (s.length() < wordLength) {
            return results;
        }

        HashMap<String, CountNode> hashMap = new HashMap<String, CountNode>();
        for (String word : words) {
            if (hashMap.containsKey(word)) {
                CountNode node = hashMap.get(word);
                node.target ++;
            } else {
                CountNode node = new CountNode();
                hashMap.put(word, node);
            }
        }

        int lastIndex = -1;
        int matchCount = 0;
        for (int i = wordLength ; i < s.length() ; i ++) {
            String tmp = s.substring(i - wordLength, i);
            if (hashMap.containsKey(tmp)) {
                CountNode node = hashMap.get(tmp);
                node.count ++;

                if (node.count > node.target) {
                    resetCount(hashMap);
                    i = lastIndex + 1;
                    lastIndex = -1;
                    matchCount = 0;
                } else {
                    if (node.count == node.target) {
                        matchCount += node.count;
                        if (matchCount == wordsListSize) {
                            results.add(lastIndex);
                            lastIndex = -1;
                            i = i + wordLength - 1;
                            resetCount(hashMap);
                            matchCount = 0;
                            continue;
                        }
                    }
                    if (lastIndex < 0) {
                        lastIndex = i - wordLength;
                    }

                    i = i + wordLength - 1;
                }
            } else {
                if (lastIndex >= 0) {
                    resetCount(hashMap);
                    i = lastIndex;
                    lastIndex = -1;
                    matchCount = 0;
                }
            }
        }

        return results;
    }

    protected void resetCount(HashMap<String, CountNode> hashMap) {
        Iterator<CountNode> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            CountNode node = iterator.next();
            node.count = 0;
        }
    }

    class CountNode {
        int target;
        int count;

        public CountNode() {
            target = 1;
            count = 0;
        }
    }
}
