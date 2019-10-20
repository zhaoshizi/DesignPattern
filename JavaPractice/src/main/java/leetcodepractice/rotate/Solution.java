// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

// 示例 1:

// 输入: [1,2,3,4,5,6,7] 和 k = 3
// 输出: [5,6,7,1,2,3,4]

package leetcodepractice.rotate;

class Solution{
    public void rotate(int[] nums, int k) {
        k  = k % nums.length;
        change(nums,0,nums.length-1);
        change(nums,0,k-1);
        change(nums,k,nums.length-1);
    }

    public void change(int[] nums,int b,int e){
        int temp = 0;
        for(int i=b,j=e;i<=j;i++,j--){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        new Solution().rotate(nums, 3);
        for(int i:nums)
            System.out.println(i);
    }
}