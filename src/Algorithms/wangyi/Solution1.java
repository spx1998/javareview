package Algorithms.wangyi;

    import java.util.Scanner;
    import java.util.Stack;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.close();
        Stack<String> stack = new Stack<>();
        while (n!=0){
            if((n&1)==0){
                stack.push("2");
                n=(n-2)/2;
            }else {
                stack.push("1");
                n=(n-1)/2;
            }

        }
        StringBuilder s= new StringBuilder();
        while (!stack.empty()){
            s.append(stack.pop());
        }
        System.out.println(s);
    }
}
