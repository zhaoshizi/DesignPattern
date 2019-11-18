// 打乱一个没有重复元素的数组。

// 示例:

// // 以数字集合 1, 2 和 3 初始化数组。
// int[] nums = {1,2,3};
// Solution solution = new Solution(nums);

// // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
// solution.shuffle();

// // 重设数组到它的初始状态[1,2,3]。
// solution.reset();

// // 随机返回数组[1,2,3]打乱后的结果。
// solution.shuffle();

package leetcodepractice.shuffle;
import java.util.Random;

class Solution {
    private int[] priNums;

    public Solution(int[] nums) {
        priNums = new int[nums.length];
        for(int i = 0; i< nums.length;i++){
            priNums[i]=nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] resetNums = new int[priNums.length];
        for(int i = 0; i< priNums.length;i++){
            resetNums[i]=priNums[i];
        }
        return resetNums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] flags=new int[priNums.length];
        for(int i =0;i<flags.length;i++){
            flags[i]= -1;
        }
        int[] shuffledNums= new int[priNums.length];

        int i = 0;
        Random random = new Random();
        for(int j= 0;j<priNums.length;j++){
            i = random.nextInt(priNums.length);
            if(flags[i] !=1 ){
                flags[i] =1;
                shuffledNums[j] = priNums[i];
            }
            else{
                j--;
            }
        }
        return shuffledNums;
    }
    public static void main(String[] args) {
        int[] nums={1};
        Solution s= new Solution(nums);
        int[] nums1 = s.shuffle();
        for(int i:nums1){
            System.out.println(i);
        }
        nums1 = s.reset();
        for(int i:nums1){
            System.out.println(i);
        }
    }
}