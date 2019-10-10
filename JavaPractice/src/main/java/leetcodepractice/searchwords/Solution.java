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
        Node headNode = makeTrie(words);
        List<String> strList = new ArrayList<String>();
        String str = "";
        //遍历二维数组，查找一个字符串的起点
        for(int i =0 ;i<board.length;i++)
            for(int j =0; j<board[0].length;j++){
                if(headNode.nodeList[board[i][j] -'a'] != null ){
                    //开始遍历，并判断是否还有分支
                    if(findchar(strList,str,board,headNode,i,j)){
                        //没有分支直接返回
                        return strList;
                    }
                }
            }

        return strList;
    }
    //一个遍历过程，返回值表示该节点是否可以剪枝，返回true为没有分支，可以剪枝
    public boolean findchar(List<String> strList,String str,char[][]board,Node q,int i,int j){
        //开始遍历对应的分支
        Node p = q.nodeList[board[i][j]-'a'];
        //记录遍历的节点，特殊处理，以避免重复遍历
        char c = board[i][j];
        board[i][j] = '@';
        //判断该节点是否为一个字符串的最后一个字符
        if(p.isLeaf == true){
            //如果是最后一个字符，说明查到一个字符串，加到列表里
            strList.add(str+p.ch);
            //修改是否是最后一个字符的标记，避免重复查到同一个字符串
            //以后遍历时，即便同到的路径找到该节点，也不会识别为一个字符串
            p.isLeaf = false;
        }
        //遍历该二维数组元素上下左右四个元素
        for(int k =-1 ;k<=1;k=k+2){
            if(i+k>=0 && i+k<board.length){
                //开始遍历，并判断是否还有分支
                if(board[i+k][j] !='@' && p.num > 0 && p.nodeList[board[i+k][j]-'a'] != null && findchar(strList,str+p.ch,board,p,i+k,j))
                    //没有分支就直接返回
                    break;
            }
            if(j+k>=0 && j+k<board[0].length){
                //开始遍历，并判断是否还有分支
                if(board[i][j+k] !='@' && p.num > 0 && p.nodeList[board[i][j+k]-'a'] != null && findchar(strList,str+p.ch,board,p,i,j+k))
                    //没有分支就直接返回
                    break;
            }    
        }
        //恢复该节点的值
        board[i][j] = c;
        //还有分支表示不能剪枝
        if (p.num>0)
            return false;
        else{
            //p是q的子节点，p没有分支，可以在q里去掉p分支
            q.nodeList[board[i][j]-'a'] = null;
            q.num--;
        }
        //返回q是否还有分支
        return q.num==0;
    }

    public static void main(String[] args) {
        // String[] words = {"oath","pea","eat","rain"};
        // char[][] board ={
        //                 {'o','a','a','n'},
        //                 {'e','t','a','e'},
        //                 {'i','h','k','r'},
        //                 {'i','f','l','v'}
        //                 };
        // String[] words = {"aaa"};
        // char[][] board ={{'a','a'}};
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        char[][] board ={{'a','b'},{'a','a'}};
        List<String> strList= new Solution().findWords( board, words);
        for(String str:strList){
            System.out.println(str);
        }
    }
}
