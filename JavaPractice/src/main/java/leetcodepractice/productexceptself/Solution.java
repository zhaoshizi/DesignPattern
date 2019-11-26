// 如数组N=[1,2,3,4]，我们一次遍历的时候，得到顺序的乘积为ins=[1,2,6,24]，
// 逆序的乘积为ret=[24, 24, 12, 4]，那么最后对于数组N中的除当前元素之外其余各元素的乘积，
// 我们就可以利用ins和ret这两个数组来计算得到，假设输出数组为output，对于output中的每一个元素，
// 存在output [i] = ins [i-1] * ret [i+1]（注意边界条件），最后得到的结果为output = [24, 12, 8, 6]

package leetcodepractice.productexceptself;

class Solution{
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <=1)
            return new int[0];
        
        int[] nums1 = new int[nums.length];
        int[] nums2 = new int[nums.length];
        
        for(int i=0,j=nums.length-1;i<nums.length;i++,j--){
            if(i == 0)
                nums1[i]= nums[i];
            else
                nums1[i] = nums1[i-1] * nums[i];
            if(j == nums.length-1)
                nums2[j] = nums[j];
            else    
                nums2[j] = nums2[j+1] * nums[j];
        }

        int[] retNums = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i == 0)
                retNums[i] = nums2[i+1];
            else if(i == nums.length-1)
                retNums[i] = nums1[i-1];
            else
                retNums[i] = nums1[i-1]*nums2[i+1];
        }
        return retNums;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        int[] retNums = new Solution().productExceptSelf(nums);
        for(int i : retNums)
            System.out.println(i);

    }
}