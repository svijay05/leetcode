package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    // heart of the code is
    class Node {

        private char value;
        private boolean isWord;
        private Node[] children; // size of 26

        public Node(char val) {
            this.value = val;
            this.isWord = false;
            this.children = new Node[26];
        }
    }


    Node root;

    public Trie() {
        root = new Node('\0'); //dummy node
    }

    public void insert(String word) {
        Node curr = root;
        for (char x : word.toCharArray()) {
            if (curr.children[x - 'a'] == null) {
                curr.children[x - 'a'] = new Node(x);
            }
            curr = curr.children[x - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node res = getLast(word);
        return (res != null && res.isWord);
    }

    //helper method
    public Node getLast(String word) {
        Node curr = root;
        for (char x : word.toCharArray()) {
            if (curr.children[x - 'a'] == null) {
                return null;
            }

            curr = curr.children[x - 'a'];
        }
        return curr;
    }

    public boolean startsWith(String prefix) {
        Node res = getLast(prefix);
        if (res == null) return false;
        return true;
    }


    public static void main(String[] args) {
        
        String s = "abc" ;
        Trie t  = new Trie();
        t.insert("apple");
        System.out.println( t.search("apple") );
        System.out.println( t.search("app") );
        System.out.println( t.startsWith("app") );
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map =  new HashMap<>();

        for(String s: strs){
            char[] a = s.toCharArray();
            Arrays.sort(a);

            String ns = String.valueOf(a);
            List<String> l = map.getOrDefault(ns, new ArrayList<>());
            l.add(s);
            
            map.put(ns,l);

        }
        Collection<List<String>> r = map.values();
        return (List<List<String>>) map.values();
    }


}
