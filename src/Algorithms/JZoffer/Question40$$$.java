package Algorithms.JZoffer;

import java.util.ArrayList;
//双指针的方法 类似于滑动窗口 也类似于32题
public class Question40$$$ {
    public static void main(String[] args) {
        Question40$$$ question40$$$ = new Question40$$$();
        question40$$$.FindContinuousSequence(4);
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int first = 1;
        int last = 2;
        int curSum =3;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(sum<3)return lists;
        while (first<last){
            if(curSum<sum){
                last=last+1;
                curSum = curSum+last;
            }else if(curSum>sum){
                curSum = curSum-first;
                first = first+1;
            }else if(curSum == sum){
                ArrayList<Integer> list =new ArrayList<Integer>();
                for(int i=first;i<=last;i++){
                    list.add(i);
                }
                lists.add(list);
                first = first+1;
                curSum = curSum-first;
            }
        }
        return lists;
    }
}
