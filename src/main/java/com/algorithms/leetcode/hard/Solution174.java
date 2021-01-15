package com.algorithms.leetcode.hard;

import java.util.*;

/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * -2 (K)	-3   3
 * -5	   -10	 1
 * 10  	    30  -5 (P)
 * 1  -3   2
 * 0  -1   2
 * 0   0  -2
 * 说明:
 * 骑士的健康点数没有上限。
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class Solution174 {
    public static void main(String[] args) {
        int[][] ints;
        ints = new int[][]{{1, -3, 2}, {0, -1, 2}, {0, 0, -2}};
        int i = new Solution174().calculateMinimumHP(ints);
        System.out.println(i);
    }


    /**
     * 解法1
     * 左上到右下，不符合DP的特性，所以需要硬算 超时
     */
    List<Map<Integer, Integer>> list = new ArrayList<>();

    public int calculateMinimumHP0(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }

        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                list.add(doSomething(dungeon, i, j));
            }
        }
        ArrayList<Integer> integers = new ArrayList<>(list.get(list.size() - 1).values());
        int max = -integers.stream().max(Integer::compareTo).orElse(0);
        return max > 0 ? max + 1 : 1;
    }

    private Map<Integer, Integer> doSomething(int[][] dungeon, int a, int b) {
        Map<Integer, Integer> map = new HashMap<>();
        if (a == 0 && b == 0) {
            map.put(dungeon[a][b], dungeon[a][b]);
        } else if (a == 0) {
            Map<Integer, Integer> preMap = list.get(b - 1);
            map.put(
                    dungeon[a][b] + new ArrayList<>(preMap.keySet()).get(0),
                    Math.min(dungeon[a][b] + new ArrayList<>(preMap.keySet()).get(0),
                            new ArrayList<>(preMap.values()).get(0)));
        } else if (b == 0) {
            Map<Integer, Integer> preMap = list.get(a * dungeon[0].length + b - dungeon[0].length);
            map.put(
                    dungeon[a][b] + new ArrayList<>(preMap.keySet()).get(0),
                    Math.min(dungeon[a][b] + new ArrayList<>(preMap.keySet()).get(0),
                            new ArrayList<>(preMap.values()).get(0)));
        } else {
            Map<Integer, Integer> leftMap = list.get(a * dungeon[0].length + b - 1);
            Map<Integer, Integer> upMap = list.get(a * dungeon[0].length + b - dungeon[0].length);
            for (Integer key : leftMap.keySet()) {
                map.put(dungeon[a][b] + key, Math.min(dungeon[a][b] + key, leftMap.get(key)));
            }
            for (Integer key : upMap.keySet()) {
                if (map.containsKey(dungeon[a][b] + key)) {
                    map.put(dungeon[a][b] + key, Math.max(Math.min(dungeon[a][b] + key, upMap.get(key)), map.get(dungeon[a][b] + key)));
                } else {
                    map.put(dungeon[a][b] + key, Math.min(dungeon[a][b] + key, upMap.get(key)));
                }
            }
        }
        return map;
    }

    /**
     * 解法2
     * DP
     * dp[i][j]dp[i][j] 表示从坐标 (i,j) 到终点所需的最小初始值
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
