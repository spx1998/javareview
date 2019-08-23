package Algorithms.S360_2019;

import java.util.Scanner;

public class Solution1 {
    public static long scaleNum(){
        int n,count;
        Scanner s = new Scanner(System.in);
        count = n = s.nextInt();
        if(n<2||n>1000)
            return 0;
        long maxX=0,maxY=0,minX=0,minY=0;
        long curX,curY;
        while(count-- >0 ){
            if((count+1)==n){
                maxX = minX = s.nextLong();
                maxY = minY = s.nextLong();
                continue;
            }
            curX = s.nextLong();
            curY = s.nextLong();
            maxX =Math.max(curX,maxX);
            maxY =Math.max(curY,maxY);
            minX= Math.min(curX,minX);
            minY= Math.min(curY,minY);
        }
        long sY = Math.abs((maxY-minY));
        long sX = Math.abs((maxX-minX));
        return sY>=sX?sY*sY:sX*sX;
    }
    public static void main(String[] args){
        System.out.print(scaleNum());

    }
}
