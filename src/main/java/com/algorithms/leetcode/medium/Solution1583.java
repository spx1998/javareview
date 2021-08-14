package com.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 * 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。
 * 换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 * 所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
 * 但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
 * x 与 u 的亲近程度胜过 x 与 y，且
 * u 与 x 的亲近程度胜过 u 与 v
 * 返回 不开心的朋友的数目 。
 */
public class Solution1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int[] p : pairs) {
            pairMap.put(p[0], p[1]);
            pairMap.put(p[1], p[0]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (preferences[i][j] != pairMap.get(i)) {
                int k = preferences[i][j];
                if (compare(k, i, pairMap.get(k), preferences[k])) {
                    res++;
                    break;
                }
                j++;
            }
        }
        return res;
    }

    private boolean compare(int k, int i, int pair, int[] preference) {
        for (int num : preference) {
            if (num == pair) {
                return false;
            }
            if (num == i) {
                return true;
            }
        }
        return false;
    }
}
