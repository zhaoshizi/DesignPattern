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

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0)
            return false;
        int minLength = s.length();
        int maxLength = 0;
        for (String str : wordDict) {
            if(minLength > str.length())
                minLength = str.length();
            if(maxLength < str.length())
                maxLength = str.length();
        }

        return subWordBreak(s, wordDict, minLength,maxLength);
    }

    public static boolean subWordBreak(String s, List<String> wordDict, int minLength,int maxLength){
        System.out.println(s);
        if (s.length() < minLength)
            return false;
        if(s.length() > maxLength)
            return false;
        if (wordDict.contains(s))
            return true;
        else if(s.length() == minLength)
            return false;
        for(int i = minLength; i<=s.length()-minLength+1;i++){
            if(subWordBreak(s.substring(0, i), wordDict, minLength,maxLength) && subWordBreak(s.substring(i), wordDict, minLength,maxLength))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab";
        String[] words = {"a"};
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