// 乘积最大子序列
// 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

// 示例 1:

// 输入: [2,3,-2,4]
// 输出: 6
// 解释: 子数组 [2,3] 有最大乘积 6。
// 示例 2:

// 输入: [-2,0,-1]
// 输出: 0
// 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

// 前n位的乘积最大子序列分以下3种情况
// 1. 前n-1位的乘积最小子序列的乘积*A[n]最大
// 2. 前n-1位的乘积最大子序列的乘积*A[n]最大
// 3. A[n]本身最大
package leetcodepractice.maxproduct;

class Solution{
    public int maxProduct1(int[] nums){
        int[][] result = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i==j)
                    result[i][j]=nums[i];
                else
                    result[i][j]=result[i][j-1]*nums[j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
            for(int j=i;j<nums.length;j++)
                max = max>result[i][j]?max:result[i][j];
        return max;
    }

    public int maxProduct2(int[] nums){
        if(nums.length ==0)
            return 0;
        int maxValue=nums[0];
        int minValue=nums[0];
        int result = nums[0];
        int tempminValue,tempmaxValue;
        
        for(int i=1;i<nums.length;i++){
            tempminValue = minValue;
            tempmaxValue = maxValue;
            maxValue = Math.max(Math.max(nums[i],tempmaxValue*nums[i]),tempminValue*nums[i]);
            minValue = Math.min(Math.min(nums[i],tempminValue*nums[i]),tempmaxValue*nums[i]);
            result = Math.max(result,maxValue);
        }
        return result;

    }


    public static void main(String[] args) {
        //int[] nums={2,3,-2,4};
        int[] nums={-1,2,3,-1,-4};
        System.out.println(new Solution().maxProduct2(nums));
    }
}