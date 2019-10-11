// 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

// 案例:

// s = "leetcode"
// 返回 0.

// s = "loveleetcode",
// 返回 2.

package leetcodepractice.firstuniqchar;

class Solution {
    public int firstUniqChar(String s) {
        int[] chlist = new int[26];
        for(int i=0;i<chlist.length;i++)
            chlist[i] = -1;
        char[] chstr=s.toCharArray();
        for(int i=0;i<chstr.length;i++){
            if(chlist[chstr[i]-'a'] ==-1)
                chlist[chstr[i]-'a'] =i;
            else if(chlist[chstr[i]-'a'] >= 0)
                chlist[chstr[i]-'a'] =-2;
        }
        int minIndex=s.length();
        for(int i =0;i<chlist.length;i++){
            if(chlist[i]>=0 && chlist[i]<minIndex){
                minIndex = chlist[i];
            }
        }
        if (minIndex==s.length())
            minIndex =-1;
        return minIndex;
    }
    public static void main(String[] args) {
        String s= "loveleetcode";
        System.out.println(new Solution().firstUniqChar(s));
        
    }
}