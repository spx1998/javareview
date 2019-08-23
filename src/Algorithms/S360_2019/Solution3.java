package Algorithms.S360_2019;

import java.util.Scanner;
import java.util.ArrayList;

public class Solution3 {

    public static long minNum(int k, long start, long end) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        long tmp = start;
        while (tmp != 0) {
            long rest = tmp % k;
            list.add((int) rest);
            tmp = tmp / k;
        }
        long sum = 1;
        for (int i = 0; i < list.size(); i++) {
            long num = list.get(i);
            num = k - 1 - num;
            long size = (long) (num * sum);
            if (start + size <= end) {
                start = start + size;
            } else {
                return start;
            }
            sum = sum * k;
        }
        while (start < end) {
            long size = (long) ((k - 1) * sum);
            if (start + size <= end) {
                start = start + size;
            } else {
                return start;
            }
            sum = sum * k;
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int time = in.nextInt();
            for (int i = 0; i < time; i++) {
                int k = in.nextInt();
                long start = in.nextLong();
                long end = in.nextLong();
                System.out.println(minNum(k, start, end));
            }
        }
    }
}
