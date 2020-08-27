package com.algorithms.JZoffer;
//应该 用二分查找!!!
public class Question37 {
    public static void main(String[] args) {
        Question37 question37 =new Question37();
        int[] array = {1,2,3,3,3,3,4,4};
        System.out.println(question37.GetNumberOfK2(array,5));
    }
    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        for (int value : array) {
            if (value == k)
                count++;
        }
        return count;
    }

    //二分查找
    public int GetNumberOfK2(int[] array, int k) {
        int f = getFirst(array,k);
        int l = getLast(array,k);
        if(f==-1||l==-1) return 0;
        return l-f+1;
        }

    private int getFirst(int[] array, int k) {
        int mid;
        int low = 0;
        int high = array.length-1;
        while (high-low>=0) {
            mid = (high + low) / 2;
            if (array[mid] > k)
                high = mid - 1;
            if (array[mid] < k)
                low = mid + 1;
            if (array[mid] == k &&mid-1>=0&& array[mid - 1] == k) {
                high = mid-1;
            }
            else if(array[mid]==k)return mid;
        }
        return -1;
    }

    private int getLast(int[] array, int k) {
        int mid;
        int low = 0;
        int high = array.length-1;
        while (high-low>=0) {
            mid = (high + low) / 2;
            if (array[mid] > k)
                high = mid - 1;
            if (array[mid] < k) {
                low = mid + 1;
            }
            if (array[mid] == k &&mid+1<array.length&& array[mid + 1] == k)
                low = mid+1;
            else if(array[mid]==k)return mid;
        }
        return -1;
    }
}