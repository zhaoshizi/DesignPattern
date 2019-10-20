package leetcodepractice.majorityelement;

class Solution{
    public int majorityElement(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums[nums.length/2];
    }

    public void sort(int[] nums,int r,int l){
        if(r>=l)
            return;
        sort(nums,r,(r+l)/2);
        sort(nums,(r+l)/2+1,l);
        merge(nums,r,(r+l)/2,l);
    }

    public void merge(int[] nums,int r,int m,int l){
        int[] temp = new int[l-r+1];
        int i=r,j=m+1,k=0;
        while(i<=m && j<=l){
            if(nums[i]<nums[j]){
                temp[k]= nums[i];
                i++;
            }
            else{
                temp[k]= nums[j];
                j++;
            }
            k++;
        }
        if(i > m){
            while(j<=l){
                temp[k]= nums[j];
                k++;
                j++;
            }
        }
        if(j > l){
            while(i<=m){
                temp[k] = nums[i];
                i++;
                k++;
            }
        }

        for(int p=r,q=0;p<=l;p++,q++){
            nums[p]= temp[q];
        }
    }

    public int majorityElement2(int[] nums) {
        int sys=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==sys){
                count++;
            }
            else {
                count--;
                if(count==0){
                    sys=nums[i+1];
                }
            }
        }
        return sys;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,3,4};
        System.out.println(new Solution().majorityElement2(nums));
    }


}