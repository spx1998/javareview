package com.algorithms.JZoffer;

import java.util.Stack;

public class Question21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.empty()){
                if(stack.peek()==popA[j]){
                    stack.pop();
                    j++;
                }else break;
            }
        }
        if(j==popA.length)return true;
        else return false;
    }
}
