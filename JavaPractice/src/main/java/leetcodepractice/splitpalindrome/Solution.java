package leetcodepractice.splitpalindrome;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<String>> partition(String s) {
        Boolean[][] palindromeFlag = new Boolean[s.length()+1][s.length()+1];

        palindromeFlag[0][0] = true;

        for(int i = 0; i<=s.length(); i++){

            for(int j = i+1; j<=s.length(); j++){
                if(palindromeFlag[0][i] == true && isPalindrome(s.substring(i, j))){
                    palindromeFlag[i+1][j] = true;
                    palindromeFlag[0][j] = true;
                }
            }
        }

        for(int i=0; i<=s.length();i++)
            for(int j=0;j<=s.length();j++){
                System.out.print(palindromeFlag[i][j] + " ");
                if(j == s.length())
                    System.out.println();
            }
        
        List<List<String>> llstr= new ArrayList<List<String>>();
        List<String> lstr = new ArrayList<String>();

        for(int i =1;i<=s.length();i++){
            for(int j =i;j<=s.length();j++){

            }
        }

        return new  ArrayList<List<String>>() ;
    }

    public static  void makeString(String s,int b,int e,Boolean[][] palindromeFlag,List<List<String>> llstr,List<String> lstr ){
        for(int i=0;e+i<=s.length();i++){
            if(palindromeFlag[b][e] == true ){
                lstr.add(s.substring(b-1,e));
            }
        }
        

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

    public static void main(String[] args) {
        String str = "aab";
        partition(str);

    }

}