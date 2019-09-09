// 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
// 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
// 说明：
// 分隔时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。

package leetcodepractice.wordsplit2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        //创建一个二维数组，用来保存行列下标确定的单词是否在字典中，并且前面的字符串都可以拆分
        Boolean[][] splitMask = new Boolean[s.length()+1][s.length()+1];
        int maxLength=Integer.MIN_VALUE;
        int minLength= Integer.MAX_VALUE;

        //找到字典中字符串最大最小长度
        for(String word : wordDict){
            if(word.length() > maxLength)
                maxLength = word.length();
            if(word.length() < minLength)
                minLength = word.length();
        }
        //初始化，splitMask[0]这一行表示从0到j确定的字符串都可以拆分
        splitMask[0][0] = true;
        //遍历字符串，跳过不满足字典中字符串长度的情况
        for(int i = 0; i<s.length(); i++){
            if(i == 0 || i>=minLength){
                for(int j = i+minLength;j<=s.length() && (j-i)<=maxLength; j++){
                    //前面的字符串都可以拆分，同时i和j确定的字符串在字典中才记为true
                    //有不在字典中的字符串的情况时，就不用记为true
                    if(splitMask[0][i] != null &&  wordDict.contains(s.substring(i,j))){
                        //当前由i和j确定的字符串在字典中
                        splitMask[i+1][j] = true;
                        //表示从0到j确定的字符串都可以拆分
                        splitMask[0][j] = true;
                    }
                }
            }
        }
        //输出上面的二维数组
        for(int i =0;i<=s.length();i++)
            for(int j =0;j<=s.length();j++){
                System.out.print(splitMask[i][j] + " ");
                if(j == s.length())
                    System.out.println();
            }
        
        List<String> stringList= new ArrayList<String>();
        String str = "";
        //如果字符串可以拆分，splitMask[0][splitMask[0].length-1]才为true
        //否则有不在字典中的片段时，片段后面的splitMask[0][j]不会为true
        if(splitMask[0][splitMask[0].length-1] != null){
            //递归查找可以拆分的字符串
            makeStringList(splitMask,1,1,stringList,s,str);
        }
        for(String str1 : stringList){
            System.out.println(str1);
        }
        return stringList;
    }

    public static void makeStringList(Boolean[][] splitMask,int i,int j,List<String> stringList,String s,String str){
        for(int k = j; k<splitMask[0].length; k++){
            if(splitMask[i][k] != null){
                //找到字符串结尾，说明整个字符串都也拆分，加入的list中
                if(k == splitMask[0].length-1)
                    stringList.add((str == "")?s.substring(i-1,k) : str+" "+ s.substring(i-1,k));
                else
                    //s[i]到s[k]可以拆分出来，再查找k坐标后面的字符串
                    makeStringList(splitMask,k+1,k+1,stringList,s,(str == "")?s.substring(i-1,k) : str+" "+ s.substring(i-1,k));
            }
        }
    }


    public static void main(String[] args) {
        // String s = "abc";
        // String[] words = {"a","b","ab","c","bc","abc"};
        String s = "aba";
        String[] words = {"a"};
        List<String> wordDict = new ArrayList<String>();
        for (String word : words) {
            wordDict.add(word);
        }
        wordBreak(s,wordDict);
    }
}