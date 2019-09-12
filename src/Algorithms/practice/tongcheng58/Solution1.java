package Algorithms.practice.tongcheng58;

import java.util.Scanner;

/**
 * 输入形如1，2，3，3，4的有序数列，输出有多少个不重复的数字。
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String str =scanner.next();
        scanner.close();
        String[] strings = str.split(",");
        if (strings.length==0){
            System.out.println(0);
            return;
        }
        int count=1;
        for(int i=1;i<strings.length;i++){
            if(!strings[i].equals(strings[i - 1])){
                count++;
            }
        }
        System.out.println(count);

    }
}
