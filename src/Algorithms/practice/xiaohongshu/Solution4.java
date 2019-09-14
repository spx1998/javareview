package Algorithms.practice.xiaohongshu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 在游戏中，击败魔物后，薯队长获得了N件宝物，接下来得把这些宝物卖给宝物回收员来赚点小钱。
 * 这个回收员有个坏毛病，每次卖给他一件宝物后，之后他就看不上比这件宝物差的宝物了。
 * 在这个世界中，衡量宝物的好坏有两个维度，稀有度X和实用度H，回收员在回收一个宝物A后，下一个宝物的稀有度和实用度都不能低于宝物A。
 * 那么薯队长如何制定售卖顺序，才能卖给回收员宝物总个数最多。
 *
 * 做的不对：答案参考leetcode 354题
 *
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int[][] value = new int[n][2];
        for (int i = 0; i < n; i++) {
            value[i][0] = scanner.nextInt();
            a.add(value[i][0]);
            value[i][1] = scanner.nextInt();
            b.add(value[i][1]);
        }
        Collections.sort(a);
        Collections.sort(b);
        ArrayList<Integer> c = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            if(i>0&&a.get(i).equals(a.get(i - 1))){
                continue;
            }
            for(int j=0;j<n;j++){
                if(value[j][0] == a.get(i)){
                    temp.add(value[j][1]);
                }
            }
            Collections.sort(temp);
            c.addAll(temp);
        }
        int max = 1;
        int tempNum = 1;
        for(int i=1;i<n;i++){
            if(c.get(i)>=c.get(i-1)){
                tempNum++;
                if(tempNum>max)max=tempNum;
            }else tempNum=1;
        }
        ArrayList<Integer> d = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            if(i>0&&a.get(i).equals(a.get(i - 1))){
                continue;
            }
            for(int j=0;j<n;j++){
                if(value[j][1] == b.get(i)){
                    temp.add(value[j][0]);
                }
            }
            Collections.sort(temp);
            d.addAll(temp);
        }
         tempNum = 1;
        for(int i=1;i<n;i++){
            if(d.get(i)>=d.get(i-1)){
                tempNum++;
                if(tempNum>max)max=tempNum;
            }else tempNum=1;
        }
        System.out.println(max);
    }
}
//        int[][] sellArray = new int[n][2];
//        System.out.println(sell(value,sellArray,n,0));
//    }
//
//    private static int sell(int[][] value,  int[][] sellArray,int n,int i) {
//        if(i==value.length){
//            return 0;
//        }
//        //能不能卖 ：能：卖或不卖的max 不能：不卖
//        int flag=0;
//        for(int j=0;j<n;j++){
//            if((value[i][0]>sellArray[j][0]&&value[i][1]<sellArray[j][1])
//                    ||(value[i][0]<sellArray[j][0]&&value[i][1]>sellArray[j][1])){
//                flag = 1;
//                break;
//            }
//        }
//        if(flag == 0){
//            int max = sell(value, sellArray, n, i+1);
//            sellArray[i]=value[i];
//            max = Math.max(max,1+sell(value, sellArray, n, i+1));
//            sellArray[i] = new int[]{0,0};
//            return max;
//        }
//        else
//            return sell(value, sellArray, n, i+1);
//    }
//}
