package leetcodepractice.trie;

class Node{
    char c=' ';
    boolean isLeaf = false;
    Node[] nodeArray = new Node[26];
    Node(char c){
        this.c = c;
        this.isLeaf = false;
    }
}

public class Trie{
    public Node root;
    public Trie(){
        root = new Node(' ');
    }

    public void insert(String word){
        char[] charArray = word.toCharArray();
        Node node = root;
        int i =0;
        while(i<charArray.length){
            if( node.nodeArray[charArray[i]-'a'] == null){
                node.nodeArray[charArray[i]-'a'] = new Node(charArray[i]);
                node = node.nodeArray[charArray[i]-'a'];
                i++;
            }
            else{
                node = node.nodeArray[charArray[i]-'a'];
                i++;
            }
        }
        node.isLeaf = true;
    }

    public boolean search(String word){
        char[] charArray = word.toCharArray();
        Node node = root;
        int i =0;
        while(i<charArray.length){
            if(node.nodeArray[charArray[i]-'a'] != null){
                node = node.nodeArray[charArray[i]-'a'];
                i++;
            }
                
            else
                break;
        }
        if(i==charArray.length){
            if (node.isLeaf == true)
                return true;
            return false;    
        }
        else 
            return false;
    }

    public boolean startsWith(String prefix){
        char[] charArray = prefix.toCharArray();
        Node node = root;
        int i =0;
        while(i<charArray.length){
            if(node.nodeArray[charArray[i]-'a'] != null){
                node = node.nodeArray[charArray[i]-'a'];
                i++;
            }
            else
                break;
        }
        if(i==charArray.length){
            return true;
        }
        else 
            return false;
    }

    public static void main(String args[]){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");   
        System.out.println(trie.search("app"));
    }
}