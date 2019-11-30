// 数组中的第K个最大元素
// 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

// 示例 1:

// 输入: [3,2,1,5,6,4] 和 k = 2
// 输出: 5
// 示例 2:

// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
// 输出: 4
// 说明:

// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。


package leetcodepractice.findkthlargest;

class Solution{
    public int findKthLargest(int[] nums, int k) {
        //创建最大堆解法
        // if(nums.length ==1 )
        //     return nums[0];
        // buildMaxHeep(nums,nums.length-1);
        // for(int i=1;i<k;i++){
        //     nums[0] = nums[nums.length-i];
        //     buildMaxHeep(nums,nums.length-1-i);
        // }
        // return nums[0];


        if(nums.length ==1 )
            return nums[0];
        int[] minHeep = buildeMinHeep(nums, k);
        for(int n:minHeep)
                System.out.print(n+" ");
            System.out.println();
        for(int i=k;i<nums.length;i++){
            if(nums[i]>minHeep[0]){
                minHeep[0]=nums[i];
                AdustMinHeep(minHeep, k-1);
                for(int n:minHeep)
                    System.out.print(n+" ");
                System.out.println();
            }
        }
        return minHeep[0];
    }

    //直接创建最大堆，依次从中取中k个。
    public void buildMaxHeep(int[] nums,int length){
        int max = 0,k=0;
        for(int i = (length-1)/2;i>=0;i-- ){
            max = nums[i];
            k = i;
            if((i*2 +2)<=length && nums[i*2 +2]>max){
                k = i*2+2;
                max = nums[i*2+2];
            }
            if(nums[i*2 +1]>max){
                k = i*2+1;
                max = nums[i*2+1];
            }
            if(max>nums[i]){
                nums[k]=nums[i];
                nums[i]=max;
            }
        }
    }

    //创建个k大小的最小堆，最堆顶的，就是第k个最大的
    public int[] buildeMinHeep(int[] nums,int k){
        int[] minHeep = new int[k];
        for(int i=0;i<k;i++){
            minHeep[i] = nums[i];
        }
        AdustMinHeep(minHeep,k-1);
        return minHeep;
    }

    public void AdustMinHeep(int[] nums,int length){
        int min = 0,k=0;
        if(length >=1){
            for(int i = (length-1)/2;i>=0;i-- ){
                min = nums[i];
                k = i;
                if((i*2 +2)<=length && nums[i*2 +2]<min){
                    k = i*2+2;
                    min = nums[i*2+2];
                }
                if(nums[i*2 +1]<min){
                    k = i*2+1;
                    min = nums[i*2+1];
                }
                if(min<nums[i]){
                    nums[k]=nums[i];
                    nums[i]=min;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9,10};

        System.out.println(new Solution().findKthLargest(nums, 11));
    }
}