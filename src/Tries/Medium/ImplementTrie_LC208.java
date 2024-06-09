package Tries.Medium;

import Tries.Trie;

import java.util.Arrays;

public class ImplementTrie_LC208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        String s = "apple apple";
        String[] strings = s.split(" ");
        System.out.println(Arrays.toString(strings));
    }
}
