package Algorithms.JZoffer;

public class Question52 {
    public static void main(String[] args) {
        Question52 question52 =new Question52();
        System.out.println(question52.isNumeric("12e".toCharArray()));
    }
    public boolean isNumeric(char[] str) {
        if(str==null||str.length==0)return false;
        int eNum=0;
        int pointNum=0;
        for(int i=0;i<str.length;i++){
            if(str[i]=='0'||str[i]=='1'||str[i]=='2'||str[i]=='3'||str[i]=='4'||str[i]=='5'||str[i]=='6'||str[i]=='7'||str[i]=='8'||str[i]=='9'){
            }
            else if((str[i]=='+'||str[i]=='-')&&(i==0||str[i-1]=='e'||str[i-1]=='E')) {
            }
            else if((str[i]=='e'||str[i]=='E')&&(i!=0&&i!=str.length-1)&&eNum==0) {
                eNum++;
            }
            else if(str[i]=='.'&&i!=0&&i!=str.length-1&&pointNum==0&&eNum==0) {
                pointNum++;
            }
            else return false;
        }
        return true;
    }
}