package Algorithms.Pinduoduo2019;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] pn = sc.next().toCharArray();
        sc.close();
        List<List<Integer>> record = new ArrayList<>(10);
        for (int i = 0; i < 10; i ++) record.add(new ArrayList<Integer>());
        for (int i = 0; i < pn.length; i ++) {
            record.get(pn[i]-'0').add(i);
        }
        for (int i = 0; i < 10; i ++) {
            if (record.get(i).size() >= k) {
                System.out.println(0);
                System.out.println(pn);
                return;
            }
        }
        int cost = Integer.MAX_VALUE;
        char[] mpn = new char[n];
        scan: for (int i = 0; i < 10; i ++) {
            int curk = record.get(i).size();
            int curcost = 0;
            char[] mpn_ad = new char[n];
            for (int j = 0; j < n; j ++) mpn_ad[j] = pn[j];
            for (int j = 1; j < 10 && curk < k; j ++) {
                if (i+j < 10 && curk < k) {
                    for (int p = 0; p < record.get(i+j).size(); p ++) {
                        int pos = record.get(i+j).get(p);
                        curcost += j;
                        if (curcost > cost) continue scan;
                        mpn_ad[pos] = (char)(i + '0');
                        curk ++;
                        if (curk == k) break;
                    }
                }
                if (i-j >= 0 && curk < k) {
                    for (int p = record.get(i-j).size()-1; p >= 0; p --) {
                        int pos = record.get(i-j).get(p);
                        curcost += j;
                        if (curcost > cost) continue scan;
                        mpn_ad[pos] = (char)(i + '0');
                        curk ++;
                        if (curk == k) break;
                    }
                }
            }
            if (curcost < cost || test(mpn, mpn_ad)) {
                cost = curcost;
                mpn = mpn_ad;
            }
        }
        System.out.println(cost);
        System.out.println(mpn);
    }
    public static boolean test(char[] ori, char[] cur) {
        for (int i = 0; i < ori.length; i ++) {
            if (cur[i] < ori[i]) return true;
            else if (cur[i] > ori[i]) return false;
        }
        return false;
    }
}