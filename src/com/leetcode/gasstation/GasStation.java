package com.leetcode.gasstation;

/**
 * Created by titan-developer on 10/29/14.
 */
public class GasStation {

    public static void main(String[] strings) {
//        int[] gas = {4, 5, 4, 3};
//        int[] cost = {5, 6, 2, 3};

        int[] gas = {1, 2, 3, 3};
        int[] cost = {2, 1, 5, 1};

        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length)
            return -1;

        int start = -1;
        int remaining = 0;

        int index = 0;
        int count = 0;
        while (start < 0 || count < cost.length) {
            if (gas[index % cost.length] + remaining < cost[index % cost.length]) {
                if (start < 0) {
                    index++;
                    if (index >= cost.length) {
                        break;
                    }
                } else {
                    start = -1;
                    remaining = 0;
                    count = 0;
                }
            } else {
                if (start < 0) {
                    start = index % cost.length;
                }

                remaining = remaining + gas[index % cost.length] - cost[index % cost.length];
                count++;
                index++;
            }
        }

        return start;
    }
}
