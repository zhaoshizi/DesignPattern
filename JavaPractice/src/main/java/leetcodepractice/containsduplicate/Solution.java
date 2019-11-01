// 给定一个整数数组，判断是否存在重复元素。

// 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

// 示例 1:

// 输入: [1,2,3,1]
// 输出: true
// 示例 2:

// 输入: [1,2,3,4]
// 输出: false

package leetcodepractice.containsduplicate;

public class Solution{
    public boolean containsDuplicate(int[] nums) {
        partition(nums,0,nums.length-1);
        for(int i : nums)
            System.out.println(i);
        for(int i=1,j=0;i<nums.length;i++,j++){
            if(nums[i]==nums[j])
                return true;
        }
        return false;
    }

    public void partition(int[] nums,int r,int l){
        if(r>=l)
            return;
        partition(nums,r,(r+l)/2);
        partition(nums,(r+l)/2+1,l);

        merge(nums,r,l);
    }

    public void merge(int[] nums ,int r,int l){
        if(r>= l)
            return;
        int m =(r+l)/2;
        int[] tempNums = new int[l-r+1];
        int i=r,j=m+1,k=0;
        while(i<=m && j<=l){
            if(nums[i]<=nums[j]){
                tempNums[k] = nums[i];
                i++;
            }
            else{
                tempNums[k] = nums[j];
                j++;
            }
            k++;
        }
        if(i>m){
            while(j<=l){
                tempNums[k]=nums[j];
                j++;k++;
            }
        }
        else if(j > l){
            while(i<=m){
                tempNums[k]=nums[i];
                i++;k++;
            }
        }
        while(l>=r){
            k--;
            nums[l] = tempNums[k];
            l--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new Solution().containsDuplicate(nums));
    }

}