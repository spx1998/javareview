package Algorithms.JZoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Question20 {
    public static void main(String[] args) {
        Question20 question20 = new Question20();
        question20.push(3);
        System.out.println(question20.min());
        question20.push(4);
        System.out.println(question20.min());
        question20.push(2);
        System.out.println(question20.min());
        question20.push(3);
        System.out.println(question20.min());
        question20.pop();
        System.out.println(question20.min());
        question20.pop();
        System.out.println(question20.min());
        question20.pop();
        System.out.println(question20.min());
        question20.push(0);
        System.out.println(question20.min());

    }
    private Stack<Integer> stack = new Stack<>();
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public void push(int node) {
        stack.push(node);
        if(arrayList.isEmpty())arrayList.add(node);
        else {

            for (int i = 0; i<arrayList.size(); i++){
                if(node<=arrayList.get(i)){
                    arrayList.add(i,node);
                    break;
                }
            }
            if(node>arrayList.get(arrayList.size()-1))
                arrayList.add(node);
        }
    }

    public void pop() {
        int temp = stack.pop();
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()){
            if(temp==it.next()){
                it.remove();
                break;
            }
        }
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return arrayList.get(0);
    }
}
