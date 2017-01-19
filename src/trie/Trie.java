/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dichha
 */
class TrieNode{
 char c;
 HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
 boolean isLeaf;
 public TrieNode(){}
 public TrieNode(char c){
     this.c = c;
 }
 
}
public class Trie {
    
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    //Insert a word into the trie
    public void insert(String word){
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        for(int i=0; i <word.length(); i++){
            char c = word.charAt(i);
            
            TrieNode t ;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            
            //set leafNode
            if (i == word.length()-1){
                t.isLeaf = true;
            }
        }
    }
    //return of the word is in the trie
    public boolean search(String word){
        TrieNode t = searchNode(word);
        if(t != null && t.isLeaf){
            return true;
        }else{
            return false;
        }
    }
    //return if there is any word in the trie that starts with a prefix
    public boolean startsWith(String prefix){
        if (searchNode(prefix) != null){
            return true;
        }else{
            return false;
        }
    }
    
    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
        return t;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
