package Algorithms.practice.ByteDance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 一个数列，两人轮流从列首或列尾取数字，假设两人都足够聪明，先取的人能取走数字的最大值是？
 * 输入：一个数组
 * 输出：能取到的最大值
 *
 * 我的思路：类似dp，每次选择都是取首或者取尾，那么计算玩家1所取的最大值时，对于玩家1来说，应选择max（取首，取尾）。而对于玩家2来说，
 *  * 应该取min（取首，取尾）。 超时。
 *  *
 *  * 更简洁的思路应该如同leetCode的486题和877题。
 *
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            arrayList.add(scanner.nextInt());
        }
        System.out.println(maxChoose(arrayList,true));
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
