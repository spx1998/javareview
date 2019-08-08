package Algorithms.JZoffer;

import java.util.ArrayList;

public class Question30 {
    public static void main(String[] args) {
        Question30 question30 = new Question30();
        System.out.println(question30.NumberOf1Between1AndN_Solution(10000));
    }
    public int NumberOf1Between1AndN_Solution(int n) {//245
        if(n<=0) return 0;
        if(n<10) return 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int nn=n;
        int digit=0;
        while (nn!=0){
            arrayList.add(nn%10);
            nn /= 10;
            digit += 1;
        }
        int[] nums = new int[digit-1];
        nums[0]=1;
        nn=10;
        for(int i=1;i<nums.length;i++) {// 9 99
            nums[i] = nn + 10* nums[i - 1];
            nn *= 10; //100
        }
        int count= 0;
//        nn = nn/10;
        int x=n;
        for(int i=arrayList.size()-1;i>=0;i--){ // 2 4 5
            if(i==0){
                if(arrayList.get(i)==0)
                    break;
                else {
                    count =count +1;
                    break;
                }
            }
            if(arrayList.get(i)==0){
                nn/=10;
                continue;
            }
            x = x-arrayList.get(i)*nn;
            if(arrayList.get(i)==1){

                count = count+nums[i-1]+x+1;
                nn/=10;
                continue;
            }
            count = count + nn + arrayList.get(i)*nums[i-1];
            nn/=10;
        }
        return count;
    }
}
