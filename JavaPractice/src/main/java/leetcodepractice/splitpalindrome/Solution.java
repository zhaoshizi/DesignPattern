package leetcodepractice.splitpalindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<String>> partition(String s) {
        Boolean[][] palindromeFlag = new Boolean[s.length()+1][s.length()+1];

        palindromeFlag[0][0] = true;

        for(int i = 0; i<=s.length(); i++){

            for(int j = i+1; j<=s.length(); j++){
                if(palindromeFlag[0][i] != null && isPalindrome(s.substring(i, j))){
                    palindromeFlag[i+1][j] = true;
                    palindromeFlag[0][j] = true;
                }
            }
        }

        // for(int i=0; i<=s.length();i++)
        //     for(int j=0;j<=s.length();j++){
        //         System.out.print(palindromeFlag[i][j] + " ");
        //         if(j == s.length())
        //             System.out.println();
        //     }
        
        List<List<String>> llstr= new ArrayList<List<String>>();
        List<String> lstr = new ArrayList<String>();

        makeString(s,1,1,palindromeFlag,lstr,"");

        for (String str : lstr) {
            //System.out.println(str);
            llstr.add(new ArrayList<>(Arrays.asList(str.split(" "))));
        }

        // for(List<String> lstr1:llstr)
        //     System.out.println(lstr1);

        return llstr;
    }

    public static  void makeString(String s,int b,int e,Boolean[][] palindromeFlag,List<String> lstr,String str ){
        if(b>s.length()){
            lstr.add(str);
            return;
        }
            
        for(int i=e;i<=s.length();i++){
            if(palindromeFlag[b][i] != null ){
                makeString(s,i+1,i+1,palindromeFlag,lstr,(str=="")?s.substring(b-1,i):str + " " + s.substring(b-1,i));
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

    private boolean isPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "aa";
        List<List<String>> llstr = partition(str);
        for(List<String> lstr1:llstr)
             System.out.println(lstr1);

    }

}