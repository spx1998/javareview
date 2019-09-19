package Algorithms.practice.ByteDance;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 服务器传输文件，已知每秒传输一个文件，给出n批文件每批加入传输队列的时间以及每批次文件的个数。
 * 输出：传输完成的时刻以及传输队列中堆及文件最多时的文件数量。
 *
 * 思路：模拟该过程
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i=0;i<n;i++){
            treeMap.put(scanner.nextInt(),scanner.nextInt());
        }
        int max = 0;
        int time = 0;
        int num = 0;
        while (!treeMap.isEmpty()||num!=0){
            if(num==0&&!treeMap.isEmpty()){
                time = treeMap.firstKey();
                num = treeMap.get(treeMap.firstKey());
                treeMap.remove(treeMap.firstKey());
            }else if(num!=0){
                if(!treeMap.isEmpty()&&treeMap.firstKey()==time){
                    num += treeMap.get(treeMap.firstKey());
                    treeMap.remove(treeMap.firstKey());
                }
            }
            if(num>max)max = num;
            num--;
            time++;
        }
        System.out.println(time + " " + max);
    }
}
