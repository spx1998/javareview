package Algorithms.JZoffer;
/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 */

import java.util.ArrayList;
//双指针的方法 类似于滑动窗口 也类似于32题
public class Question41$$$ {
    public static void main(String[] args) {
        Question41$$$ question41$$$ = new Question41$$$();
        question41$$$.FindContinuousSequence(4);
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
