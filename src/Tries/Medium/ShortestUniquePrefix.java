package Tries.Medium;

import Tries.Trie;

import java.util.Arrays;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        String[] words = {"zebra","dog","duck","dove"};
        System.out.println(Arrays.toString(getUniquePrefix(words)));
    }
    public static String[] getUniquePrefix(String[] words){

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        String[] res = new String[words.length];
        int i = 0;

        for(String word : words){
            Trie curr = trie;
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(c);
                int index = c - 'a';
                int freq = curr.children[index].freq;
                if(freq <= 1) break;
                curr = curr.children[index];
            }
            res[i++] = sb.toString();
        }
        return res;
    }
}
