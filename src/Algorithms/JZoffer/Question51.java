package Algorithms.JZoffer;

public class Question51 {
    public static void main(String[] args) {
        Question51 question51 =new Question51();
        question51.multiply(new int[]{1,2,3});
    }
    public int[] multiply(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int temp=1;
        for(int i=0;i<A.length;i++){
            if(i==0)temp=1;
            else temp*=A[i-1];
            left[i]=temp;
        }
        temp=1;
        for(int i=A.length-1;i>=0;i--){
            if(i==A.length-1)temp=1;
            else temp*=A[i+1];
            right[i]=temp;
        }
        int[] B = new int[A.length];
        for(int i=0;i<B.length;i++){
            B[i]=left[i]*right[i];
        }
        return B;
    }
}

