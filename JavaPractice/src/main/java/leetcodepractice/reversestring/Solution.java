// 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

package leetcodepractice.reversestring;

class Solution {
    public void reverseString(char[] s) {
        char ch;
        for(int i =0; i<s.length-i-1;i++){
            ch = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = ch;
        }
    }
    public static void main(String[] args) {
        //char[] s = {'1','2','3','4'};
        char[] s = {};
        new Solution().reverseString(s);
        System.out.println(s);
    }
}