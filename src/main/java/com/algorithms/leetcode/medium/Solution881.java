package com.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * 解法：
 * 排序
 */
public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int smaller = 0;
        int larger = people.length - 1;
        int count = 0;
        while (smaller <= larger) {
            if (people[smaller] + people[larger] > limit) {
                larger--;
            } else {
                larger--;
                smaller++;
            }
            count++;
        }
        return count;
    }
}
