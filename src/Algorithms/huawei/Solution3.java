package Algorithms.huawei;

import java.util.Scanner;

/**
 * 牛客网华为三道编程题
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String str="";
        while (scanner.hasNext()) {
            str= scanner.next();
            str=str.substring(2);
            char[] chars = str.toCharArray();
            int num=0;
            int temp=1;
            for(int i=str.length();i>=1;i--){
                if(chars[i-1]=='A'){
                    num+=temp*10;
                }else if(chars[i-1]=='B'){
                    num+=temp*11;

                }else if(chars[i-1]=='C'){
                    num+=temp*12;

                }else if(chars[i-1]=='D'){
                    num+=temp*13;

                }else if(chars[i-1]=='E'){
                    num+=temp*14;

                }else if(chars[i-1]=='F'){
                    num+=temp*15;

                }else if(chars[i-1]=='H'){
                    num+=temp*16;

                }else {
                    num+=temp*(chars[i-1]-48);
                }
                temp*=16;
            }
            System.out.println(num);
        }
        //System.out.println((char));

    }
}
