package leecodepractice.lengthoflis;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLIS {

    // 典型的动态规划题目，定义一个数组dp，其中dp[i]代表以第num[i]为结尾取得的最长长度，
    // 最后返回最大的那个dp[i]就行了，
    // 所以这道题的重点在于怎么求得dp[i]。一开始我们先把dp全部元素都初始化为1，
    // 因为dp[i]无论如何最少的长度都是1（只有本身一个元素的序列），
    // 然后对于每个num[i]我们可以通过遍历num[0]~num[i-1]，
    // 如果在这个区间找到一个num[j]比num[i]小，那么开始比较dp[j]+1和dp[i]的大小，
    // 如果dp[j]+1>dp[i]则更新dp[i]，所以转移方程为dp[i] = max(dp[j]+1,dp[i])。

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] lengthArray = new int[nums.length];
        lengthArray[0] = 1;
        int max = lengthArray[0];
        for (int i = 1; i < lengthArray.length; i++) {
            lengthArray[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    lengthArray[i] = lengthArray[i] > (lengthArray[j] + 1) ? lengthArray[i] : (lengthArray[j] + 1);
            }
            max = max > lengthArray[i] ? max : lengthArray[i];
        }
        return max;

    }

    // 首先将第一个元素存入vec数组，然后依次看后面的元素。若后面的元素大于vec数组的最后一个元素，
    // 则将其加入到vec末尾,否则将它替换掉vec数组中第一个大于等于它的元素。最后返回vec的大小即可。
    // 使用二分法查找
    public static int lengthOfLIS2(int[] nums) {
        if (nums.length==0)
            return 0;

        List<Integer> vInt = new ArrayList<Integer>();
        
        vInt.add(nums[0]);
        int pos = -1;
        for(int i=1; i<nums.length;i++){
            if(vInt.get(vInt.size()-1) < nums[i])
                vInt.add(nums[i]);
            else if(nums[i] < vInt.get(0))
                vInt.set(0,nums[i]);
            else{
                int l=0,r=vInt.size()-1;
                pos = l;
                while(l<r){
                    if(vInt.get(((l+r)/2)) == nums[i]){
                        pos = (l+r)/2;
                        break;
                    }
                    else if(vInt.get(((l+r)/2)) < nums[i]){
                        l = (l+r)/2 +1;
                        pos = l;
                    }
                    else{
                        r = (l+r)/2 -1;
                        pos = r+1;
                    }
                }
                vInt.set(pos,nums[i]);
            }
        }
        return vInt.size();
    }


    public static void main(String[] args){
        int[] nums= {4,10,4,3,8,9};
        System.out.println(lengthOfLIS2(nums));
    }

}