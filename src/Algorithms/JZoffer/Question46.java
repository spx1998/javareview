package Algorithms.JZoffer;

import java.util.ArrayList;

public class Question46 {
    public static void main(String[] args) {
        Question46 question46 = new Question46();
        System.out.println(question46.LastRemaining_Solution(15,3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<=0) return -1;
        if(n==1) return 0;
        ArrayList<Integer> children = new ArrayList<>();
        for(int i=0;i<n;i++){
            children.add(i);
        }
        int num =0;
        while (children.size()!=1){
            for(int i=0;i<m;i++){
               num++;
               if(num==children.size())
                   num=0;
            }
            if(num==children.size()){
                children.remove(children.size()-1);
                num=0;
            }
            if(num==0)children.remove(children.size()-1);
            else {
                num=num-1;
                children.remove(num);
            }
        }
        return children.get(0);
    }
}