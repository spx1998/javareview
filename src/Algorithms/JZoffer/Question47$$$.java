package Algorithms.JZoffer;
//&&与递归 佛辣
public class Question47$$$ {
    public static void main(String[] args) {
        Question47$$$ question47$$$ = new Question47$$$();
        System.out.println(question47$$$.Sum_Solution(1));
    }
    public int Sum_Solution(int n) {
        int temp=n;
        boolean b = (temp>0)&&(temp+=Sum_Solution(n-1))>0;
        return temp;
    }
}