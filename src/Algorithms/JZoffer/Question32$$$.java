package Algorithms.JZoffer;

import java.util.ArrayList;

public class Question32$$$ {
    public static void main(String[] args) {

    }

    public int GetUglyNumber_Solution(int index) {
        if(index<=0) return 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int a=0,b=0,c=0,newNum=0;
        while (arrayList.size()<index){
            newNum = Math.min(arrayList.get(a)*2,Math.min(arrayList.get(b)*3,arrayList.get(c)*5));
            if(arrayList.get(a)*2==newNum)a++;
            if(arrayList.get(b)*3==newNum)b++;
            if(arrayList.get(c)*5==newNum)c++;
            arrayList.add(newNum);
        }
        return arrayList.get(index-1);
    }
}
