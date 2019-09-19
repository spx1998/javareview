package Algorithms.leetcode_DP;

import java.util.ArrayList;

/**
 * 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，
 * 然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。
 * 直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 *
 */
public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:nums){
            list.add(i);
            num+=i;
        }
        int i = maxChoose(list,true);
        return i>=num-i;
    }
    private static int maxChoose(ArrayList<Integer> arrayList, boolean i) {
        if(arrayList.size()==0)return 0;
        else if(i){
            return Math.max(arrayList.get(0)+maxChoose(new ArrayList<>(arrayList.subList(1,arrayList.size())), !i),arrayList.get(arrayList.size()-1)+maxChoose(new ArrayList<>(arrayList.subList(0,arrayList.size()-1)),!i));
        }else {
            return Math.min(maxChoose(new ArrayList<>(arrayList.subList(1,arrayList.size())), !i),maxChoose(new ArrayList<>(arrayList.subList(0,arrayList.size()-1)),!i));

        }
    }
}
