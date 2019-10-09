// 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
// 同一个单元格内的字母在一个单词中不允许被重复使用。

// 示例:

// 输入: 
// words = ["oath","pea","eat","rain"] and board =
// [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]

// 输出: ["eat","oath"]

package leetcodepractice.searchwords;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class Node{
        char ch=' ';
        boolean isLeaf = false;
        Node[] nodeList = new Node[26];
        int num =0;
        Node(char ch,boolean isLeaf){
            this.ch = ch;
            this.isLeaf = isLeaf;
        }
    }

    public Node makeTrie(String[] strList){

        Node headNode = new Node(' ',false);
        for (String str : strList) {
            char[] chList = str.toCharArray();
            Node p = headNode;
            Node q = p;
            for (char ch : chList) {
                if(p.nodeList[ch-'a'] == null){
                    p.nodeList[ch-'a'] = new Node(ch,false);
                    p.num++;
                    q = p;
                    p = p.nodeList[ch-'a'];
                }else{
                    q = p;
                    p = p.nodeList[ch-'a'];
                }   
            }
            p.isLeaf = true;
        }
        return headNode;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        Node headNode = makeTrie(words);
        List<String> strList = new ArrayList<String>();
        String str = "";
        for(int i =0 ;i<n;i++)
            for(int j =0; j<m;j++){
                if(headNode.nodeList[board[i][j] -'a'] != null ){
                    char c = board[i][j];
                    board[i][j] = Character.toUpperCase(board[i][j]);
                    if(findchar(strList,str+c,board,headNode.nodeList[c-'a'],i,j)){
                        headNode.nodeList[c-'a'] =null;
                        headNode.num--;
                        if(headNode.num ==0)
                            return strList;
                    }
                    board[i][j] = c ;
                }
            }

        return strList;
    }

    public boolean findchar(List<String> strList,String str,char[][]board,Node p,int i,int j){

        if(p.isLeaf == true){
            strList.add(str);
            return true;
        }
        for(int k =-1 ;k<=1;k=k+2){
            if(i+k>=0 && i+k<board.length){
                if(board[i+k][j]>='a' && p.nodeList[board[i+k][j]-'a'] != null){
                    char c = board[i+k][j];
                    board[i+k][j] = Character.toUpperCase(board[i+k][j]);
                    if(findchar(strList,str+c,board,p.nodeList[c-'a'],i+k,j)){
                        p.nodeList[c-'a'] = null;
                        p.num--;
                        if(p.num==0){
                            board[i+k][j] = c;
                            return true;
                        }
                    } 
                    board[i+k][j] = c;
                }  
            }
            if(j+k>=0 && j+k<board[0].length){
                if(board[i][j+k]>='a' && p.nodeList[board[i][j+k]-'a'] != null){
                    char c = board[i][j+k];
                    board[i][j+k] = Character.toUpperCase(board[i][j+k]);
                    if(findchar(strList,str+c,board,p.nodeList[c-'a'],i,j+k)){
                        p.nodeList[c-'a'] = null;
                        p.num--;
                        if(p.num==0){
                            board[i][j+k] = c;
                            return true;
                        }
                    }   
                    board[i][j+k] = c;
                }
            }    
        }
        if (p.num>0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board ={
                        {'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}
                        };
        // String[] words = {"aaa"};
        // char[][] board ={{'a','a'}};
        List<String> strList= new Solution().findWords( board, words);
        for(String str:strList){
            System.out.println(str);
        }
    }
}

// 输入：
// [["a","b"],["a","a"]]
// ["aba","baa","bab","aaab","aaa","aaaa","aaba"]
// 输出：
// ["aaa","aba","baa","aaba"]
// 预期：
// ["aaa","aaab","aaba","aba","baa"]