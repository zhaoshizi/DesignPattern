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
        //表示是否是一个字符串的最后一个字符
        boolean isLeaf = false;
        Node[] nodeList = new Node[26];
        //该字符后还有几个分支，如果没有分支了，就可以剪掉该节点
        //即从父节点去掉该节点，不会再遍历该节点
        int num =0;
        Node(char ch,boolean isLeaf){
            this.ch = ch;
            this.isLeaf = isLeaf;
        }
    }
    //创建前缀树
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
            //标识该字符是一个字符中的最后一位
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
        //遍历二维数组，查找一个字符串的起点
        for(int i =0 ;i<n;i++)
            for(int j =0; j<m;j++){
                if(headNode.nodeList[board[i][j] -'a'] != null ){
                    char c = board[i][j];
                    //特殊处理，把字符变为大写，避免在同一个遍历过程中重复遍历
                    board[i][j] = Character.toUpperCase(board[i][j]);
                    //开始遍历，并判断是否可以剪枝
                    if(findchar(strList,str+c,board,headNode.nodeList[c-'a'],i,j)){
                        headNode.nodeList[c-'a'] =null;
                        //若剪权，则减少分支
                        headNode.num--;
                        //分支减为零，则直接返回
                        if(headNode.num ==0)
                            return strList;
                    }
                    //还原来还字符
                    board[i][j] = c ;
                }
            }

        return strList;
    }
    //一个遍历过程，返回值表示该节点是否可以剪枝，返回true为没有分支，可以剪枝
    public boolean findchar(List<String> strList,String str,char[][]board,Node p,int i,int j){
        //判断该节点是否为一个字符串的最后一个字符
        if(p.isLeaf == true){
            //如果是最后一个字符，说明查到一个字符串，加到列表里
            strList.add(str);
            //修改是否是最后一个字符的标记，避免重复查到同一个字符串
            //以后遍历时，即便同到的路径找到该节点，也不会识别为一个字符串
            p.isLeaf = false;
        }
        //遍历该二维数组元素上下左右四个元素
        for(int k =-1 ;k<=1;k=k+2){
            if(i+k>=0 && i+k<board.length){
                //先判断该元素不是大写字母，因为大写字母是遍历过的
                if(board[i+k][j]>='a' && p.nodeList[board[i+k][j]-'a'] != null){
                    char c = board[i+k][j];
                    board[i+k][j] = Character.toUpperCase(board[i+k][j]);
                    if(findchar(strList,str+c,board,p.nodeList[c-'a'],i+k,j)){
                        p.nodeList[c-'a'] = null;
                        p.num--;
                        if(p.num==0){
                            board[i+k][j] = c;
                            //没有分支，可以把该节点从前缀树中去掉
                            return true;
                        }
                    } 
                    board[i+k][j] = c;
                }  
            }
            if(j+k>=0 && j+k<board[0].length){
                //先判断该元素不是大写字母，因为大写字母是遍历过的
                if(board[i][j+k]>='a' && p.nodeList[board[i][j+k]-'a'] != null){
                    char c = board[i][j+k];
                    board[i][j+k] = Character.toUpperCase(board[i][j+k]);
                    if(findchar(strList,str+c,board,p.nodeList[c-'a'],i,j+k)){
                        p.nodeList[c-'a'] = null;
                        p.num--;
                        if(p.num==0){
                            board[i][j+k] = c;
                            //没有分支，可以把该节点从前缀树中去掉
                            return true;
                        }
                    }   
                    board[i][j+k] = c;
                }
            }    
        }
        //还有分支表示不能剪枝
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
        // String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        // char[][] board ={{'a','b'},{'a','a'}};
        List<String> strList= new Solution().findWords( board, words);
        for(String str:strList){
            System.out.println(str);
        }
    }
}
