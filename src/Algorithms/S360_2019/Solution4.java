package Algorithms.S360_2019;

import java.util.HashMap;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] a =new int[n];
        for (int i =0;i<a.length;i++){
            a[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i=0;i<q;i++){
            l[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
        }
        for(int i=0;i<q;i++){
            int tl=l[i];
            int tr=r[i];
            if(tl<1)tl=1;
            if(tr>n)tr=n;
            HashMap<Integer,Integer> hashMap =new HashMap<>();
            int sum=0;
            for(int j=tl-1;j<tr;j++){
                if(hashMap.get(a[j])==null){
                    sum++;
                    if(sum==m)break;
                    hashMap.put(a[j],1);
                }
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}
