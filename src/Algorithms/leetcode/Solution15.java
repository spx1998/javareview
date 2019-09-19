package Algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 解法：双指针，时间复杂度 n^2.
 */
public class Solution15 {
    public static void main(String[] args) {
        new Solution15().threeSum(new int[]{1,-1,-1,0});
    }
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length-2;i++){
                if(i>0&&nums[i]==nums[i-1])
                    continue;
                int x = i+1;
                int y = nums.length-1;
                while (x<y){
                    if(x-1!=i&&nums[x]==nums[x-1]){
                        x++;
                    }else if(nums[x]+nums[y]+nums[i]==0){
                        list.add(nums[i]);
                        list.add(nums[x]);
                        list.add(nums[y]);
                        lists.add(list);
                        list = new ArrayList<>();
                        x++;
                    }else if(nums[x]+nums[y]+nums[i]>0){
                        y--;
                    }else{
                        x++;
                    }
                }
            }
        return lists;
        }

}
