package Algorithms.practice.tongcheng58;

import java.util.Scanner;

/**
 * 二维迷宫，每个位置一个权重值。问起点到终点所经最小权重。
 * 1.起点在左上角，终点右下角。
 * 2.启点终点权重包含在内。
 * 例如：
 * 1 2 3
 * 1 2 3
 * 3 1 3
 * 则
 * 1
 * 1 2
 *   1 3
 * 思路：为每个节点是否遍历过设置一个flag，回溯。
 *
 */
//TODO: 应该用备忘录记录已求得的某个节点到终点最小距离。 也许还可以优化为自底而上。
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] flag = new int[m][n];
        int[][] height = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                height[i][j]=scanner.nextInt();
            }
        }
        int  min = go(flag,height,0,0,m,n);
        System.out.println(min);
    }

    private static int go(int[][] flag, int[][] height, int i, int j, int m, int n) {
        if(i==m-1&&j==n-1){
            return height[m-1][n-1];
        }else if(flag[i][j]==1){
            return Integer.MAX_VALUE;
        }else {
            flag[i][j]=1;
            int a =i-1>=0?go(flag,height,i-1,j,m,n):Integer.MAX_VALUE;
            int b =i+1<m?go(flag,height,i+1,j,m,n):Integer.MAX_VALUE;
            int c =j-1>=0?go(flag,height,i,j-1,m,n):Integer.MAX_VALUE;
            int d =j+1<n?go(flag,height,i,j+1,m,n):Integer.MAX_VALUE;
            flag[i][j]=0;
            if(a==b&&b==c&&c==d&&d==Integer.MAX_VALUE)return Integer.MAX_VALUE;
            return height[i][j]+(Math.min(a,Math.min(b,Math.min(c,d))));
        }
    }
}
