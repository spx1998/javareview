package com.algorithms.JZoffer;

public class Question23 {
    public static void main(String[] args) {
        Question23 question23 =new Question23();
        int[] array = {5,4,3,2,1};
        System.out.println(question23.VerifySquenceOfBST(array));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)return false;
        return judge(sequence,0,sequence.length-1);
    }
    private boolean judge(int[] sequence, int pre, int end){
        if(end<=pre)return true;
        int j=0;
        for (int i=pre;i<=end;i++){
            j=i;
            if(sequence[i]>sequence[end]){
                break;
            }
        }
        for(int i=j;i<end;i++){
            if(sequence[i]<sequence[end])
                return false;
        }
        return judge(sequence,pre,j-1)&&judge(sequence,j,end-1);
    }
}
