package com.leetcode.foursum;

import java.util.*;

/**
 * Created by titan-developer on 10/23/14.
 * https://oj.leetcode.com/problems/4sum/
 *
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
        HashMap<Integer, Vector<int[]>> pairs = new HashMap<Integer, Vector<int[]>>(n * n);
        Arrays.sort(num);

        for(int i = 0; i < n; i++)
            for(int j = i+1 ; j < n; j++) {
                if (pairs.containsKey(num[i]+num[j])) {
                    Vector<int[]> list = pairs.get(num[i]+num[j]);
                    list.add(new int[]{i, j});
                } else {
                    Vector<int[]> list = new Vector<int[]>();
                    list.add(new int[]{i, j});
                    pairs.put(num[i]+num[j], list);
                }
            }

        for(int i = 0; i < n - 3; i++)
        {
            if(i != 0 && num[i] == num[i-1])continue;//防止第一个元素重复
            for(int j = i+1; j < n - 2; j++)
            {
                if(j != i+1 && num[j] == num[j-1])continue;//防止第二个元素重复
                if(pairs.containsKey(target - num[i] - num[j]))
                {
                    Vector<int[]> sum2 = pairs.get(target - num[i] - num[j]);
                    boolean isFirstPush = true;
                    for(int k = 0; k < sum2.size(); k++)
                    {
                        int[] indexes = sum2.get(k);
                        if(indexes[0] <= j)continue;//保证所求的四元组的数组下标是递增的
                        if(isFirstPush || res.get(res.size() - 1).get(2) != num[indexes[0]])
                        {
                            Vector<Integer> list = new Vector<Integer>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[indexes[0]]);
                            list.add(num[indexes[1]]);
                            isFirstPush = false;
                        }
                    }
                }
            }
        }

        return res;
    }
}
