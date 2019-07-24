package leecodepractice;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Practise1 {

    public static int findSingleNum(int[] nums) {
        int singleNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            singleNum = singleNum ^ nums[i];
        }
        System.out.println(singleNum);
        return singleNum;
    }

    public static int findMajorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : nums) {
             map.put(i,1 + (int)(map.get(i)==null? 0:map.get(i)));
        }
        int key = 0;
        int maxNum = 0;
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            if ((int) e.getValue() > maxNum) {
                maxNum = (int) e.getValue();
                key = (int) e.getKey();
            }
        }
        System.out.println(key);
        return key;
    }
    
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m-1, j = n-1, l = m+n-1;
        while(i>=0 && j>=0){
            while(i>=0 && j>=0 && nums1[i] >= nums2[j]){
                nums1[l] = nums1[i];
                l--;
                i--;
            }
            while(i>=0 && j>=0 && nums1[i] <= nums2[j]){
                nums1[l] = nums2[j];
                l--;
                j--;
            }
        }

        if(i<0){
            while(j>=0){
                nums1[j]=nums2[j];
                j--;
            }   
        }
        for(int h : nums1)
            System.out.println(h);
    }

    public static String largestNumber(int[] nums){
        List<String> strList = new ArrayList<String>();
        for(int n : nums){
            strList.add(String.valueOf(n));
        }

        Collections.sort(strList,(x,y)->{return ((y+x).compareTo(x+y));});
        String str = "";
        if(strList.get(0).equals( "0"))
            return "0";

        for(String s : strList){
            str = str + s;
        }
        return str;

    }

    public static void main(String[] args) {
        // int[] nums = {1,1,2,3,4,5,6,3,4,5,6};
        // findSingleNum(nums);
        // --------------------------
        // int[] nums = { 1, 1, 2 ,2,2};
        // findMajorityElement(nums);
        // -------------
        // int[] nums1 = {2,0};
        // int[] nums2 = {1};
        // merge(nums1, 1, nums2, 1);
        // System.out.println(System.currentTimeMillis());
        int[] nums ={121,12};
        System.out.println(largestNumber(nums));

    }
}