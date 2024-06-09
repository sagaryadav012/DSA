package Tries;

public class Trie {
    public Trie[] children;
    public int freq;
    public boolean endOfWord;

    public Trie(){
        this.children = new Trie[26];
        this.endOfWord = false;
    }

    public void insert(String word){
        Trie curr = this;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                Trie child = new Trie();
                curr.children[index] = child;
            }
            curr.children[index].freq++;
            curr = curr.children[index];

        }
        curr.endOfWord = true;
    }
    public boolean search(String word){
        Trie curr = this;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.endOfWord;
    }
    public boolean startWith(String word){
        Trie curr = this;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}
