package leecodepractice.wordsplit;
import java.util.ArrayList;
import java.util.List;

// 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分
//为一个或多个在字典中出现的单词。

// 说明：
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
// 示例 1：
// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true
// 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 示例 2：
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
// 输出: true
// 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//      注意你可以重复使用字典中的单词。
// 示例 3：
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// 输出: false

public class Solution {
    //动态规划
    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] flag = new int[s.length()+1];

        if (wordDict.size() == 0)
            return false;
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (String str : wordDict) {
            if(minLength > str.length())
                minLength = str.length();
            if(maxLength < str.length())
                maxLength = str.length();
        }
        flag[0] = 1;
        for(int i =0; i<=s.length(); i++){
            //字符串分两部分，前一部分长度为0或大于等于最小长度才执行
            if(i>=minLength || i==0 ){
                //后一部分大于最大长度不执行
                for(int j =i+minLength; j<=s.length()&&(j-i)<=maxLength; j++){
                    if(flag[i] ==1 && wordDict.contains(s.substring(i,j))){
                        flag[j] = 1;
                        if (flag[s.length()]==1)
                            return true;
                    }
                }
            }      
        }
        return flag[s.length()]==1;

    }


    //笨办法，时间复杂度高
    public static boolean wordBreak1(String s, List<String> wordDict) {
        if (wordDict.size() == 0)
            return false;
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (String str : wordDict) {
            if(minLength > str.length())
                minLength = str.length();
            if(maxLength < str.length())
                maxLength = str.length();
        }

        return subWordBreak(s, wordDict, minLength,maxLength);
    }

    public static boolean subWordBreak(String s, List<String> wordDict, int minLength,int maxLength){
        //System.out.println(s);
        if (s.length() < minLength)
            return false;
        if (wordDict.contains(s))
            return true;
        for(int i = maxLength; i>0 ;i--){
            if(s.length()>= i && wordDict.contains(s.substring(0, i)) && subWordBreak(s.substring(i), wordDict, minLength,maxLength))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        // String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        String s = "a";
        String[] words = {};
        List<String> wordDict = new ArrayList<String>();
        for (String word : words) {
            wordDict.add(word);
        }
        if(wordBreak(s,wordDict))
            System.out.println("true");
        else
            System.out.println("false");
    }
}