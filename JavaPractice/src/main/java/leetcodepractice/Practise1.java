package leetcodepractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

    //验证回文串
    public static boolean isPalindrome(String s){
        s = s.trim();
        if(s == "" || s.length() == 1)
            return true;
        char[] charArray = s.toLowerCase().toCharArray();
        int i =0,j=charArray.length-1;
        for(;i<=j;i++,j--){
            while(i<=charArray.length-1 && !((charArray[i] >= 'a' && charArray[i]<='z') || (charArray[i] >= '0' && charArray[i] <= '9')))
                i++;
            while(j>=0 && !((charArray[j] >= 'a' && charArray[j]<='z') || (charArray[j] >= '0' && charArray[j] <= '9')))
                j--;
            if(i<=charArray.length-1 && j>=0)
                if(charArray[i] == charArray[j])
                    continue;
                else
                    return false;
            else
                break;
        }
        if(i>=j)
            return true;
        return false;
    }

    static class Node{
        int num;
        int count;
        Node(int num,int count){
            this.num = num;
            this.count = count;
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i : nums){
            if(hashMap.get(i) == null){
                hashMap.put(i,1);
            }
            else{
                hashMap.put(i,hashMap.get(i)+1);
            }
        }

        Node[] nodeArray = new Node[hashMap.size()];
        int i=0;
        for(Entry<Integer,Integer> e : hashMap.entrySet()){
            nodeArray[i] = new Node((int)e.getKey(),(int)e.getValue());
            i++;
        } 

        minHeapSort(nodeArray,k);

        List<Integer> intList = new ArrayList<Integer>();
        for(int j=0;j<k;j++)
            intList.add(nodeArray[j].num);
        return intList;
    }
    public static void minHeapSort(Node[] nodeArray,int k){
        int i =0;
        Node temp=null;
        for(i=k/2-1; i>=0;i--){
            adjustMinHeap(nodeArray, i, k-1);
        }
        for(i=k;i<nodeArray.length;i++){
            if(nodeArray[i].count > nodeArray[0].count )
            {
                temp = nodeArray[0];
                nodeArray[0]=nodeArray[i];
                nodeArray[i]=temp;
                adjustMinHeap(nodeArray, 0, k-1);
            }
        }
    }

    public static void adjustMinHeap(Node[] nodeArray, int pos, int len){
        Node temp=null;
        int child=0;
        for(temp=nodeArray[pos];2*pos+1<=len;pos=child){
            child = 2*pos +1;
            if(child < len && nodeArray[child].count > nodeArray[child+1].count)
                child++;
            if(nodeArray[child].count < temp.count)
                nodeArray[pos] = nodeArray[child];
            else
                break;
        }
        nodeArray[pos] = temp;
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
        // -----------------
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //------------------------
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums,k));



    }
}