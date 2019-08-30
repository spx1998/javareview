package Algorithms.JZoffer;

public class Question65 {
    public static void main(String[] args) {
        Question65 question65 = new Question65();
        char[] chars = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        question65.hasPath(chars,5,8,"SGGFIECVAASABCEHJIGQEMS".toCharArray());
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        for(int i=0;i<matrix.length;i++) {
            boolean b=false;
            if(matrix[i]==str[0])
                b = path(matrix, rows, cols, i,str, 1, new int[matrix.length]);
            if(b)return true;
        }
        return false;
    }

    private boolean path(char[] matrix, int rows, int cols,int addr, char[] str,int num, int[] times) {
        if(num==1)times[addr]=1;
        if(num==str.length)return true;
        if(addr%cols!=0&&matrix[addr-1]==str[num]&&times[addr-1]==0){
            times[addr-1]=1;
            if(path(matrix,rows,cols,addr-1,str,num+1,times))return true;
            else times[addr-1]=0;
        }
        if((addr+1)%cols!=0&&matrix[addr+1]==str[num]&&times[addr+1]==0){
            times[addr+1]=1;
            if(path(matrix,rows,cols,addr+1,str,num+1,times))return true;
            else times[addr+1]=0;

        }
        if((addr-cols)>=0&&matrix[addr-cols]==str[num]&&times[addr-cols]==0){
            times[addr-cols]=1;
            if(path(matrix,rows,cols,addr-cols,str,num+1,times))return true;
            else times[addr-cols]=0;

        }
        if((addr+cols)<matrix.length&&matrix[addr+cols]==str[num]&&times[addr+cols]==0){
            times[addr+cols]=1;
            if(path(matrix,rows,cols,addr+cols,str,num+1,times))return true;
            else times[addr+cols]=0;

        }
        return false;
    }
}
