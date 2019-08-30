package Algorithms.JZoffer;

public class Question48$$$ {
    public static void main(String[] args) {
        Question48$$$ question47 = new Question48$$$();
        System.out.println(question47.Add(1,2));
    }
    public int Add(int num1, int num2) {
        while (num2!=0){
            int temp=num1^num2;
            num2= (num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }
}