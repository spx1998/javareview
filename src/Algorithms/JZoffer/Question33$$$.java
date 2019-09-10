package Algorithms.JZoffer;

import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Question33$$$ {
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
