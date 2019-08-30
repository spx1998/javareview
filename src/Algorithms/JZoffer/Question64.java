package Algorithms.JZoffer;

import java.util.ArrayList;

public class Question64 {
    public static void main(String[] args) {
        Question64 question64 =new Question64();
        question64.maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> arrayList= new ArrayList<>();
        if(num.length==0||size==0)return arrayList;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<num.length-size+1;i++){
            int k=i+size;
            if(i==0||num[i-1]==max){
                max=Integer.MIN_VALUE;
                for(int j=i;j<k;j++){
                    if(num[j]>max)
                        max=num[j];
                }
            }else if(num[k-1]>max)
                max=num[k-1];
            arrayList.add(max);

        }
        return arrayList;
    }
}
