// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

// 示例:

// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]
// 说明:

// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。

package leetcodepractice.movezeroes;

class Solution{

    public void moveZeroes(int[] nums) {
        int i=-1,j=0;
        while(j<nums.length){
            if(i == -1 && nums[j]==0)
                i = j;
            else if(i != -1 && nums[j]!=0){
                nums[i] = nums[j];
                i++;
                j++;
            }
            else
                j++;
        }
        while(i!=-1 && i<nums.length){ 
            nums[i]=0;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};
        new Solution().moveZeroes(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
}