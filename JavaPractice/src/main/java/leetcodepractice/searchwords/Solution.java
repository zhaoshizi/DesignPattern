package leetcodepractice.searchwords;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class Node{
        char ch=' ';
        boolean isLeaf = false;
        Node[] nodeList = new Node[26];
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
                    q = p;
                    p = p.nodeList[ch-'a'];
                }else{
                    q = p;
                    p = p.nodeList[ch-'a'];
                }
                
                q.isLeaf = true;
            }
        }
        return headNode;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        return new ArrayList<String>();
    }

    public static void main(String[] args) {
        
    }
}