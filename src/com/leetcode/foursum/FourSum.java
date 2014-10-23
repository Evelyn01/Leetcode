package com.leetcode.foursum;

import java.util.*;

/**
 * Created by titan-developer on 10/23/14.
 * https://oj.leetcode.com/problems/4sum/
 * <p/>
 * Solution:
 * http://www.cnblogs.com/tenosdoit/p/3649607.html
 */
public class FourSum {

    public static void main(String[] strings) {
        int[] a = {1, 0, -1, 0, -2, 2};

        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(a, 0));
    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        int n = num.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashMap<Integer, List<int[]>> pairs = new HashMap<Integer, List<int[]>>(n * n);
        Arrays.sort(num);

        //-2, -1, 0, 0, 1, 2
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pairs.containsKey(num[i] + num[j])) {
                    List<int[]> list = pairs.get(num[i] + num[j]);
                    list.add(new int[]{i, j});
                } else {
                    ArrayList<int[]> list = new ArrayList<int[]>();
                    list.add(new int[]{i, j});
                    pairs.put(num[i] + num[j], list);
                }
            }
        }

        for (int i = 0; i < n - 3; i++) {

            //avoid first element's duplication.
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                //avoid second element's duplication.
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }

                if (pairs.containsKey(target - num[i] - num[j])) {
                    List<int[]> sum2 = pairs.get(target - num[i] - num[j]);
                    boolean isFirstPush = true;
                    for (int k = 0; k < sum2.size(); k++) {
                        int[] indexes = sum2.get(k);

                        //ensure the index is non-decrease.
                        if (indexes[0] <= j) {
                            continue;
                        }
                        if (isFirstPush || res.get(res.size() - 1).get(2) != num[indexes[0]]) {
                            ArrayList<Integer> list = new ArrayList<Integer>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[indexes[0]]);
                            list.add(num[indexes[1]]);
                            isFirstPush = false;
                            res.add(list);
                        }
                    }
                }
            }
        }

        return res;
    }
}
